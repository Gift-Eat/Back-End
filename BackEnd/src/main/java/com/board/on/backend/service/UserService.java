package com.board.on.backend.service;


import com.board.on.backend.entity.User;
import com.board.on.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public void write(User user) {userRepository.save(user);}
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
