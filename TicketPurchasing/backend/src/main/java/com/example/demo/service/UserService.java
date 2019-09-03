package com.example.demo.service;

import com.example.demo.domain.User;

import java.util.List;

public interface UserService {
    String CreateUser(User user);
    String DeleteUser(Integer uId);

    User FindByUId(Integer uId);
    User findByUName(String uName);
    List<User> findAll();
    List<User> findByNameLike(String uName);

    String LoginUser(String uName,String uPwd);

    String UpdateUser(String uPhone,String uSex,Integer uId);
    String UpdatePwd(String old_pwd,String new_pwd,Integer uId);
    String UpdatePotrait(String potrait,Integer uId);
}
