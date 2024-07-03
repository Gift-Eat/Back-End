package com.board.on.backend.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Gifticon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gifticon_id;
    private String gifticon_name;
    private String serial_code;
    private String expiration_date;
    private String where_to_use;
    private String register_time;
    private Integer category_id;
    private String original_image_path;
    private String original_image_name;
    private String small_image_path;
    private String small_image_name;

    public void setFileName(String fileName){
        this.original_image_name = fileName;
    }
    public String getFileName() {
        return this.original_image_name;
    }
    public void setFilePath(String filePath){
        this.original_image_path = filePath;
    }
    public String getFilePath() {
        return this.original_image_path;
    }
}
