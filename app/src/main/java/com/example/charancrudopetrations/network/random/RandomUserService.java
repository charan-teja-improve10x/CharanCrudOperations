package com.example.charancrudopetrations.network.random;

import com.example.charancrudopetrations.Constants;
import com.example.charancrudopetrations.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RandomUserService {

    @GET(Constants.RANDOM_PEOPLE_END_POINT)
    Call<List<User>> fetchRandomPeople();
}
