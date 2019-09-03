package com.example.demo.service.impl;

import com.example.demo.domain.Cinema;
import com.example.demo.repository.CinemaRepository;
import com.example.demo.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CinemaServiceImpl implements CinemaService {
    @Autowired
    private CinemaRepository cinemaRepository;

    @Override
    public String CreateCinema(Cinema cinema) {
        boolean flag=false;
        try {
            cinemaRepository.save(cinema);
            flag=true;
        }
        catch (Exception e){
            System.out.println(e);
        }
        if(flag){return "true";}
        else {return "false";}
    }

    @Override
    public String DeleteCinema(Integer cId) {
        Cinema cinema=cinemaRepository.findByCId(cId);
        if (cinema==null)
        {
            return null;
        }
        else {
            boolean flag=false;
            try {
                cinemaRepository.delete(cinema);
                flag=true;
            }
            catch (Exception e){
                System.out.println(e);
            }
            if(flag){return "true";}
            else {return "false";}
        }
    }

    @Override
    public String UpdateCinema(String cName,String cAddress,Integer cId) {
        Cinema cinema=cinemaRepository.findByCId(cId);
        if(cinema==null)
        {
            return null;
        }
        else {
            boolean flag=false;
            try {
                cinemaRepository.UpdateCinema(cName,cAddress,cId);
                flag=true;
            }
            catch (Exception e){
                System.out.println(e);
            }
            if(flag){return "true";}
            else {return "false";}
        }

    }

    @Override
    public Cinema FindByCId(Integer cId) {
        return cinemaRepository.findByCId(cId);
    }

    @Override
    public List<Cinema> FindAll() {
        return cinemaRepository.findAll();
    }

    @Override
    public List<Cinema> FindByCNameLike(String cName) {
        return cinemaRepository.findByCNameLike(cName);
    }

    @Override
    public List<Cinema> FindByCAddressLike(String cAddress) {
        return cinemaRepository.findByCAddressLike(cAddress);
    }
}
