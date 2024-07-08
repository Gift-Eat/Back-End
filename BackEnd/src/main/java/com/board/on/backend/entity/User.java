package com.board.on.backend.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userCode;
    private String userId;
    private String userPassword;
    private String userName;
    private String createdAt;
    private String email;

    public void setUserId(String user_id) {
        this.userId = user_id;
    }
    public void setUserPassword(String user_password) {
        this.userPassword = user_password;
    }
    public String getUserId(){
        return this.userId;
    }
    public String getUserPassword(){
        return this.userPassword;
    }
    public Integer getUserCode() {
        return this.userCode;
    }


}
