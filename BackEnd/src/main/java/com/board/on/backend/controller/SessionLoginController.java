package com.board.on.backend.controller;

import com.board.on.backend.DTO.JoinRequest;
import com.board.on.backend.DTO.LoginRequest;
import com.board.on.backend.entity.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import com.board.on.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/session-login")
public class SessionLoginController {
    private final UserService userService;

    @GetMapping("/")
    public String home(Model model, @SessionAttribute(name="userId", required=false) String userId) {
        model.addAttribute("loginType", "session-login");
        model.addAttribute("pageName", "세션 로그인");

        User loginUser = userService.getLoginUserById(userId);
        if(loginUser != null) {
            model.addAttribute("username", loginUser.getUserName());
        }
        return "home";
    }
    @GetMapping("/join")
    public String joinPage(Model model){
        model.addAttribute("loginType", "session-login");
        model.addAttribute("pageName", "세션 로그인");
        model.addAttribute("joinRequest", new JoinRequest());
        return "joinpage";
    }
    @PostMapping("/joinpro")
    public String join(Model model,@Valid @ModelAttribute JoinRequest joinRequest, BindingResult bindingResult){
        model.addAttribute("loginType", "session-login");
        model.addAttribute("pageName", "세션 로그인");

        if(userService.checkUserIdDuplicate(joinRequest.getUserId())) {
            bindingResult.addError(new FieldError("joinRequest", "userId", "로그인 아이디 중복!"));
        }
        if(userService.checkUserNameDuplicate(joinRequest.getUserName())){
            bindingResult.addError(new FieldError("joinRequest", "userName", "유저명 중복!"));
        }
        if (!joinRequest.getUserPassword().equals(joinRequest.getPasswordCheck())){
            bindingResult.addError(new FieldError("joinRequest", "userPassword", "비밀번호가 불일치!"));
        }
        if(bindingResult.hasErrors()) {
            return "joinpage";
        }
        userService.join(joinRequest);
        return "redirect:/session-login/";
    }

    @GetMapping("/login")
    public String loginPage(Model model){
        model.addAttribute("loginType", "session-login");
        model.addAttribute("pageName", "세션 로그인");
        model.addAttribute("loginRequest", new LoginRequest());
        return "loginpage";
    }
    @PostMapping("/loginpro")
    public ResponseEntity<Map<String, Object>> login(Model model, @RequestBody LoginRequest loginRequest, BindingResult bindingResult, HttpServletRequest httpServletRequest){
        model.addAttribute("loginType", "session-login");
        model.addAttribute("pageName", "세션 로그인");
        Map<String, Object> response = new HashMap<>();
        User user = userService.login(loginRequest);
        if(user == null){
            bindingResult.reject("loginFail", "로그인 실패!");
        }
        if(bindingResult.hasErrors()) {
            response.put("status", HttpStatus.BAD_REQUEST.value());
            response.put("message", "로그인 실패!");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
        httpServletRequest.getSession().invalidate();
        HttpSession session = httpServletRequest.getSession(true);
        session.setAttribute("userId", user.getUserId());
        session.setMaxInactiveInterval(1800);
        response.put("status", "success");
        response.put("message", "로그인 성공!");
        return ResponseEntity.ok(response);
    }
    @GetMapping("/logout")
    public String logout(HttpServletRequest request, Model model){
        model.addAttribute("loginType", "session-login");
        model.addAttribute("pageName", "세션 로그인");
        HttpSession session = request.getSession(false);
        if(session != null){
            session.invalidate();
        }
        return "redirect:/session-login/";
    }
    @GetMapping("/info")
    public String userInfo(Model model, @SessionAttribute(name="userId", required=false) String userId) {
        model.addAttribute("loginType", "session-login");
        model.addAttribute("pageName", "세션 로그인");
        User loginUser = userService.getLoginUserById(userId);
        if(loginUser == null) {
            return "redirect:/session-login/login";
        }
        model.addAttribute("user", loginUser);
        return "info";
    }
}