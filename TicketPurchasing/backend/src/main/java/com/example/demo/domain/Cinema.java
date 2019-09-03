package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "CinemaTable")
public class Cinema {
    @GeneratedValue
    @Id
    private Integer cId;//影院号

    /////一家影院对应多个影厅
    @OneToMany(mappedBy = "cinema",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    //级联保存、更新、删除、刷新;延迟加载。当删除cinema【影院】，会级联删除该影院的所有hall【影厅】
    //拥有mappedBy注解的实体类为关系被维护端
    //mappedBy="cinema"中的cinema是Hall中的cinema属性
    private List<Hall> hallList;

    @ManyToMany//(cascade = CascadeType.ALL)
    @JoinTable(name = "ShowFilmTable",joinColumns = {@JoinColumn(name = "cId")},inverseJoinColumns = {
            @JoinColumn(name = "fId")
    })
    private List<Film> filmList;

    @OneToMany(mappedBy = "cinema")
    private List<ShowFilm> showFilmList;

/*    @Column
    private String cArea;//区域*/
    @Column
    private String cName;//影院名
    @Column
    private String cAddress;//地址

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcAddress() {
        return cAddress;
    }

    public void setcAddress(String cAddress) {
        this.cAddress = cAddress;
    }

    public List<Hall> getHallList() {
        return hallList;
    }

    @JsonBackReference(value = "j3")
    public void setHallList(List<Hall> hallList) {
        this.hallList = hallList;
    }

    public List<Film> getFilmList() {
        return filmList;
    }

    @JsonBackReference(value = "j1")
    public void setFilmList(List<Film> filmList) {
        this.filmList = filmList;
    }

    public List<ShowFilm> getShowFilmList() {
        return showFilmList;
    }
    @JsonBackReference(value = "j2")
    public void setShowFilmList(List<ShowFilm> showFilmList) {
        this.showFilmList = showFilmList;
    }
}
