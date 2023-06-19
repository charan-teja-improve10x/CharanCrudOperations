package com.example.charancrudopetrations;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.charancrudopetrations.databinding.BaseItemBinding;
import com.example.charancrudopetrations.model.User;
import com.example.charancrudopetrations.users.OnUsersActionListener;

import java.util.List;

public class BaseItemsAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private List<User> users;

    private Boolean showSave = false;
    private Boolean showDelete = false;

    private OnUsersActionListener onUsersActionListener;

    public BaseItemsAdapter(List<User> users){
        this.users = users;
    }

    public void setData(List<User> users) {
            this.users = users;
            notifyDataSetChanged();
    }

    public void setShowSave(Boolean showSave) {
        this.showSave = showSave;
    }

    public void setShowDelete(Boolean showDelete) {
        this.showDelete = showDelete;
    }

    public void setOnUsersActionListener(OnUsersActionListener onUsersActionListener) {
        this.onUsersActionListener = onUsersActionListener;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        BaseItemBinding binding = BaseItemBinding.inflate(inflater, parent, false);
        BaseViewHolder viewHolder = new BaseViewHolder(binding);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        User user = users.get(position);
        holder.binding.setUser(user);
        holder.binding.setShowSave(showSave);
        holder.binding.setShowDelete(showDelete);
//        holder.binding.nameTxt.setText(user.getName());
//        holder.binding.designationTxt.setText(user.getDesignation());
//        holder.binding.emailTxt.setText(user.getEmail());
//        holder.binding.incomeTxt.setText(String.valueOf(user.getIncomeUsd()));
//        holder.binding.creditScoreTxt.setText(String.valueOf(user.getCreditScore()));
//        holder.binding.addressTxt.setText(user.getAddress().getStreetAddress() + ", " + user.getAddress().getCity() + ", " +
//                user.getAddress().getCountryCode() + user.getAddress().getZipCode());
//        if (showDelete == true) {
//            holder.binding.deleteBtn.setVisibility(View.VISIBLE);
//            holder.binding.saveBtn.setVisibility(View.GONE);
//        }
//        if (showSave == true) {
//            holder.binding.saveBtn.setVisibility(View.VISIBLE);
//            holder.binding.deleteBtn.setVisibility(View.GONE);
//        }
        holder.binding.saveBtn.setOnClickListener(v -> {
            onUsersActionListener.OnSaveClicked(user);
        });
        holder.binding.deleteBtn.setOnClickListener(v -> {
            onUsersActionListener.OnDeleteClicked(user.getId());
        });
        holder.binding.detailsBtn.setOnClickListener(v -> {
            onUsersActionListener.OnDetailsClicked(user);
        });
    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}
