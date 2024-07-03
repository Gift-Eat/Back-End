package com.board.on.backend.service;
import com.board.on.backend.entity.Gifticon;
import com.board.on.backend.repository.BERepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BEService{
    @Autowired
    private BERepository beRepository;  //BE레포지토리를 jpa레포지토리로부터 받아왔기에 그 안의 기능 사용 가능
    public void write(Gifticon be){ //write라는 메소드를 BE레포지토리안의 save라는 기능으로 지정 그 안에 넣는 것이 엔티티로 받아 온 값
        beRepository.save(be);
    }
    public List<Gifticon> boardList(){
        return beRepository.findAll();
    }
    public void deleteById(int id){
        beRepository.deleteById(id);
    }
    public Gifticon updateById(Integer id, Gifticon updatedBE) {
        Optional<Gifticon> optionalBE = beRepository.findById(id);
        if (optionalBE.isPresent()) {
            Gifticon existingBE = optionalBE.get();
            existingBE.setGifticon_name(updatedBE.getGifticon_name());
            existingBE.setSerial_code(updatedBE.getSerial_code());
            existingBE.setExpiration_date(updatedBE.getExpiration_date());
            existingBE.setWhere_to_use(updatedBE.getWhere_to_use());
            existingBE.setRegister_time(updatedBE.getRegister_time());
            return beRepository.save(existingBE);
        } else {
            return null;
        }
    }
}