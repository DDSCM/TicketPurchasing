package com.example.demo.controller;

import com.example.demo.domain.View;
import com.example.demo.service.ViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/View",produces = "application/json;charset=UTF-8")
public class ViewController {
    @Autowired
    private ViewService viewService;

    @PostMapping("/CreateView")
    public String CreateView(@RequestBody View view){return viewService.CreateView(view);}

    @GetMapping("/DeleteView/vId={vId}")
    public String DeleteView(@PathVariable("vId") Integer vId){return viewService.DeleteView(vId);}

    @GetMapping("/FindAll")
    public List<View> findALL(){return viewService.FindAll();}

    @GetMapping("/FindByVId/vId={vId}")
    public View FindByVId(@PathVariable("vId") Integer vId){return viewService.FindByVId(vId);}

    @GetMapping("/FindByUId/uId={uId}")
    public List<View> FindByUId(@PathVariable("uId") Integer uId){return viewService.FindByUId(uId);}//某一用户的评论

    @GetMapping("/FindByFId/fId={fId}")
    List<View> FindByFId(@PathVariable("fId") Integer fId){return viewService.FindByFId(fId);}//某一电影的评论

    @GetMapping("/FindByVScoreBelow/vScore={vScore}")
    List<View> findByVScoreBelow(@PathVariable("vScore") Integer vScore)
    {return viewService.findByVScoreBelow(vScore);}//找到小于等于vscore的【某星及以下的】

    @GetMapping("/FindByVScore/vScore={vScore}")//找到分数为vScorede【某星的】
    List<View> findByVScore(@PathVariable("vScore") Integer vScore)
    {
        return viewService.findByVScore(vScore);
    }

    @GetMapping("/FindByContextLike/vContext={vContext}")
    public List<View> findByContextLike(@PathVariable("vContext") String vContext){
        return viewService.findByContextLike(vContext);
    }
}
