package com.beyond.mvc.auth.model.service;

import com.beyond.mvc.auth.model.dao.AuthDao;
import com.beyond.mvc.auth.model.dao.AuthDaoImpl;
import com.beyond.mvc.auth.model.vo.User;

public class AuthServiceImpl implements AuthService {
    private final AuthDao authDao;

    public AuthServiceImpl() {
        this.authDao = new AuthDaoImpl();
    }

    @Override
    public User login(String username, String password) {
        User user = null;

        user = authDao.getUserById(username);

        return user;
    }
}
