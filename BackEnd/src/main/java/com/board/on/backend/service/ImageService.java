package com.board.on.backend.service;
import com.board.on.backend.repository.BERepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.board.on.backend.entity.Gifticon;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;


@Service
public class ImageService {
    private static String UPLOAD_DIR = "/Users/jangjaesang/projectImage/";
    @Autowired
    private BERepository beRepository;
    public Gifticon saveImage(MultipartFile file) throws IOException {
        String originalfileName = file.getOriginalFilename();
        Path originalfilepath = Paths.get(UPLOAD_DIR + originalfileName);
        Files.createDirectories(originalfilepath.getParent());
        file.transferTo(originalfilepath.toFile());
        Gifticon gifticon = new Gifticon();
        gifticon.setFileName(originalfileName);
        gifticon.setFilePath(originalfilepath.toString());
        return beRepository.save(gifticon);
    }
    public Gifticon getGifticon(Integer id) {
        return beRepository.findById(id).orElse(null);
    }
}
