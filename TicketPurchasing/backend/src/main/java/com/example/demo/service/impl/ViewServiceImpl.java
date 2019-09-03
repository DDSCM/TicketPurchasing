package com.example.demo.service.impl;

import com.example.demo.domain.View;
import com.example.demo.repository.ViewRepository;
import com.example.demo.service.ViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViewServiceImpl implements ViewService {
    @Autowired
    private ViewRepository viewRepository;

    @Override
    public String CreateView(View view) {
        boolean flag=false;
        try {
            viewRepository.save(view);
            flag=true;
        }
        catch (Exception e){
            System.out.println(e);
        }
        if(flag){return "true";}
        else {return "false";}
    }

    @Override
    public String DeleteView(Integer vId) {
        if(viewRepository.findByVId(vId)==null){
            return "false";
        }
        else {
            viewRepository.delete(vId);
            return "true";
        }
    }

    @Override
    public List<View> FindAll() {
        return viewRepository.findAll();
    }

    @Override
    public View FindByVId(Integer vId) {
        return viewRepository.findByVId(vId);
    }

    @Override
    public List<View> FindByUId(Integer uId) {
        return viewRepository.findByUId(uId);
    }

    @Override
    public List<View> FindByFId(Integer fId) {
        return viewRepository.findByFId(fId);
    }

    @Override
    public List<View> findByVScoreBelow(Integer vScore) {
        return viewRepository.findByVScoreBelow(vScore);
    }

    @Override
    public List<View> findByContextLike(String vContext) {
        return viewRepository.findByContextLike(vContext);
    }

    @Override
    public List<View> findByVScore(Integer vScore) {
        return viewRepository.findByVScore(vScore);
    }
}
