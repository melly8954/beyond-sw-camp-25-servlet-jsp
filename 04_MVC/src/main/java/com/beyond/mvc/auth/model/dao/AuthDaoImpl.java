package com.beyond.mvc.auth.model.dao;

import com.beyond.mvc.auth.model.vo.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.beyond.mvc.common.jdbc.JDBCTemplate.close;

public class AuthDaoImpl implements AuthDao {
    @Override
    public User getUserById(String username, Connection connection) {

        User user = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String query = "SELECT * FROM user WHERE username = ? AND status ='Y'";

        try {
            pstmt = connection.prepareStatement(query);
            pstmt.setString(1, username);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                user = User.builder()
                        .no(rs.getInt("no"))
                        .username(rs.getString("username"))
                        .password(rs.getString("password"))
                        .role(rs.getString("role"))
                        .nickname(rs.getString("nickname"))
                        .phone(rs.getString("phone"))
                        .email(rs.getString("email"))
                        .address(rs.getString("address"))
                        .hobbies(rs.getString("hobby"))
                        .status(rs.getString("status"))
                        .createdAt(rs.getDate("created_at"))
                        .updatedAt(rs.getDate("updated_at"))
                        .build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs);
            close(pstmt);
        }

        return user;
    }

    @Override
    public int insertUser(User user, Connection connection) {
        int result = 0;
        PreparedStatement pstmt = null;

        String query = "INSERT INTO user VALUES(NULL,?,?,DEFAULT,?,?,?,?,?,DEFAULT,DEFAULT,DEFAULT)";

        try {
            pstmt = connection.prepareStatement(query);
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getNickname());
            pstmt.setString(4, user.getPhone());
            pstmt.setString(5, user.getEmail());
            pstmt.setString(6, user.getAddress());
            pstmt.setString(7, user.getHobbies());

            result = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }

        return result;
    }

    @Override
    public int updateUser(User user, Connection connection) {
        int result = 0;
        PreparedStatement pstmt = null;

        String query = "UPDATE user SET nickname=?,phone=?,email=?,address=?,hobby=?,updated_at=CURDATE() WHERE no=?";

        try {
            pstmt = connection.prepareStatement(query);

            pstmt.setString(1, user.getNickname());
            pstmt.setString(2, user.getPhone());
            pstmt.setString(3, user.getEmail());
            pstmt.setString(4, user.getAddress());
            pstmt.setString(5, user.getHobbies());
            pstmt.setInt(6, user.getNo());

            result = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }

        return result;
    }

    @Override
    public int deleteUser(int no, Connection connection) {
        int result = 0;
        PreparedStatement pstmt = null;

        String query = "DELETE FROM USER WHERE no=?";

        try {
            pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, no);

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }

        return result;
    }

    @Override
    public int updateUserStatus(int no, String status, Connection connection) {
        int result = 0;
        PreparedStatement pstmt = null;

        String query = "UPDATE user SET status=? WHERE no=?";

        try {
            pstmt = connection.prepareStatement(query);
            pstmt.setString(1, status);
            pstmt.setInt(2, no);

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }

        return result;
    }
}
