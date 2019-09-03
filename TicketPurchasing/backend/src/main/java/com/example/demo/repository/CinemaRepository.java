package com.example.demo.repository;

import com.example.demo.domain.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface CinemaRepository extends JpaRepository<Cinema,Integer> {
    Cinema findByCId(Integer cId);

    @Query(value = "SELECT c FROM Cinema c WHERE c.cName LIKE %?1%")
    List<Cinema> findByCNameLike(String cName);//影院名字的模糊搜索

    @Transactional
    @Modifying
    @Query(value = "UPDATE Cinema c SET c.cName=?1,c.cAddress=?2 WHERE c.cId=?3")
    String UpdateCinema(String cName,String cAddress,Integer cId);
    //影院信息更新

    @Query(value = "SELECT  c FROM Cinema c WHERE c.cAddress LIKE %?1%")
    List<Cinema> findByCAddressLike(String cAddress);//影院地址的模糊搜索

}
