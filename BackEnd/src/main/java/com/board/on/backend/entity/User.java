package com.board.on.backend.entity;


import com.board.on.backend.role.UserRole;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userCode;
    private String userId;
    private String userPassword;
    private String userName;
    private String createdAt;
    private String email;
    private UserRole role;

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
