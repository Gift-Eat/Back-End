package com.board.on.backend.DTO;
import com.board.on.backend.role.UserRole;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.board.on.backend.entity.User;
@Getter
@Setter
@NoArgsConstructor
public class JoinRequest {
    @NotBlank(message = "로그인 아이디가 비어있습니다")
    private String userId;
    @NotBlank(message = "비밀번호가 비어있습니다")
    private String userPassword;
    private String passwordCheck;
    @NotBlank(message = "이름이 비어있습니다")
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
