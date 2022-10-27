package com.example.vj20222.services;

import com.example.vj20222.entities.contacto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface contactService {
    @GET("contacts")
    Call<List<contacto>> getAll();
}
