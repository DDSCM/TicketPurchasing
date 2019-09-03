package com.example.demo.service.impl;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public String CreateUser(User user) {
        User user1=userRepository.findByUName(user.getuName());
        if(user1!=null){
            return "Exists";//存在同名用户
        }
        else
        {
            boolean flag=false;
            user.setPotrait("\\static\\portrait\\init.jpg");//为新用户设置初始头像
            try {
                userRepository.save(user);
                flag=true;
            }
            catch (Exception e){
                System.out.println(e);
            }
            if(flag){
                return "true";
            }
            else {
                return "false";
            }
        }
    }

    @Override
    public String DeleteUser(Integer uId) {
        User user=userRepository.findByUId(uId);
        if(user==null)
        {
            return "null";
        }
        else
        {
            boolean flag=false;
            try {
                userRepository.delete(user);
                flag=true;
            }
            catch (Exception e){
                System.out.println(e);
            }
            if(flag){return "true";}
            else{return "false";}
        }
    }

    @Override
    public User FindByUId(Integer uId) {
        User user=userRepository.findByUId(uId);
        if(user==null){
            return null;
        }
        else {
            return user;
        }
    }

    @Override
    public User findByUName(String uName) {
        return userRepository.findByUName(uName);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> findByNameLike(String uName) {
        return userRepository.findByNameLike(uName);
    }

    @Override
    public String LoginUser(String uName, String uPwd) {
        User user=userRepository.findByUName(uName);
        if(user==null)
        {
            return "null";
        }
        else {
            boolean flag=false;
            if(user.getuPwd().equals(uPwd))
            {
                flag=true;
            }
            if(flag){return "true";}
            else {return "false";}
        }
    }

    @Override
    public String UpdateUser(String uPhone, String uSex, Integer uId) {
        User user=userRepository.findByUId(uId);
        if(user==null){
            return null;
        }
        else {
            boolean flag=false;
            try {
                userRepository.UpdateUser(uPhone,uSex,uId);
                flag=true;
            }
            catch (Exception e){
                System.out.println(e);
            }
            if(flag){return "true";}
            else {return "false";}
        }

    }

    @Override
    public String UpdatePwd(String old_pwd, String new_pwd, Integer uId) {
        User user=userRepository.findByUId(uId);
        if(user==null){
            return null;
        }
        else {
            boolean flag=false;
            if(old_pwd.equals(user.getuPwd())){
                try {
                    userRepository.UpdatePwd(new_pwd,uId);
                    flag=true;
                }
                catch (Exception e){
                    System.out.println(e);
                }
            }
            if(flag){return "true";}
            else {return "false";}
        }
    }

    @Override
    public String UpdatePotrait(String potrait, Integer uId) {
        boolean flag=false;
        try{
            userRepository.UpdatePotrait(potrait, uId);
            flag=true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        if(flag){
            return "true";
        }
        return "false";
    }
}
