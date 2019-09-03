package com.example.demo.repository;

import com.example.demo.domain.Hall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface HallRepository extends JpaRepository<Hall,Integer> {
    Hall findByHId(Integer hId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Hall h SET h.colNum=?1,h.rowNum=?2 WHERE h.hId=?3")
    String UpdateHall(Integer colNum,Integer rowNum,Integer hId);

}
