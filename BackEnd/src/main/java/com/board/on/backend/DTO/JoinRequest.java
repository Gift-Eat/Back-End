package com.board.on.backend.DTO;
import com.board.on.backend.role.UserRole;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.board.on.backend.entity.User;
@Getter
@Setter
@NoArgsConstructor
public class JoinRequest {
    private String userId;
    private String userPassword;
    private String passwordCheck;
    private String userName;
    public User toEntity() {
        return User.builder()
                .userId(this.userId)
                .userPassword(this.userPassword)
                .userName(this.userName)
                .role(UserRole.USER)
                .build();
    }
}
