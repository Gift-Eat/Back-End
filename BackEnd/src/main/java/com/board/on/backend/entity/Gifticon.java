package com.board.on.backend.entity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Gifticon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gifticon_id;
    private String gifticon_name;
    private String serial_code;
    private Integer expiration_date;
    private String where_to_use;
    private String register_time;
    private String original_image_path;
    private String original_image_name;
    private String small_image_path;
    private String small_image_name;

    public void setGifticon_name(String gifticon_name) {
        this.gifticon_name = gifticon_name;
    }
    public void setSerial_code(String serialCode) {
        this.serial_code = serialCode;
    }
    public void setExpirationDate(Integer expirationDate) {
        this.expiration_date = expirationDate;
    }
    public void setWhere_to_use(String whereToUse) {
        this.where_to_use = whereToUse;
    }
    public void setRegister_time(String registerTime) {
        this.register_time = registerTime;
    }



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
