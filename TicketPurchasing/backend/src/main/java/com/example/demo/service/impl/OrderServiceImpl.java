package com.example.demo.service.impl;

import com.example.demo.domain.Order;
import com.example.demo.repository.OrderRepository;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;


    @Override
    public String CreateOrder(Order order) {
        boolean flag=false;
        try {
            orderRepository.save(order);
            flag=true;
        }
        catch (Exception E){
            System.out.println(E.toString());
        }
        if(flag){return "true";}
        else {return "false";}
    }

    @Override
    public String DeleteOrder(Integer oId) {
        if(orderRepository.findByOId(oId)==null){
            return "false";
        }
        else {
            boolean flag=false;
            try {
                orderRepository.delete(oId);
                flag=true;
            }
            catch (Exception E){
                System.out.println(E);
            }
            if(flag){return "true";}
            else {return "false";}
        }
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order findByoId(Integer oId) {
        return orderRepository.findByOId(oId);
    }

    @Override
    public List<Order> FindAllBysfId(Integer sfId) {
        return orderRepository.findAllBysfId(sfId);
    }

    @Override
    public List<Integer> findOrderInDay(Integer cId, Integer fId, Date showTime, String showHour) {
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(showTime);
        calendar.add(Calendar.DATE,1);
        Date showTime2=calendar.getTime();
        return orderRepository.findOrderInDay(cId,fId,showTime2,showHour);
    }

    @Override
    public List<Order> findByUser(Integer uId) {
        return orderRepository.findByUser(uId);
    }

    @Override
    public List<Order> findByUserAndfId(Integer uId, Integer fId) {
        return orderRepository.findByUserAndfId(uId,fId);
    }

    @Override
    public List<Order> findByfId(Integer fId) {
        return orderRepository.findByfId(fId);
    }

    @Override
    public List<Order> findBycId(Integer cId) {
        return orderRepository.findBycId(cId);
    }

    @Override
    public List<Order> findByuId(Integer uId) {
        return orderRepository.findByuId(uId);
    }
}
