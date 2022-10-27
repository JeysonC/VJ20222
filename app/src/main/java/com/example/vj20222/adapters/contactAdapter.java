package com.example.vj20222.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vj20222.R;
import com.example.vj20222.entities.contacto;
import com.squareup.picasso.Picasso;

import java.util.List;

public class contactAdapter extends RecyclerView.Adapter {

    List<contacto> data;

    public contactAdapter(List<contacto> data){
        this.data = data;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layout = LayoutInflater.from(parent.getContext());
        View itemContact = layout.inflate(R.layout.item_contact, parent,false);
        return new contactViewHolder(itemContact);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        TextView tvNombre = holder.itemView.findViewById(R.id.tvNombre);
        TextView tvApellido = holder.itemView.findViewById(R.id.tvApellido);
        tvNombre.setText(data.get(position).name);
        tvApellido.setText(data.get(position).lastname);
        ImageView imgContacto = holder.itemView.findViewById(R.id.ivContact);
        Picasso.get().load(data.get(position).imgURL).into(imgContacto);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    class contactViewHolder extends RecyclerView.ViewHolder{

        public contactViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
