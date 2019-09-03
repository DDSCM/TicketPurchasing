package com.example.demo.service;

import com.example.demo.domain.Hall;

import java.util.List;

public interface HallService {
    String CreateHall(Hall hall);
    String DeleteHall(Integer hId);
    String UpdateHall(Integer colNum,Integer rowNum,Integer hId);

    Hall FindByHId(Integer hId);
    List<Hall> FindAll();
}
