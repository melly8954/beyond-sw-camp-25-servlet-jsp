package com.beyond.mvc.auth.model.dao;

import com.beyond.mvc.auth.model.vo.User;

import java.sql.Connection;

public interface AuthDao {
    User getUserById(String username, Connection connection);
    int insertUser(User user, Connection connection);
}
