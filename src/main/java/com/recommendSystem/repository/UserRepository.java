package com.recommendSystem.repository;

import com.recommendSystem.model.User;

public interface UserRepository {

    void addUser(User user);

    User fetchUser(long imei);

    void updateUser(User user);

    boolean isExist(User user);

}
