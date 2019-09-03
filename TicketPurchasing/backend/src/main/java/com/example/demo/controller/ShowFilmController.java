package com.example.demo.controller;

import com.example.demo.domain.Cinema;
import com.example.demo.domain.Film;
import com.example.demo.domain.ShowFilm;
import com.example.demo.service.ShowFilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/ShowFilm",produces = {"application/json;charset=UTF-8"})
public class ShowFilmController {
    @Autowired
    private ShowFilmService showFilmService;

    @PostMapping("/CreateFS")
    public String CreateFS(@RequestBody ShowFilm showFilm){
        return showFilmService.CreateFS(showFilm);
    }
    @GetMapping("/DeleteFS/fsId={fsId}")
    public String DeleteFs(@PathVariable("fsId") Integer fsId){
        return showFilmService.DeleteFs(fsId);
    }
    @GetMapping("/FindAllByTime")
    public List<ShowFilm> findAll(){return showFilmService.findAllByTime();}
    @GetMapping("/UpdateFs/fId={fId}showTime={showTime}showHour={showHour}sfId={sfId}")
    public String UpdateFs(@PathVariable("fId") Integer fId,
                           @PathVariable("cId") Integer cId,
                           @PathVariable("showTime") Date showTime,
                           @PathVariable("showHour") String showHour,
                           @PathVariable("sfId") Integer sfId){
        return showFilmService.UpdateFs(fId,cId,showTime,showHour,sfId);
    }//更新放映信息

    @GetMapping("/FindByFsId/fsId={fsId}")
    public ShowFilm FindByFsId(@PathVariable("fsId") Integer fsId){
        return showFilmService.FindByFsId(fsId);
    }

    @GetMapping("/FindByShowTime/nowTime={nowTime}nowHour={nowHour}fName={fName}")
    public List<ShowFilm> findByShowTime(@PathVariable("nowTime") @DateTimeFormat(pattern = "yyyy-MM-dd") Date nowTime,
                                        @PathVariable("nowHour") String nowHour,
                                         @PathVariable("fName") String fName){
        return showFilmService.findByShowTime(nowTime,nowHour,fName);
    }//根据放映的时间显示到date日期time

    @GetMapping("/FindByFIdAndCId/fId={fId}cId={cId}")
    public List<ShowFilm> findByFIdAndCId(@PathVariable("fId") Integer fId,
                                          @PathVariable("cId") Integer cId){
        return showFilmService.findByFIdAndCId(fId,cId);
    }

    @GetMapping("/FindByFilmName/fId={fId}")
    public List<Cinema> findByFilmName(@PathVariable("fId") Integer fId){
        return showFilmService.findByFilmName(fId);
    }
    @GetMapping("/FindMinShowTime/fId={fId}")
    public Date findMinShowTime(@PathVariable("fId") Integer fId){
        return showFilmService.findMinShowTime(fId);
    }
    @GetMapping("/FindByCinemaId/cId={cId}")
    public List<Film> findByCinemaId(@PathVariable("cId") Integer cId){
        return showFilmService.findByCinemaId(cId);
    }

    @GetMapping("/FindShowTime/fId={fId}cId={cId}")
    public List<Date> findShowTime(@PathVariable("fId") Integer fId,
                                   @PathVariable("cId") Integer cId){
        return showFilmService.findShowTime(fId,cId);
    }
    @GetMapping("/FindShowHour/fId={fId}cId={cId}showTime={showTime}")
    public List<ShowFilm> findShowHour(@PathVariable("fId") Integer fId,
                                     @PathVariable("cId") Integer cId,
                                     @PathVariable("showTime") @DateTimeFormat(pattern="yyyy-MM-dd") Date showTime){
        return showFilmService.findShowHour(fId,cId,showTime);
    }

    @GetMapping("/FindByFId/fId={fId}")
    public List<ShowFilm> findByFId(@PathVariable("fId") Integer fId){
        return showFilmService.findByFId(fId);
    }

    @GetMapping("/FindByFNameLike/fName={fName}")
    public List<ShowFilm> findByFNameLike(@PathVariable("fName") String fName){
        return showFilmService.findByFNameLike(fName);
    }
}
