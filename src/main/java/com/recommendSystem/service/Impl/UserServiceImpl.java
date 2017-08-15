package com.recommendSystem.service.Impl;

import com.recommendSystem.model.User;
import com.recommendSystem.repository.UserRepository;
import com.recommendSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void addUser(User user) {
        userRepository.addUser(user);
    }

    @Override
    public User fetchUser(long imei) {
        return userRepository.fetchUser(imei);
    }

    @Override
    public void updateUser(User user) {
        userRepository.updateUser(user);
    }

    @Override
    public boolean isExist(User user) {
        return userRepository.isExist(user);
    }
}