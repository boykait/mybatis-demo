package com.boykait.user.mapper;

import com.boykait.user.model.User;

import java.util.List;

/**
 * @author boykait
 * @version 1.0
 * @date 2020/2/4 16:40
 */
public interface UserMapper {
    List<User> listUsers();
    User getUserById(String id);
    Integer saveUser(User user);
    Integer updateUser(User user);
    Integer deleteUser(String id);
}
