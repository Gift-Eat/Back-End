package com.board.on.backend.repository;
import com.board.on.backend.entity.BE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BERepository extends JpaRepository<BE, Integer> {   //jpa레포지토리를 상속받아오기 BE레포지토리에
}
