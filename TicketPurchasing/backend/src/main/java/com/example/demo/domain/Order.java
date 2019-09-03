package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.sql.Time;
import java.util.List;

@Data
@Entity
@Table(name = "OrderTable")
public class Order {
    @GeneratedValue
    @Id
    private Integer oId;//订单号
    @Column
    private Integer sId;//座位号

    @ManyToOne
    //(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    //可选属性optional=false,表示cinema不能为空。删除影厅，不影响影院
    @JoinColumn(name = "uId")
    private User user;

    @ManyToOne
    //(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    @JoinColumn(name = "sfId")
    private ShowFilm showFilm;

    @Column
    private double num;//总金额

    public Integer getoId() {
        return oId;
    }

    public void setoId(Integer oId) {
        this.oId = oId;
    }

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public User getUser() {
        return user;
    }


    public void setUser(User user) {
        this.user = user;
    }

    public ShowFilm getShowFilm() {
        return showFilm;
    }


    public void setShowFilm(ShowFilm showFilm) {
        this.showFilm = showFilm;
    }

    public double getNum() {
        return num;
    }

    public void setNum(double num) {
        this.num = num;
    }
}
