package com.example.vj20222;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.vj20222.adapters.contactAdapter;
import com.example.vj20222.entities.contacto;
import com.example.vj20222.services.contactService;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView rvContact = findViewById(R.id.rvContact);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://635765f82712d01e1407281a.mockapi.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        contactService service = retrofit.create(contactService.class);
        service.getAll().enqueue(new Callback<List<contacto>>() {
            @Override
            public void onResponse(Call<List<contacto>> call, Response<List<contacto>> response) {
                List<contacto> data = response.body();

                rvContact.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                rvContact.setAdapter(new contactAdapter(data));

                Log.i("MAIN_APP", "RESPONSE: "+ response.body().size());
                Log.i("MAIN_APP",new Gson().toJson(data));
            }

            @Override
            public void onFailure(Call<List<contacto>> call, Throwable t) {

            }
        });
    }
}