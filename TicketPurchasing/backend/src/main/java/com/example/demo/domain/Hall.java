package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

//影厅
@Data
@Entity
@Table(name = "HallTable")
public class Hall {
    @GeneratedValue
    @Id
    private Integer hId;

    /////多个影厅对应一个影院
    @ManyToOne
    //可选属性optional=false,表示cinema不能为空。删除影厅，不影响影院
    @JoinColumn(name = "cId")
    private Cinema cinema;


    @Column
    private Integer hhId;//影院中对应的影厅号
    @Column
    private Integer colNum;//行数
    @Column
    private Integer rowNum;//列数
    /*@Column
    private List<Seats> seats;//座位列表*/

    public Integer gethId() {
        return hId;
    }

    public void sethId(Integer hId) {
        this.hId = hId;
    }

    //为了防止出现无限循环包含对方
    //需要在多的一方的引用对象的set方法上写上注解@JsonBackReference

    public Cinema getCinema() {
        return cinema;
    }

    //@JsonBackReference
    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public Integer getColNum() {
        return colNum;
    }

    public void setColNum(Integer colNum) {
        this.colNum = colNum;
    }

    public Integer getRowNum() {
        return rowNum;
    }

    public void setRowNum(Integer rowNum) {
        this.rowNum = rowNum;
    }

    public Integer getHhId() {
        return hhId;
    }

    public void setHhId(Integer hhId) {
        this.hhId = hhId;
    }
}
