package com.example.demo.controller;

import com.example.demo.domain.Cinema;
import com.example.demo.service.CinemaService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/Cinema",produces = {"application/json;charset=UTF-8"})
public class CinemaController {
    @Autowired
    private CinemaService cinemaService;

    @PostMapping("/CreateCinema")
    public String CreateCinema(@RequestBody Cinema cinema){return cinemaService.CreateCinema(cinema);}

    @GetMapping("/DeleteCinema/cId={cId}")
    public String DeleteCinema(@PathVariable("cId") Integer cId){return cinemaService.DeleteCinema(cId);}

    @GetMapping("/UpdateCinema/cName={cName}cAddress={cAddress}cId={cId}")
    public String UpdateCinema(@PathVariable("cName") String cName,
                               @PathVariable("cAddress") String cAddress,
                               @PathVariable("cId") Integer cId){return cinemaService.UpdateCinema(cName,cAddress,cId);}

    @GetMapping("/FindByCId/cId={cId}")
    public Cinema FindByCId(@PathVariable("cId") Integer cId){return cinemaService.FindByCId(cId);}

    @GetMapping("/FindAll")
    public List<Cinema> FindAll(){return cinemaService.FindAll();}

    @GetMapping("/FindByCNameLike/cName={cName}")
    public List<Cinema> FindByCNameLike(@PathVariable("cName") String cName)
        {return cinemaService.FindByCNameLike(cName);}//影院名字的模糊搜索

    @GetMapping("/FindByCAddressLike/cAddress={cAddress}")
    public List<Cinema> FindByCAddressLike(@PathVariable("cAddress") String cAddress)
    {
        return cinemaService.FindByCAddressLike(cAddress);
    }//影院地址的模糊搜索
}
