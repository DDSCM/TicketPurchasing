package com.example.demo.service;

import com.example.demo.domain.Order;

import java.util.Date;
import java.util.List;

public interface OrderService {
    String CreateOrder(Order order);
    String DeleteOrder(Integer oId);
    List<Order> findAll();
    Order findByoId(Integer oId);

    List<Order> FindAllBysfId(Integer sfId);
    List<Integer> findOrderInDay(Integer cId, Integer fId, Date showTime, String showHour);

    List<Order> findByUser(Integer uId);
    List<Order> findByUserAndfId(Integer uId,Integer fId);

    List<Order> findByfId(Integer fId);
    List<Order> findBycId(Integer cId);
    List<Order> findByuId(Integer uId);
}
