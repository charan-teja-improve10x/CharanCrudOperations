package com.example.charancrudopetrations.userdetails;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.charancrudopetrations.R;
import com.example.charancrudopetrations.databinding.ActivityUserDetailsBinding;

public class UserDetailsActivity extends AppCompatActivity {

    private ActivityUserDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        if (getIntent().hasExtra("randomUser")) {
            getIntent().getSerializableExtra("randomUser");
        } else if (getIntent().hasExtra("user")) {
            getIntent().getSerializableExtra("user");
        }
    }
}