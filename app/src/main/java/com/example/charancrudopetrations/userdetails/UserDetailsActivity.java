package com.example.charancrudopetrations.userdetails;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.charancrudopetrations.R;
import com.example.charancrudopetrations.databinding.ActivityUserDetailsBinding;
import com.example.charancrudopetrations.model.User;

public class UserDetailsActivity extends AppCompatActivity {

    private ActivityUserDetailsBinding binding;
    private User user;
    private Boolean showSave = false;
    private Boolean showDelete = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        checkReceivedData();
        showData();
    }

    private void checkReceivedData() {
        if (getIntent().hasExtra("randomUser")) {
            user = (User) getIntent().getSerializableExtra("randomUser");
            binding.setShowSave(true);
        } else if (getIntent().hasExtra("user")) {
            user = (User) getIntent().getSerializableExtra("user");
            binding.setShowDelete(true);
        }
    }

    private void showData() {
        binding.setUser(user);
    }
}