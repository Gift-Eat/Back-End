package com.board.on.backend.entity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Gifticon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gifticon_id;
    @Column(name="gifticon_name")
    private String gifticon_name;
    @Column(name="serial_code")
    private String serial_code;
    @Column(name="expiration_date")
    private Integer expiration_date;
    @Column(name="where_to_use")
    private String where_to_use;
    @Column(name="register_time")
    private String register_time;
    @Column(name="original_image_path")
    private String original_image_path;
    @Column(name="original_image_name")
    private String original_image_name;
    @Column(name="small_image_path")
    private String small_image_path;
    @Column(name="small_image_name")
    private String small_image_name;

    public void className(String gifticon_name, String serial_code, Integer expiration_date, String where_to_use, String register_time){
        this.gifticon_name = gifticon_name;
        this.serial_code = serial_code;
        this.expiration_date = expiration_date;
        this.where_to_use = where_to_use;
        this.register_time = register_time;
    }


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
