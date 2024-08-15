package com.board.on.backend.controller;


import com.board.on.backend.DTO.JoinRequest;
import com.board.on.backend.DTO.LoginRequest;
import com.board.on.backend.Util.JwtTokenUtil;
import com.board.on.backend.entity.User;
import com.board.on.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/jwt-login")
public class JwtLoginApiController {
    private final UserService userService;
    @PostMapping("/join")
    public String join(@RequestBody JoinRequest joinRequest) {
        if(userService.checkUserIdDuplicate(joinRequest.getUserId())) {
            return "로그인 아이디 중복";
        }
        if(userService.checkUserNameDuplicate(joinRequest.getUserName())) {
            return "유저 이름 중복";
        }
        if(!joinRequest.getUserPassword().equals(joinRequest.getPasswordCheck())){
            return "비밀번호가 일치하지 않습니다.";
        }
        userService.join(joinRequest);
        return "회원가입 성공";
    }
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        User user = userService.login(loginRequest);
        if(user == null) {
            return "로그인 실패!";
        }
        String secretKey = "my-secret-key-123123";
        long expireTimeMs = 1000*60*60;
        String jwtToken = JwtTokenUtil.createToken(user.getUserId(), secretKey, expireTimeMs);
        return jwtToken;
    }
    @GetMapping("/info")
    public String userInfo(@AuthenticationPrincipal User user){
        if(user == null) {
            return "사용자 정보가 없습니다";
        }
        return String.format("userId : %s\nusername : %s\nrole:%s",
                user.getUserId(), user.getUserName(), user.getRole());
    }
}
