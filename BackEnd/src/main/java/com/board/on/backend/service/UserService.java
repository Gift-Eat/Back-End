package com.board.on.backend.service;


import com.board.on.backend.DTO.JoinRequest;
import com.board.on.backend.DTO.LoginRequest;
import com.board.on.backend.entity.User;
import com.board.on.backend.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public boolean checkUserIdDuplicate(String userId){
        return userRepository.existsByUserId(userId);
    }
    public boolean checkUserNameDuplicate(String userName){
        return userRepository.existsByUserName(userName);
    }
    public void join(JoinRequest req) {
        userRepository.save(req.toEntity());
    }
    public User login(LoginRequest req) {
        Optional<User> optionalUser = userRepository.findByUserId(req.getUserId());
        if (optionalUser.isEmpty()) {
            return null;
        }
        User user = optionalUser.get();
        if(!user.getUserPassword().equals(req.getUserPassword())){
            return null;
        }
        return user;
    }
    public User getLoginUserById(String userId){
        if(userId == null) return null;
        Optional<User> optionalUser = userRepository.findByUserId(userId);
        if(optionalUser.isEmpty()) return null;
        return optionalUser.get();
    }
    public void deleteByName(String userName){
        Optional<User>optionalUser = userRepository.findByUserName(userName);
        if(optionalUser.isPresent()){
            userRepository.deleteById(optionalUser.get().getUserCode());
        }
        else{
            throw new RuntimeException("User not found : " + userName);
        }
    }
}
