package com.example.charancrudopetrations;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.charancrudopetrations.databinding.BaseItemBinding;

public class BaseViewHolder extends RecyclerView.ViewHolder {

    BaseItemBinding binding;
    public BaseViewHolder(BaseItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}
