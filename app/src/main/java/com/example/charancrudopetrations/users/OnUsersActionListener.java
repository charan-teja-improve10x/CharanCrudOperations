package com.example.charancrudopetrations.users;

import com.example.charancrudopetrations.model.User;

public interface OnUsersActionListener {

    void OnDeleteClicked(String id);

    void OnDetailsClicked(User user);

    void OnSaveClicked(User user);
}
