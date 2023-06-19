package com.example.charancrudopetrations.users;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.charancrudopetrations.BaseItemsAdapter;
import com.example.charancrudopetrations.R;
import com.example.charancrudopetrations.databinding.ActivityUsersBinding;
import com.example.charancrudopetrations.model.User;
import com.example.charancrudopetrations.network.random.UsersApi;
import com.example.charancrudopetrations.network.random.UsersService;
import com.example.charancrudopetrations.userdetails.UserDetailsActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UsersActivity extends AppCompatActivity {

    private ActivityUsersBinding binding;
    private List<User> users = new ArrayList<>();
    private BaseItemsAdapter baseItemsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUsersBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setupAdapter();
        setupUsersRv();
        fetchUsers();
    }

    private void setupAdapter() {
        baseItemsAdapter = new BaseItemsAdapter(users);
        baseItemsAdapter.setShowDelete(true);
        baseItemsAdapter.setOnUsersActionListener(new OnUsersActionListener() {
            @Override
            public void OnDeleteClicked(String id) {
                deleteUser(id);
            }

            @Override
            public void OnDetailsClicked(User user) {
                updateUsersData(user);
            }

            @Override
            public void OnSaveClicked(User user) {
            }
        });
    }

    private void setupUsersRv() {
        binding.usersRv.setAdapter(baseItemsAdapter);
        binding.usersRv.setLayoutManager(new LinearLayoutManager(this));
    }

    private void fetchUsers (){
        UsersService usersService = new UsersApi().createUsersService();
        Call<List<User>> call = usersService.fetchCrudUsers();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                Toast.makeText(UsersActivity.this, "Users Fetch Success", Toast.LENGTH_SHORT).show();
                baseItemsAdapter.setData(response.body());
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Toast.makeText(UsersActivity.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void deleteUser(String id) {
        UsersService usersService = new UsersApi().createUsersService();
        Call<Void> call = usersService.deleteCrudUser(id);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                fetchUsers();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(UsersActivity.this, "Delete Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void updateUsersData(User user){
        Intent usersIntent = new Intent(this, UserDetailsActivity.class);
        usersIntent.putExtra("user", user);
        startActivity(usersIntent);
    }
}