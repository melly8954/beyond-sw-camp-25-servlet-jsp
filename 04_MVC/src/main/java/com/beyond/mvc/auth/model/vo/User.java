package com.beyond.mvc.auth.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
public class User {
    private int no;
    private String username;
    private String password;
    private String role;
    private String nickname;
    private String phone;
    private String email;
    private String address;
    private String hobbies;
    private String status;
    private Date createdAt;
    private Date updatedAt;

    public void updateProfile(String nickname, String phone, String email, String address) {
        this.nickname = nickname;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }
}
