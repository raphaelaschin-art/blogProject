package com.example.service;

import com.example.entity.User;

import java.util.List;

/**
 * 用户 Service 接口
 */
public interface UserService {

    /**
     * 新增用户
     */
    boolean addUser(User user);

    /**
     * 根据 ID 删除
     */
    boolean deleteUserById(Integer id);

    /**
     * 更新用户
     */
    boolean updateUserById(User user);

    /**
     * 根据 ID 查询
     */
    User getUserById(Integer id);

    /**
     * 查询全部
     */
    List<User> list();

    User selectUserByUsername(String username);

    User selectUserByEmail(String email);

    User selectUserByPhone(String phone);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    List<User> listByGender(Integer gender);

    List<User> listLikeUsername(String username);
}
