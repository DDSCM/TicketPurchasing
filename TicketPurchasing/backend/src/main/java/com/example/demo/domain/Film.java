package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "FilmTable")
public class Film {

    @GeneratedValue
    @Id
    private Integer fId;//影片号

    @ManyToMany
    @JoinTable(name = "ViewTable",joinColumns = {@JoinColumn(name = "fId")},inverseJoinColumns = {
            @JoinColumn(name = "uId")
    })
    private List<User> userList;

    @OneToMany(mappedBy = "film")
    private List<View> viewList;

    @ManyToMany
    @JoinTable(name = "ShowFilmTable",joinColumns = {@JoinColumn(name = "fId")},inverseJoinColumns = {
            @JoinColumn(name = "cId")
    })
    private List<Cinema> cinemaList;

    @OneToMany(mappedBy = "film")
    private List<ShowFilm> showFilmList;

    @Column
    private String fName;//影片名
    @Column
    private String fDes;//影片简介
    @Column
    private double fPrice;//票价
    @Column
    private Integer fState;//状态【下映0，上映1，即将上映2】
    @Column
    private String fAct;//电影演员
    @Column
    private String fType;//类型
    @Column
    private String fTime;//年代
    @Column
    private String fCountry;//国家
    @Column
    private Integer fLast;//播放时长
    @Column
    private String post;//海报，存放图片的地址
    @Column
    private double num;//票房
    @Column
    private String fRank;//总评分

    public Integer getfId() {
        return fId;
    }

    public void setfId(Integer fId) {
        this.fId = fId;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getfDes() {
        return fDes;
    }

    public void setfDes(String fDes) {
        this.fDes = fDes;
    }

    public double getfPrice() {
        return fPrice;
    }

    public void setfPrice(double fPrice) {
        this.fPrice = fPrice;
    }

    public Integer getfState() {
        return fState;
    }

    public void setfState(Integer fState) {
        this.fState = fState;
    }

    public String getfAct() {
        return fAct;
    }

    public void setfAct(String fAct) {
        this.fAct = fAct;
    }


    public List<User> getUserList() {
        return userList;
    }

    @JsonBackReference(value = "j1")
    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public String getfType() {
        return fType;
    }

    public void setfType(String fType) {
        this.fType = fType;
    }

    public String getfTime() {
        return fTime;
    }

    public void setfTime(String fTime) {
        this.fTime = fTime;
    }

    public String getfCountry() {
        return fCountry;
    }

    public void setfCountry(String fCountry) {
        this.fCountry = fCountry;
    }

    public List<Cinema> getCinemaList() {
        return cinemaList;
    }

    @JsonBackReference(value = "j2")
    public void setCinemaList(List<Cinema> cinemaList) {
        this.cinemaList = cinemaList;
    }

    public List<View> getViewList() {
        return viewList;
    }

    @JsonBackReference(value = "j3")
    public void setViewList(List<View> viewList) {
        this.viewList = viewList;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public Integer getfLast() {
        return fLast;
    }

    public void setfLast(Integer fLast) {
        this.fLast = fLast;
    }

    public double getNum() {
        return num;
    }

    public void setNum(double num) {
        this.num = num;
    }

    public String getfRank() {
        return fRank;
    }

    public void setfRank(String fRank) {
        this.fRank = fRank;
    }

    public List<ShowFilm> getShowFilmList() {
        return showFilmList;
    }
    @JsonBackReference(value = "j4")
    public void setShowFilmList(List<ShowFilm> showFilmList) {
        this.showFilmList = showFilmList;
    }
}
