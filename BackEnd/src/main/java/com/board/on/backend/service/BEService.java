package com.board.on.backend.service;
import com.board.on.backend.entity.BE;
import com.board.on.backend.repository.BERepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BEService{

    @Autowired
    private BERepository beRepository;  //BE레포지토리를 jpa레포지토리로부터 받아왔기에 그 안의 기능 사용 가능

    public void write(BE be){ //write라는 메소드를 BE레포지토리안의 save라는 기능으로 지정 그 안에 넣는 것이 엔티티로 받아 온 값
        beRepository.save(be);
    }
}