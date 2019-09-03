package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
@Table(name = "ShowFilmTable")
public class ShowFilm {
    @GeneratedValue
    @Id
    private Integer sfId;

    @ManyToOne
    @JoinColumn(name = "fId")
    private Film film;

    @ManyToOne
    @JoinColumn(name = "cId")
    private Cinema cinema;

    @Column
    private Date showTime;//放映日期

    @Column
    private String showHour;//播放的具体时间
    @Column
    private Integer hhId;//对应的影厅号

    @OneToMany(mappedBy = "showFilm",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Order> orderList;

    public Integer getSfId() {
        return sfId;
    }

    public void setSfId(Integer sfId) {
        this.sfId = sfId;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public Date getShowTime() {
        return showTime;
    }

    public void setShowTime(Date showTime) {
        this.showTime = showTime;
    }

    public String getShowHour() {
        return showHour;
    }

    public void setShowHour(String showHour) {
        this.showHour = showHour;
    }

    public List<Order> getOrderList() {
        return orderList;
    }
    @JsonBackReference(value = "n1")
    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public Integer getHhId() {
        return hhId;
    }

    public void setHhId(Integer hhId) {
        this.hhId = hhId;
    }
}
