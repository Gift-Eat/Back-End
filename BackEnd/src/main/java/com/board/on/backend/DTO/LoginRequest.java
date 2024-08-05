package com.board.on.backend.DTO;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LoginRequest {

    private String userId;
    private String userPassword;
}
