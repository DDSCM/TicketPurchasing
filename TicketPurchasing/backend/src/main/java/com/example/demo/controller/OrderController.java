package com.example.demo.controller;

import com.example.demo.domain.Order;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/Order",produces = {"application/json;charset=UTF-8"})
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/CreateOrder")
    public String CreateOrder(@RequestBody Order order){return orderService.CreateOrder(order);}

    @GetMapping("/DeleteOrder/oId={oId}")
    public String DeleteOrder(@PathVariable("oId") Integer oId){return orderService.DeleteOrder(oId);}

    @GetMapping("/FindByall/all={all}")
    public List<Order> findAll(@PathVariable("all") String all) {
        return orderService.findAll();
    }

    @GetMapping("/FindAllBysfId/sfId={sfId}")
    public List<Order> FindAllBysfId(@PathVariable("sfId") Integer sfId){return orderService.FindAllBysfId(sfId);}

    @GetMapping("/FindOrderInDay/cId={cId}fId={fId}showTime={showTime}showHour={showHour}")
    public List<Integer> findOrderInDay(@PathVariable("cId") Integer cId,
                                      @PathVariable("fId") Integer fId,
                                      @PathVariable("showTime") @DateTimeFormat(pattern="yyyy-MM-dd") Date showTime,
                                      @PathVariable("showHour") String showHour){
        return orderService.findOrderInDay(cId,fId,showTime,showHour);
    }
    @GetMapping("/FindByUser/uId={uId}")
    public List<Order> findByUser(@PathVariable("uId") Integer uId){
        return orderService.findByUser(uId);
    }
    @GetMapping("/FindByUserAndfId/uId={uId}fId={fId}")
    public List<Order> findByUserAndfId(@PathVariable("uId") Integer uId,
                                        @PathVariable("fId") Integer fId){
        return orderService.findByUserAndfId(uId,fId);
    }

    @GetMapping("/FindByfId/fId={fId}")
    public List<Order> findByfId( @PathVariable("fId") Integer fId){
        return orderService.findByfId(fId);
    }
    @GetMapping("/FindBycId/cId={cId}")
    public List<Order> findBycId( @PathVariable("cId") Integer cId){
        return orderService.findBycId(cId);
    }
    @GetMapping("/FindByuId/uId={uId}")
    public List<Order> findByuId( @PathVariable("uId") Integer uId){
        return orderService.findByuId(uId);
    }
    @GetMapping("/FindByoId/oId={oId}")
    public Order findByoId( @PathVariable("oId") Integer oId){
        return orderService.findByoId(oId);
    }
}
