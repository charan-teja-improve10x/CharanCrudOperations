package com.example.charancrudopetrations;

import org.junit.Test;

import static org.junit.Assert.*;

import com.example.charancrudopetrations.model.User;
import com.example.charancrudopetrations.network.random.RandomPeopleApi;
import com.example.charancrudopetrations.network.random.RandomUserService;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void fetchRandomUsers() throws IOException {
        RandomUserService randomUserService = new RandomPeopleApi().createRandomPeopleService();
        Call<List<User>> call = randomUserService.fetchRandomPeople();
        List<User> users = call.execute().body();
        assertNotNull(users);
        assertFalse(users.isEmpty());
        System.out.println(new Gson().toJson(users));
    }
}