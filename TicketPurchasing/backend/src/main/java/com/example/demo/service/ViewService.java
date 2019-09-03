package com.example.demo.service;

import com.example.demo.domain.View;

import java.util.List;

public interface ViewService {
    String CreateView(View view);
    String DeleteView(Integer vId);
    List<View> FindAll();
    View FindByVId(Integer vId);
    List<View> FindByUId(Integer uId);//某一用户的评论
    List<View> FindByFId(Integer fId);//某一电影的评论

    List<View> findByVScoreBelow(Integer vScore);//找到小于等于vscore的
    List<View> findByContextLike(String vContext);
    List<View> findByVScore(Integer vScore);
}
