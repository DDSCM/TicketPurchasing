package com.example.demo.service;

import com.example.demo.domain.Manager;

import java.util.List;

public interface ManagerService {
    String CreateManager(Manager manager);
    String DeleteManager(Integer mId);
    String UpdateManager(String mName,String mPhone,Integer mId);

    Manager FindByMId(Integer mId);
    List<Manager> FindAll();
    String MLogin(Integer mId,String mPwd);
}
