package com.example.service.impl;

import com.example.entity.User;
import com.example.mapper.UserMapper;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户 Service 实现类
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean addUser(User user) {
        return userMapper.insertUser(user) > 0;
    }

    @Override
    public boolean deleteUserById(Integer id) {
        return userMapper.deleteUserById(id) > 0;
    }

    @Override
    public boolean updateUserById(User user) {
        return userMapper.updateUser(user) > 0;
    }

    @Override
    public User getUserById(Integer id) {
        return userMapper.selectUserById(id);
    }

    @Override
    public List<User> list() {
        return userMapper.selectAllUser();
    }
}
