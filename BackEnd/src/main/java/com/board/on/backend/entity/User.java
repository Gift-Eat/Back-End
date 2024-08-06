package com.board.on.backend.entity;


import com.board.on.backend.role.UserRole;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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



}
