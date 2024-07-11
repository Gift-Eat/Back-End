package com.board.on.backend.controller;

import com.board.on.backend.entity.Gifticon;
import com.board.on.backend.service.BEService;
import com.board.on.backend.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class JsonController {
    @Autowired
    private BEService beService;
    @Autowired
    private ImageService imageService;
    @PostMapping("/be/createpro")
    public ResponseEntity<Gifticon> createPro(@RequestBody Gifticon gifticon, Model model) {
        beService.write(gifticon);
        model.addAttribute("gifticon", gifticon);
        return ResponseEntity.ok().body(gifticon);
    }



    @PostMapping("/be/create")
    public ResponseEntity<Gifticon> createFormPro(@RequestPart("file") MultipartFile file,@RequestPart("gifticon") Gifticon gifticon, Model model) {
        try {
            Gifticon originalImage = imageService.saveImage(file);
            gifticon.setFileName(originalImage.getFileName());
            gifticon.setFilePath(originalImage.getFilePath());
            beService.write(gifticon);
            model.addAttribute("gifticon", gifticon);
            return ResponseEntity.ok().body(gifticon);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }


    @GetMapping("/be/list")
    public ResponseEntity<List<Gifticon>> list(){
        List<Gifticon> list = beService.boardList();
        return ResponseEntity.ok(list);
    }
    @GetMapping("/be/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id){
        beService.deleteById(id);
        return ResponseEntity.noContent().build();
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