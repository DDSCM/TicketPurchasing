package com.example.demo.service;

import com.example.demo.domain.Film;

import java.util.List;

public interface FilmService {
    String CreateFilm(Film film);
    String UpdateFilm(String fName,double fPrice,String fState,String fDes,String fAct,String fCountry,
                      String fTime,String fType,Integer fId);
    String DeleteFilm(Integer fId);
    Film findBYFId(Integer fId);

    List<Film> findAll();
    List<Film> findByFPrice(double lowPrice, double highPrice);
    List<Film> findByFName(String fName);//按照影片名字的模糊搜索
    List<Film> findByFState(Integer fState);//按照状态分类
    List<Film> findByFStateAndFNameLike(Integer fState,String fName);
    List<Film> findByFStateDESC();//降序排列正在上映的影片的票房
    List<Film> findByFStateAllDESC();//降序排列所有影片的票房
    List<Film> findByFStateRankDESC();//降序排列正在上映的影片的评价
    List<Film> findByFStateRankAllDESC();//降序排列所有影片的评价
    List<Film> findByAll(Integer fState,String fType,String fCountry,String fTime,String rank);

    List<Film> FindByFCountry(String fCountry);//按照国家分类
    List<Film> FindByFType(String fType);//按照类型分类
    List<Film> FindByFTime(String fTime);//按照年代分类

    String UpdateFilmState(Integer fState,Integer fId);//更新电影状态
}
