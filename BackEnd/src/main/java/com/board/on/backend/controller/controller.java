package com.board.on.backend.controller;

import com.board.on.backend.entity.BE;
import com.board.on.backend.service.BEService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import java.util.List;

@Controller
@RequestMapping("/be")
public class controller {
    @Autowired
    private BEService beService;

    @GetMapping("/create")
    public String createForm(){
        return "create";
    }

    @PostMapping("/createpro")
    public String createFormPro(BE be){
        beService.write(be);
        return "create_success";
    }
    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("list", beService.beList());
        return "boardlist";
    }

    @GetMapping("/listread")
    public List<BE> listread(){
        return beService.beList();
    }

    @GetMapping("/list/{id}")
    public BE get(@PathVariable("id") int id){
        return beService.getById(id);
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
        beService.deleteById(id);
        return "redirect:/be/list";
    }

    @GetMapping("/update")
    public String updateForm(){
        return "update";
    }
    @PutMapping("/update/{id}")
    public BE update(@PathVariable("id") int id, @RequestBody BE updatedBE){
        return beService.updateById(id, updatedBE);
    }

}