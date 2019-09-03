package com.example.demo.service;

import com.example.demo.domain.Cinema;
import com.example.demo.domain.Film;
import com.example.demo.domain.ShowFilm;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public interface ShowFilmService {
    String CreateFS(ShowFilm showFilm);
    String DeleteFs(Integer fsId);
    List<ShowFilm> findByFId(Integer fId);
    List<ShowFilm> findAllByTime();

    String UpdateFs(Integer fId, Integer cId, Date showTime, String showHour, Integer sfId);//更新放映信息

    ShowFilm FindByFsId(Integer fsId);

    List<ShowFilm> findByShowTime(Date nowTime,String showTime,String fName);//根据放映的时间显示
    List<ShowFilm> findByFIdAndCId(Integer fId,Integer cId);//查找一个影片在一个影院中的放映时间安排

    List<Cinema> findByFilmName(Integer fId);//根据影片找到放映的电影院
    List<Film> findByCinemaId(Integer cId);//查找影院都放映哪些影片
    Date findMinShowTime(Integer fId);//返回该电影的所有放映时间，找到最小的那个作为首映时间

    List<Date> findShowTime(Integer fId,Integer cId);//查找一个影片在一个影院中的放映时间安排
    List<ShowFilm> findShowHour(Integer fId,Integer cId,Date showTime);//查找一天的所有放映

    List<ShowFilm> findByFNameLike(String fName);

}
