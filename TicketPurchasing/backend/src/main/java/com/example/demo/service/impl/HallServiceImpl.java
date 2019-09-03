package com.example.demo.service.impl;

import com.example.demo.domain.Hall;
import com.example.demo.repository.HallRepository;
import com.example.demo.service.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HallServiceImpl implements HallService {
    @Autowired
    private HallRepository hallRepository;


    @Override
    public String CreateHall(Hall hall) {
        boolean flag=false;
        try {
            hallRepository.save(hall);
            flag=true;
        }
        catch (Exception e){
            System.out.println(e);
        }
        if(flag){return "true";}
        else {return "false";}
    }

    @Override
    public String DeleteHall(Integer hId) {
        boolean flag=false;
        try {
            hallRepository.delete(hId);
            flag=true;
        }
        catch (Exception e){
            System.out.println(e);
        }
        if(flag){return "true";}
        else {return "false";}
    }

    @Override
    public String UpdateHall(Integer colNum, Integer rowNum, Integer hId) {
        boolean flag=false;
        Hall hall=hallRepository.findByHId(hId);
        if(hall==null){
            return "null";
        }
        else {
            try {
                hallRepository.UpdateHall(colNum,rowNum,hId);
                flag=true;
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
        if(flag){return "true";}
        else {return "false";}
    }

    @Override
    public Hall FindByHId(Integer hId) {
        Hall hall=hallRepository.findByHId(hId);
        return hall;
    }

    @Override
    public List<Hall> FindAll() {
        return hallRepository.findAll();
    }
}
