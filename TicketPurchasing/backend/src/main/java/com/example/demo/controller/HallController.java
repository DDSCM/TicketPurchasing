package com.example.demo.controller;

import com.example.demo.domain.Hall;
import com.example.demo.service.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/Hall",produces = "application/json;charset=UTF-8")
public class HallController {
    @Autowired
    private HallService hallService;

    @PostMapping("/CreateHall")
    public String CreateHall(@RequestBody Hall hall){return hallService.CreateHall(hall);}

    @GetMapping("/DeleteHall/hId={hId}")
    public String DeleteHall(@PathVariable("hId") Integer hId){return hallService.DeleteHall(hId);}

    @GetMapping("/UpdateHall/colNum={colNum}rowNum={rowNum}hId={hId}")
    public String UpdateHall(@PathVariable("colNum") Integer colNum,
                             @PathVariable("rowNum") Integer rowNum,
                             @PathVariable("hId") Integer hId)
    {
        return hallService.UpdateHall(colNum,rowNum,hId);
    }

    @GetMapping("/FindByHId/hId={hId}")
    public Hall FindByHId(@PathVariable("hId") Integer hId){return hallService.FindByHId(hId);}

    @GetMapping("/FindAll")
    public List<Hall> FindAll(){return hallService.FindAll();}
}
