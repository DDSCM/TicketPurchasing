package com.example.demo.controller;

import com.example.demo.domain.Film;
import com.example.demo.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/Film")/*,produces = {"application/json;charset=UTF-8"}*/
public class FilmController {
    @Autowired
    private FilmService filmService;

    @PostMapping("/CreateFilm")
    public String CreateFilm(@RequestBody Film film){return filmService.CreateFilm(film);}


    @GetMapping("/UpdateFilm/fName={fName}fPrice={fPrice}fSatae={fState}fDes={fDes}fAct={fAct}" +
            "fCountry={fCountry}fTime={fTime}fType{fType}fId={fId}")
    public String UpdateFilm(@PathVariable("fName") String fName,
                             @PathVariable("fPrice") double fPrice,
                             @PathVariable("fState") String fState,
                             @PathVariable("fDes") String fDes,
                             @PathVariable("fAct") String fAct,
                             @PathVariable("fCountry") String fCountry,
                             @PathVariable("fTime") String fTime,
                             @PathVariable("fType") String fType,
                             @PathVariable("fId") Integer fId)
    {
        return filmService.UpdateFilm(fName,fPrice,fState,fDes,fAct,fCountry,fTime,fType,fId);
    }

    @GetMapping("/DeleteFilm/fId={fId}")
    public String DeleteFilm(@PathVariable("fId") Integer fId){return filmService.DeleteFilm(fId);}

    @GetMapping("/FindAll")
    public List<Film> findAll(){
        return filmService.findAll();
    }

    @GetMapping("/FindBYFId/fId={fId}")
    public Film findBYFId(@PathVariable("fId") Integer fId){return filmService.findBYFId(fId);}

    @GetMapping("/FindByFPrice/lowPrice={lowPrice}highPrice={highPrice}")
    public List<Film> findByFPrice(@PathVariable("lowPrice") double lowPrice,
                                   @PathVariable("highPrice") double highPrice)
        {return filmService.findByFPrice(lowPrice,highPrice);}

    @GetMapping("/FindByFName/fName={fName}")
    public List<Film> findByFName(@PathVariable("fName") String fName)//按照影片名字的模糊搜索
        {return filmService.findByFName(fName);}

    @GetMapping("/FindByFState/fState={fState}")
    public List<Film> findByFState(@PathVariable("fState") Integer fState)//按照状态分类
    {
        return filmService.findByFState(fState);
    }
    @GetMapping("/FindByFStateAndFNameLike/fState={fState}fName={fName}")
    public List<Film> findByFStateAndFNameLike(@PathVariable("fState") Integer fState,
                                               @PathVariable("fName") String fName)//按照状态分类名字模糊查找
    {
        return filmService.findByFStateAndFNameLike(fState,fName);
    }

    @GetMapping("/FindByFStateDESC")
    public List<Film> findByFStateDESC(){return filmService.findByFStateDESC();}

    @GetMapping("/FindByFStateAllDESC")
    public List<Film> findByFStateAllDESC(){
        return filmService.findByFStateAllDESC();
    }

    @GetMapping("/findByFStateRankDESC")
    public List<Film> findByFStateRankDESC(){return filmService.findByFStateRankDESC();}

    @GetMapping("/findByFStateRankAllDESC")
    public List<Film> findByFStateRankAllDESC(){return filmService.findByFStateRankAllDESC();}

    @GetMapping("/FindByFCountry/fCountry={fCountry}")
    public List<Film> FindByFCountry(@PathVariable("fCountry") String fCountry){
        return filmService.FindByFCountry(fCountry);
    }//按照国家分类

    @GetMapping("/FindByFType/fType={fType}")
    public List<Film> FindByFType(@PathVariable("fType") String fType){
        return filmService.FindByFType(fType);
    }//按照类型分类

    @GetMapping("/FindByFTime/fTime={fTime}")
    public List<Film> FindByFTime(@PathVariable("fTime") String fTime){
        return filmService.FindByFTime(fTime);
    }//按照年代分类

    //按照所有条件模糊查询
    @GetMapping("/FindByAll/fState={fState}fType={fType}fCountry={fCountry}fTime={fTime}rank={rank}")
    public List<Film> findByAll(@PathVariable("fState") Integer fState,
                                @PathVariable("fType") String fType,
                                @PathVariable("fCountry") String fCountry,
                                @PathVariable("fTime") String fTime,
                                @PathVariable("rank") String rank){
        return filmService.findByAll(fState,fType,fCountry,fTime,rank);
    }

    @GetMapping("/UpdateFState/fState={fState}fId={fId}")
    public String UpdateFilmState(@PathVariable("fState") Integer fState,
                                  @PathVariable("fId") Integer fId){
        return filmService.UpdateFilmState(fState,fId);
    }//更新电影状态

    @PostMapping("/UpdatePost")
    public void UpdatePost(@RequestParam("file") MultipartFile[] multipartFiles, HttpServletResponse resp){
        String filePath="C:\\Users\\ASUS\\Desktop\\企业java\\Vue+SpringBoot大作业\\test\\static\\post\\";
        MultipartFile multipartFile = multipartFiles[0];

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String timeStamp = simpleDateFormat.format(new Date());
        String filename=timeStamp;
        File dest=new File(filePath+filename+".jpg");
        if(!dest.getParentFile().exists()){
            dest.getParentFile().mkdirs();
        }
        try{
            multipartFile.transferTo(dest);
            /*userService.UpdatePotrait("\\static\\portrait\\"+filename,currentUser.getuId());
            currentUser.setPotrait("\\static\\portrait\\"+filename);*///同步更新当前的用户信息
            //currentUser=userService.findByUName(currentUser.getuName());

            //重定位
            resp.sendRedirect("http://localhost:8081/#/addFilm/"+"\\static\\post\\"+filename+".jpg");
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
