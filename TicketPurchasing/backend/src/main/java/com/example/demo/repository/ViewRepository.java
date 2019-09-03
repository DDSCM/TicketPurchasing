package com.example.demo.repository;

import com.example.demo.domain.Film;
import com.example.demo.domain.View;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ViewRepository extends JpaRepository<View,Integer> {
    View findByVId(Integer vId);
    @Query(value = "SELECT V FROM View V WHERE V.vScore <= ?1")
    List<View> findByVScoreBelow(Integer vScore);//找到小于等于vscore的

    List<View> findByVScore(Integer vScore);

    @Query(value = "SELECT V FROM View V WHERE V.film.fId=?1")
    List<View> findByFId(Integer fId);//按照影片号找

    @Query(value = "SELECT V FROM View V WHERE V.user.uId=?1")
    List<View> findByUId(Integer uId);//按用户号找
    @Query(value = "SELECT V FROM View V WHERE V.vContext LIKE %?1%")
    List<View> findByContextLike(String vContext);

}
