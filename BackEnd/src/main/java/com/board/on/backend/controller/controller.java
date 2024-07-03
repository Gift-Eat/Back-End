package com.board.on.backend.controller;

import com.board.on.backend.entity.Gifticon;
import com.board.on.backend.service.BEService;
import com.board.on.backend.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class controller {
    @Autowired
    private BEService beService;
    @Autowired
    private ImageService imageService;
    @GetMapping("/be/create")
    public String createForm(){
        return "create";
    }
    @PostMapping("/be/createpro")
    public String createFormPro(@RequestParam("file") MultipartFile file, Gifticon gifticon, Model model) {
        try {
            Gifticon originalImage = imageService.saveImage(file);
            gifticon.setFileName(originalImage.getFileName());
            gifticon.setFilePath(originalImage.getFilePath());
            beService.write(gifticon);
            model.addAttribute("gifticon", gifticon);
            return "create_success";
        } catch (IOException e) {
            e.printStackTrace();
            return "uploadError";
        }
    }

    @GetMapping("/be/list")
    public String list(Model model){
        model.addAttribute("list", beService.boardList());
        model.addAttribute("gifticon", new Gifticon());
        return "boardlist";
    }
    @GetMapping("/be/delete/{id}")
    public String delete(@PathVariable("id") int id){
        beService.deleteById(id);
        return "redirect:/be/list";
    }
    @PutMapping("/update/{id}")
    public Gifticon update(@PathVariable("id") int id, @RequestBody Gifticon updatedBE){
        return beService.updateById(id, updatedBE);
    }
    @GetMapping("/update")
    public String updateForm(){
        return "update";
    }
}