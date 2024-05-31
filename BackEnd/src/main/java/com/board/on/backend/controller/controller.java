package com.board.on.backend.controller;

import com.board.on.backend.entity.BE;
import com.board.on.backend.service.BEService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class controller {
    @Autowired
    private BEService beService;

    @GetMapping("/be/create")
    public String createForm(){
        return "create";
    }
    @PostMapping("/be/createpro")
    public String createFormPro(BE be){
        beService.write(be);
        return "create_success";
    }
}
