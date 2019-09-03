package com.example.demo.service.impl;

import com.example.demo.domain.Cinema;
import com.example.demo.domain.Film;
import com.example.demo.domain.ShowFilm;
import com.example.demo.repository.ShowFilmRepository;
import com.example.demo.service.ShowFilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class ShowFilmServiceImpl implements ShowFilmService {
    @Autowired
    private ShowFilmRepository showFilmRepository;

    @Override
    public String CreateFS(ShowFilm showFilm) {
        boolean flag=false;
        try {
            showFilmRepository.save(showFilm);
            flag=true;
        }
        catch (Exception E){
            System.out.println(E);
        }
        if(flag){return "true";}
        else {return "false";}
    }

    @Override
    public String DeleteFs(Integer fsId) {
        boolean flag=false;
        try {
            showFilmRepository.delete(fsId);
            flag=true;
        }
        catch (Exception e){
            System.out.println(e);
        }
        if(flag){return "true";}
        else {return "false";}
    }

    @Override
    public List<ShowFilm> findByFId(Integer fId) {
        return showFilmRepository.findByFId(fId);
    }

    @Override
    public List<ShowFilm> findAllByTime() {
        return showFilmRepository.findAllByTime();
    }

    @Override
    public String UpdateFs(Integer fId, Integer cId, Date showTime, String showHour, Integer sfId) {
        if(showFilmRepository.findBySfId(fId)==null){
            return "false";
        }
        else {
            boolean flag=false;
            try {
                showFilmRepository.UpdateSF(fId,cId,showTime,showHour,sfId);
                flag=true;
            }
            catch (Exception E){
                System.out.println(E);
            }
            if(flag){return "true";}
            else {return "false";}
        }
    }

    @Override
    public ShowFilm FindByFsId(Integer fsId) {
        return showFilmRepository.findBySfId(fsId);
    }

    @Override
    public List<ShowFilm> findByShowTime(Date nowTime,String nowHour,String fName) {

        Calendar calendar=Calendar.getInstance();
        calendar.setTime(nowTime);
        calendar.add(Calendar.DATE,1);
        Date nowTime2=calendar.getTime();
        return showFilmRepository.findByShowTime(nowTime2,nowHour,fName);
    }

    @Override
    public List<ShowFilm> findByFIdAndCId(Integer fId, Integer cId) {
        return showFilmRepository.findByFIdAndCId(fId,cId);
    }

    @Override
    public List<Cinema> findByFilmName(Integer fId) {
        return showFilmRepository.findByFilmName(fId);
    }

    @Override
    public List<Film> findByCinemaId(Integer cId) {
        return showFilmRepository.findByCinemaId(cId);
    }

    @Override
    public Date findMinShowTime(Integer fId) {
        List<Date> dates=showFilmRepository.findMinShowTime(fId);
        return dates.get(0);
    }

    @Override
    public List<Date> findShowTime(Integer fId, Integer cId) {
        return showFilmRepository.findShowTime(fId,cId);
    }

    @Override
    public List<ShowFilm> findShowHour(Integer fId, Integer cId, Date showTime) {

        Calendar calendar=Calendar.getInstance();
        calendar.setTime(showTime);
        calendar.add(Calendar.DATE,1);
        Date showTime2=calendar.getTime();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        String dataString=format.format(showTime);
        ShowFilm ds=new ShowFilm();
        ds.setShowHour(dataString);
        List<ShowFilm> toReturn=showFilmRepository.findShowHour(fId,cId,showTime2);
        toReturn.add(0,ds);
        return toReturn;
    }

    @Override
    public List<ShowFilm> findByFNameLike(String fName) {
        return showFilmRepository.findByFNameLike(fName);
    }

}
