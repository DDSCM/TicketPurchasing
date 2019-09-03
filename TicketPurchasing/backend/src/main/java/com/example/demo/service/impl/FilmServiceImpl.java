package com.example.demo.service.impl;

import com.example.demo.domain.Film;
import com.example.demo.repository.FilmRepository;
import com.example.demo.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmServiceImpl implements FilmService {
    @Autowired
    private FilmRepository filmRepository;

    @Override
    public String CreateFilm(Film film) {
        boolean flag=false;
        try {
            filmRepository.save(film);
            flag=true;
        }
        catch (Exception e){
            System.out.println(e);
        }
        if(flag){return "true";}
        else {return "false";}
    }

    @Override
    public String UpdateFilm(String fName,double fPrice,String fState,String fDes,String fAct,String fCountry,
                             String fTime,String fType,Integer fId) {
        if(filmRepository.findByFId(fId)==null){
            return "false";
        }
        else {
            filmRepository.UpdateFilm(fName,fPrice,fState,fDes,fAct,fCountry,fTime,fType,fId);
            return "true";
        }
    }

    @Override
    public String DeleteFilm(Integer fId) {
        boolean flag=false;
        try {
            filmRepository.delete(fId);
            flag=true;
        }
        catch (Exception e){
            System.out.println(e);
        }
        if(flag){return "true";}
        else {return "false";}
    }

    @Override
    public Film findBYFId(Integer fId) {
        return filmRepository.findByFId(fId);
    }

    @Override
    public List<Film> findAll() {
        return filmRepository.findAll();
    }

    @Override
    public List<Film> findByFPrice(double lowPrice, double highPrice) {
        return filmRepository.findByFPrice(lowPrice,highPrice);
    }

    @Override
    public List<Film> findByFName(String fName) {
        return filmRepository.findByFName(fName);
    }

    @Override
    public List<Film> findByFState(Integer fState) {
        return filmRepository.findByFState(fState);
    }

    @Override
    public List<Film> findByFStateAndFNameLike(Integer fState, String fName) {
        return filmRepository.findByFStateAndFNameLike(fState,fName);
    }

    @Override
    public List<Film> findByFStateDESC() {
        return filmRepository.findByFStateDESC();
    }

    @Override
    public List<Film> findByFStateAllDESC() {
        return filmRepository.findByFStateAllDESC();
    }

    @Override
    public List<Film> findByFStateRankDESC() {
        return filmRepository.findByFStateRankDESC();
    }

    @Override
    public List<Film> findByFStateRankAllDESC() {
        return filmRepository.findByFStateRankAllDESC();
    }

    @Override
    public List<Film> findByAll(Integer fState, String fType, String fCountry, String fTime, String rank) {
        return filmRepository.findByAll(fState,fType,fCountry,fTime,rank);
    }

    @Override
    public List<Film> FindByFCountry(String fCountry) {
        return filmRepository.findByFCountry(fCountry);
    }

    @Override
    public List<Film> FindByFType(String fType) {
        return filmRepository.findByFType(fType);
    }

    @Override
    public List<Film> FindByFTime(String fTime) {
        return filmRepository.findByFTime(fTime);
    }

    @Override
    public String UpdateFilmState(Integer fState, Integer fId) {
        filmRepository.UpdateFilmState(fState,fId);
        return "true";
    }


}
