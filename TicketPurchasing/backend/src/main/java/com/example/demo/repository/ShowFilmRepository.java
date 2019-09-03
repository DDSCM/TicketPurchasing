package com.example.demo.repository;

import com.example.demo.domain.Cinema;
import com.example.demo.domain.Film;
import com.example.demo.domain.ShowFilm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public interface ShowFilmRepository extends JpaRepository<ShowFilm,Integer> {

    ShowFilm findBySfId(Integer sfId);

    @Query(value = "SELECT SF FROM ShowFilm SF WHERE SF.film.fId=?1")
    List<ShowFilm> findByFId(Integer fId);

    @Query(value = "SELECT SF FROM ShowFilm SF ORDER BY SF.showTime")
    List<ShowFilm> findAllByTime();

    @Transactional
    @Modifying
    @Query(value = "UPDATE ShowFilm SF SET SF.film.fId=?1,SF.cinema.cId=?2,SF.showTime=?3,SF.showHour=?4 WHERE SF.sfId=?5")
    void UpdateSF(Integer fId, Integer cId, Date showTime, String showHour, Integer sfId);//更新放映信息

    @Query(value = "SELECT SF FROM ShowFilm SF WHERE SF.showTime > ?1 AND SF.film.fName=?3 OR SF.showTime=?1 AND SF.showHour>?2 AND SF.film.fName=?3")
    List<ShowFilm> findByShowTime(Date nowTime,String nowHour,String fName);//根据放映的时间显示

    @Query(value = "SELECT SF FROM ShowFilm SF WHERE SF.film.fId=?1 AND SF.cinema.cId=?2")
    List<ShowFilm> findByFIdAndCId(Integer fId,Integer cId);//查找一个影片在一个影院中的放映时间安排

    @Query(value = "SELECT DISTINCT SF.cinema FROM ShowFilm SF WHERE SF.film.fId=?1")
    List<Cinema> findByFilmName(Integer fId);//查找放映对应影片的影院都有哪些

    @Query(value = "SELECT SF.showTime FROM ShowFilm SF WHERE SF.film.fId=?1 ORDER BY SF.showTime ASC")
    List<Date> findMinShowTime(Integer fId);//返回该电影的所有放映时间，找到最小的那个作为首映时间

    @Query(value = "SELECT DISTINCT SF.film FROM ShowFilm SF WHERE SF.cinema.cId=?1")
    List<Film> findByCinemaId(Integer cId);//查找影院都放映哪些影片

    @Query(value = "SELECT DISTINCT SF.showTime FROM ShowFilm SF WHERE SF.film.fId=?1 AND SF.cinema.cId=?2 ORDER BY SF.showTime ASC")
    List<Date> findShowTime(Integer fId,Integer cId);//查找一个影片在一个影院中的放映时间安排

    @Query(value = "SELECT SF FROM ShowFilm SF WHERE SF.film.fId=?1 AND SF.cinema.cId=?2 AND SF.showTime=?3 ORDER BY SF.showHour")
    List<ShowFilm> findShowHour(Integer fId,Integer cId,Date showTime);//查找一天的所有放映

    @Query(value = "SELECT SF FROM ShowFilm SF WHERE SF.film.fName LIKE %?1%")
    List<ShowFilm> findByFNameLike(String fName);


}
