package com.example.charancrudopetrations.network.random;

import com.example.charancrudopetrations.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UsersService {

    @GET("charanTaskListItem")
    Call<List<User>> fetchCrudUsers();

    @POST("charanTaskListItem")
    Call<User> createCrudUser (@Body User user);

    @DELETE("charanTaskListItem/{id}")
    Call<Void> deleteCrudUser (@Path("id") String id);
}
