package com.example.demo.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "UserTable")

public class User {
    @GeneratedValue
    @Id
    private Integer uId;//用户号

    @ManyToMany
    @JoinTable(name = "ViewTable",joinColumns = {@JoinColumn(name = "uId")},inverseJoinColumns = {@JoinColumn(name = "fId")})
    private List<Film> filmList;//评论【用户】与【影片】多对多关系

    @OneToMany(mappedBy = "user",fetch=FetchType.LAZY)
    @JsonIgnore
    private List<View> viewList;

    @OneToMany(mappedBy = "user",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    @JsonIgnore
    private List<Order> orderList;

    @Column
    private String uName;//昵称
    @Column
    private String uPwd;//密码
    @Column
    private String uPhone;//联系电话
    @Column
    private String uSex;//性别
    @Column
    private String potrait;//头像



    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuPwd() {
        return uPwd;
    }

    public void setuPwd(String uPwd) {
        this.uPwd = uPwd;
    }

    public String getuPhone() {
        return uPhone;
    }

    public void setuPhone(String uPhone) {
        this.uPhone = uPhone;
    }

    public String getuSex() {
        return uSex;
    }

    public void setuSex(String uSex) {
        this.uSex = uSex;
    }


    public List<Film> getFilmList() {
        return filmList;
    }
    @JsonBackReference(value = "n1")
    public void setFilmList(List<Film> filmList) {
        this.filmList = filmList;
    }

    public List<Order> getOrderList() {
        return orderList;
    }
    @JsonBackReference(value = "n2")
    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public List<View> getViewList() {
        return viewList;
    }

    @JsonBackReference(value = "n3")
    public void setViewList(List<View> viewList) {
        this.viewList = viewList;
    }

    public String getPotrait() {
        return potrait;
    }

    public void setPotrait(String potrait) {
        this.potrait = potrait;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }
}
