package com.example.demo.repository;

import com.example.demo.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Integer> {
    Order findByOId(Integer oId);

    @Query(value = "SELECT O FROM Order O WHERE O.showFilm.sfId=?1")
    List<Order> findAllBysfId(Integer sfId);

    @Query(value = "SELECT O.sId FROM Order O WHERE O.showFilm.cinema.cId=?1 AND O.showFilm.film.fId=?2 AND O.showFilm.showTime=?3 AND O.showFilm.showHour=?4")
    List<Integer> findOrderInDay(Integer cId, Integer fId, Date showTime, String showHour);
    //查找一次选座中已经被选掉的座位

    @Query(value = "SELECT O FROM Order O WHERE O.user.uId=?1 ORDER BY O.oId DESC")
    List<Order> findByUser(Integer uId);

    @Query(value = "SELECT O FROM Order O WHERE O.showFilm.film.fId=?1")
    List<Order> findByfId(Integer fId);
    @Query(value = "SELECT O FROM Order O WHERE O.showFilm.cinema.cId=?1")
    List<Order> findBycId(Integer cId);
    @Query(value = "SELECT O FROM Order O WHERE O.user.uId=?1")
    List<Order> findByuId(Integer uId);

    @Query(value = "SELECT O FROM Order O WHERE O.user.uId=?1 AND O.showFilm.film.fId=?2")
    List<Order> findByUserAndfId(Integer uId,Integer fId);
}
