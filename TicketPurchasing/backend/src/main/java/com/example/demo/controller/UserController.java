package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;

@RestController
@RequestMapping(value = "/User"/*,produces = {"application/json;charset=UTF-8"}*/)
public class UserController {
    @Autowired
    private UserService userService;

    private User currentUser=new User();//当前用户保存
    private Integer n=0;//计数头像

    @PostMapping("/CreateUser")
    public String CreateUser(@RequestBody User user){return userService.CreateUser(user);}

    @GetMapping("/DeleteUser/uId={uId}")
    public String DeleteUser(@PathVariable("uId") Integer uId){return userService.DeleteUser(uId);}

    @GetMapping("/getCurrentUser")
    public User getCurrentUser(){
        return currentUser;
    }//返回当前用户

    @GetMapping("/FindByUId/uId={uId}")
    public User FindByUId(@PathVariable("uId") Integer uId){return userService.FindByUId(uId);}

    @GetMapping("/findAll")
    public List<User> findAll(){return userService.findAll();}

    @GetMapping("/FindByNameLike/uName={uName}")
    public List<User> findByNameLike(@PathVariable("uName") String uName){
        return userService.findByNameLike(uName);
    }

    @GetMapping("/LoginUser/uName={uName}uPwd={uPwd}")//用户登录
    public String LoginUser(@PathVariable("uName") String uName,
                            @PathVariable("uPwd") String uPwd){
        String success=userService.LoginUser(uName,uPwd);
        if(success.equals("true")){//将当前用户对象保存
            currentUser=userService.findByUName(uName);
        }
        return success;
    }

    @GetMapping("/LogoutUser")//用户登出
    public void LogoutUser(){
        currentUser=null;
    }

    @GetMapping("/UpdateUser/uPhone={uPhone}uSex={uSex}uId={uId}")
    public String UpdateUser(@PathVariable("uPhone") String uPhone,
                             @PathVariable("uSex") String uSex,
                             @PathVariable("uId") Integer uId){
        String success= userService.UpdateUser(uPhone,uSex,uId);

        currentUser.setuPhone(uPhone);//同步更新当前的用户信息
        currentUser.setuSex(uSex);
        //currentUser=userService.findByUName(currentUser.getuName());

        return success;
    }

    @GetMapping("/UpdatePwd/old_pwd={old_pwd}new_pwd={new_pwd}uId={uId}")
    public String UpdatePwd(@PathVariable("old_pwd") String old_pwd,
                            @PathVariable("new_pwd") String new_pwd,
                            @PathVariable("uId") Integer uId){
        String success=userService.UpdatePwd(old_pwd, new_pwd, uId);

        if(success.equals("true")){
            currentUser.setuPwd(new_pwd);//同步更新当前的用户信息
            //currentUser=userService.findByUName(currentUser.getuName());
        }
        //若返回false，即原密码错误，则不同步信息
        return success;
    }

    //修改头像
    @PostMapping("/UpdatePotrait")
    public void UpdatePotrait(@RequestParam("file") MultipartFile[] multipartFiles, HttpServletResponse resp){
        String filePath="C:\\Users\\ASUS\\Desktop\\企业java\\Vue+SpringBoot大作业\\test\\static\\portrait\\";
        MultipartFile multipartFile = multipartFiles[0];
            String filename=currentUser.getuName()+"_"+n+++".jpg";
            File dest=new File(filePath+filename);
            if(!dest.getParentFile().exists()){
                dest.getParentFile().mkdirs();
            }
            try{
                multipartFile.transferTo(dest);
                userService.UpdatePotrait("\\static\\portrait\\"+filename,currentUser.getuId());


                currentUser.setPotrait("\\static\\portrait\\"+filename);//同步更新当前的用户信息
                //currentUser=userService.findByUName(currentUser.getuName());

                //重定位回userInformation
                resp.sendRedirect("http://localhost:8081/#/userInformation");
            }
            catch (Exception e){
                e.printStackTrace();
            }

    }
}
