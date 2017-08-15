package com.recommendSystem.service;

import com.recommendSystem.model.User;

public interface UserService {

    void addUser(User user);

    User fetchUser(long imei);

    void updateUser(User user);

    boolean isExist(User user);

}
