package com.example.demo.controller;

import com.example.demo.domain.Cinema;
import com.example.demo.domain.Manager;
import com.example.demo.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/Manager",produces = "application/json;charset=UTF-8")
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    @PostMapping("/CreateManager")
    public String CreateManager(@RequestBody Manager manager){return managerService.CreateManager(manager);}

    @GetMapping("/DeleteManager/mId={mId}")
    public String DeleteManager(@PathVariable("mId") Integer mId){return managerService.DeleteManager(mId);}

    @GetMapping("/UpdateManager/mName={mName}mPhone={mPhone}mId={mId}")
    public String UpdateManager(@PathVariable("mName") String mName,
                                @PathVariable("mPhone") String mPhone,
                                @PathVariable("mId") Integer mId)
    {
        return managerService.UpdateManager(mName,mPhone,mId);
    }

    @GetMapping("/FindByMId/mId={mId}")
    public Manager FindByMId(@PathVariable("mId") Integer mId){return managerService.FindByMId(mId);}

    @GetMapping("/FindAll")
    public List<Manager> FindAll(){return managerService.FindAll();}

    @GetMapping("/MLogin/mId={mId}mPwd={mPwd}")
    public String MLogin(@PathVariable("mId") Integer mId,
                         @PathVariable("mPwd") String mPwd){
        return managerService.MLogin(mId,mPwd);
    }
}
