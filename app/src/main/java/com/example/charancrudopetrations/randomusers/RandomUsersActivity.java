package com.example.charancrudopetrations.randomusers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.charancrudopetrations.BaseItemsAdapter;
import com.example.charancrudopetrations.databinding.ActivityRandomUsersBinding;
import com.example.charancrudopetrations.model.User;
import com.example.charancrudopetrations.network.random.RandomPeopleApi;
import com.example.charancrudopetrations.network.random.RandomUserService;
import com.example.charancrudopetrations.network.random.UsersApi;
import com.example.charancrudopetrations.network.random.UsersService;
import com.example.charancrudopetrations.userdetails.UserDetailsActivity;
import com.example.charancrudopetrations.users.OnUsersActionListener;
import com.example.charancrudopetrations.users.UsersActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RandomUsersActivity extends AppCompatActivity {

    private ActivityRandomUsersBinding binding;
    private List<User> users = new ArrayList<>();
    private BaseItemsAdapter baseItemsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRandomUsersBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setupAdapter();
        setupRandomUsersRv();
        fetchRandomUsers();
    }

    private void setupAdapter() {
        baseItemsAdapter = new BaseItemsAdapter(users);
        baseItemsAdapter.setShowSave(true);
        baseItemsAdapter.setOnUsersActionListener(new OnUsersActionListener() {
            @Override
            public void OnDeleteClicked(String id) {

            }

            @Override
            public void OnDetailsClicked(User user) {
                updateRandomUsersData(user);
            }

            @Override
            public void OnSaveClicked(User user) {
                createUser(user);
            }
        });
    }

    private void setupRandomUsersRv() {
        binding.randomUsersRv.setLayoutManager(new LinearLayoutManager(this));
        binding.randomUsersRv.setAdapter(baseItemsAdapter);
    }

    private void fetchRandomUsers() {
        RandomUserService randomUserService = new RandomPeopleApi().createRandomPeopleService();
        Call<List<User>> call = randomUserService.fetchRandomPeople();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                baseItemsAdapter.setData(response.body());
                Toast.makeText(RandomUsersActivity.this, "Success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Toast.makeText(RandomUsersActivity.this, "Fetch failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void createUser(User user) {
        UsersService usersService = new UsersApi().createUsersService();
        Call<User> call = usersService.createCrudUser(user);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Toast.makeText(RandomUsersActivity.this, "Success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(RandomUsersActivity.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void updateRandomUsersData(User user) {
        Intent randomUsersIntent = new Intent(this, UserDetailsActivity.class);
        randomUsersIntent.putExtra("randomUser", user);
        startActivity(randomUsersIntent);
    }
}