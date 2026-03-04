package com.beyond.mvc.auth.model.dao;

import com.beyond.mvc.auth.model.vo.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AuthDaoImpl implements AuthDao {
    @Override
    public User getUserById(String username) {

        User user = null;
        Connection connection = null;
        // Statement stmt = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        // String query = "SELECT * FROM user WHERE username = 'admin' AND status ='Y'";
        // String query = "SELECT * FROM user WHERE username = '" + username + "' AND status ='Y'";
        String query = "SELECT * FROM user WHERE username = ? AND status ='Y'";

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mariadb://localhost:3306/web",
                    "beyond",
                    "beyond"
            );

            // stmt = connection.createStatement();
            // rs = stmt.executeQuery(query);

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
                        .hobby(rs.getString("hobby"))
                        .status(rs.getString("status"))
                        .createdAt(rs.getDate("created_at"))
                        .updatedAt(rs.getDate("updated_at"))
                        .build();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                pstmt.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return user;
    }
}
