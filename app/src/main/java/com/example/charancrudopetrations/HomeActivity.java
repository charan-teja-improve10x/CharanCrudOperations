package com.example.charancrudopetrations;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.charancrudopetrations.databinding.ActivityHomeBinding;
import com.example.charancrudopetrations.randomusers.RandomUsersActivity;
import com.example.charancrudopetrations.users.UsersActivity;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding  binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        handleRandomUsersBtn();
        handleUsersBtn();
    }

    private void handleRandomUsersBtn() {
        binding.randomUsersBtn.setOnClickListener(v -> {
            Intent randomUsersIntent = new Intent(this, RandomUsersActivity.class);
            startActivity(randomUsersIntent);
        });
    }

    private void handleUsersBtn()  {
        binding.usersBtn.setOnClickListener(v -> {
            Intent usersIntent = new Intent(this, UsersActivity.class);
            startActivity(usersIntent);
        });
    }
}