package com.example.demo.service;

import com.example.demo.domain.Cinema;

import java.util.List;

public interface CinemaService {
    String CreateCinema(Cinema cinema);
    String DeleteCinema(Integer cId);
    String UpdateCinema(String cName,String cAddress,Integer cId);

    Cinema FindByCId(Integer cId);
    List<Cinema> FindAll();
    List<Cinema> FindByCNameLike(String cName);//影院名字的模糊搜索
    List<Cinema> FindByCAddressLike(String cAddress);//影院地址的模糊搜索

}
