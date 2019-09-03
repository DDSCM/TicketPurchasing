package com.example.demo.repository;

import com.example.demo.domain.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface FilmRepository extends JpaRepository<Film,Integer> {
    Film findByFId(Integer fId);
    List<Film> findAll();

    @Query(value = "SELECT F FROM Film F WHERE F.fCountry=?1")
    List<Film>findByFCountry(String fCountry);

    @Query(value = "SELECT F FROM Film F WHERE F.fTime=?1")
    List<Film>findByFTime(String fTime);

    @Query(value = "SELECT F FROM Film F WHERE F.fType=?1")
    List<Film>findByFType(String fType);

    @Query(value = "SELECT F FROM Film F WHERE F.fName LIKE %?1%")
    List<Film> findByFName(String fName);//按照影片名字的模糊搜索

    @Query(value = "SELECT F FROM Film F WHERE F.fState=?1")
    List<Film> findByFState(Integer fState);//按照状态分类
    @Query(value = "SELECT F FROM Film F WHERE F.fState=?1 AND F.fName LIKE %?2%")
    List<Film> findByFStateAndFNameLike(Integer fState,String fName);

    @Query(value = "SELECT F FROM Film F WHERE F.fState=1 ORDER BY F.num DESC")
    List<Film> findByFStateDESC();//降序排列正在上映的影片的票房

    @Query(value = "SELECT F FROM Film F ORDER BY F.num DESC")
    List<Film> findByFStateAllDESC();//降序排列所有影片的票房

    @Query(value = "SELECT F FROM Film F WHERE F.fState=1 ORDER BY F.fRank DESC")
    List<Film> findByFStateRankDESC();//降序排列正在上映的影片的评价

    @Query(value = "SELECT F FROM Film F ORDER BY F.fRank DESC")
    List<Film> findByFStateRankAllDESC();//降序排列所有影片的评价

    @Query(value = "SELECT F FROM Film F WHERE F.fPrice between ?1 AND ?2")
    List<Film> findByFPrice(double lowPrice,double highPrice);//根据价格区间分类

    @Query(value = "SELECT F FROM Film F WHERE F.fState=?1 AND F.fType LIKE %?2% AND F.fCountry LIKE %?3% AND" +
            " F.fTime LIKE %?4% AND F.fRank LIKE ?5%")//film界面多选框的查询语句
    List<Film> findByAll(Integer fState,String fType,String fCountry,String fTime,String rank);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Film F SET F.fName=?1,F.fPrice=?2,F.fState=?3,F.fDes=?4,F.fAct=?5,F.fCountry=?6," +
            "F.fTime=?7,F.fType=?8 WHERE F.fId=?9")
    void UpdateFilm(String fName,double fPrice,String fState,String fDes,String fAct,String fCountry,
                      String fTime,String fType,Integer fId);//更新电影信息

    @Transactional
    @Modifying
    @Query(value = "UPDATE Film F SET F.fState=?1 WHERE F.fId=?2")
    void UpdateFilmState(Integer fState,Integer fId);//更新电影状态
}
