package com.board.on.backend.entity;


import com.board.on.backend.role.UserRole;
import jakarta.persistence.*;
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
    @Column(name="user_code")
    private Integer userCode;
    @Column(name="user_id")
    private String userId;
    @Column(name="user_password")
    private String userPassword;
    @Column(name="user_name")
    private String userName;
    @Column(name="created_at")
    private String createdAt;
    private String email;
    private UserRole role;
}
