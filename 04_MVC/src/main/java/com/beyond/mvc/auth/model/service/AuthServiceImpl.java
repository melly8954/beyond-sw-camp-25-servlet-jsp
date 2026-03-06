package com.beyond.mvc.auth.model.service;

import com.beyond.mvc.auth.model.dao.AuthDao;
import com.beyond.mvc.auth.model.dao.AuthDaoImpl;
import com.beyond.mvc.auth.model.vo.User;

import static com.beyond.mvc.common.jdbc.JDBCTemplate.getConnection;
import static com.beyond.mvc.common.jdbc.JDBCTemplate.close;
import static com.beyond.mvc.common.jdbc.JDBCTemplate.commit;
import static com.beyond.mvc.common.jdbc.JDBCTemplate.rollback;

import java.sql.Connection;

public class AuthServiceImpl implements AuthService {
    private final AuthDao authDao;

    public AuthServiceImpl() {
        this.authDao = new AuthDaoImpl();
    }

    @Override
    public User login(String username, String password) {
        User user = null;
        Connection connection = getConnection();

        user = authDao.getUserById(username, connection);

        close(connection);

        if (user == null || !user.getPassword().equals(password)) {
            return null;
        }

        return user;
    }

    @Override
    public int save(User user) {
        int result;
        Connection connection = getConnection();

        if (user.getNo() > 0) {
            // update
            result = authDao.updateUser(user, connection);
        } else {
            // insert
            result = authDao.insertUser(user, connection);
        }

        if (result > 0) {
            commit(connection);
        } else {
            rollback(connection);
        }

        close(connection);

        return result;
    }

    @Override
    public int delete(int no) {
        int result;
        Connection connection = getConnection();

        result = authDao.deleteUser(no, connection);

        if (result > 0) {
            commit(connection);
        } else {
            rollback(connection);
        }

        close(connection);

        return result;
    }
}
