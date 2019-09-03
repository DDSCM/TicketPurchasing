package com.example.demo.service.impl;

import com.example.demo.domain.Manager;
import com.example.demo.repository.ManagerRepository;
import com.example.demo.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerRepository managerRepository;

    @Override
    public String CreateManager(Manager manager) {
        Manager manager1=managerRepository.findByMName(manager.getmName());
        if(manager1==null)
        {
            boolean flag=false;
            try {
                managerRepository.save(manager);
                flag=true;
            }
            catch (Exception e){
                System.out.println(e);
            }
            if(flag){return "true";}
            else {return "false";}
        }
        else
        {
            return "Exists";
        }
    }

    @Override
    public String DeleteManager(Integer mId) {
        boolean flag=false;
        try {
            managerRepository.delete(mId);
            flag=true;
        }
        catch (Exception e){
            System.out.println(e);
        }
        if(flag){return "true";}
        else {return "false";}
    }

    @Override
    public String UpdateManager(String mName, String mPhone, Integer mId) {
        boolean flag=false;
        try{
            managerRepository.UpdateManager(mName,mPhone,mId);
            flag=true;
        }
        catch (Exception e){
            System.out.println(e);
        }
        if(flag){return "true";}
        else {return "false";}
    }

    @Override
    public Manager FindByMId(Integer mId) {
        return managerRepository.findByMId(mId);
    }

    @Override
    public List<Manager> FindAll() {
        return managerRepository.findAll();
    }

    @Override
    public String MLogin(Integer mId, String mPwd) {
        Manager m=managerRepository.findByMId(mId);
        if(m==null){
            return "false";
        }
        if(m.getmPwd().equals(mPwd)){
            return "true";
        }
        return "false";
    }
}
