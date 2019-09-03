package com.example.demo.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ViewTable")
public class View {
    @GeneratedValue
    @Id
    private Integer vId;
    @Column
    private Integer vScore;//评分
    @Column
    private String vContext;//评价内容

    @ManyToOne
    @JoinColumn(name = "uId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "fId")
    private Film film;

    public Integer getvId() {
        return vId;
    }

    public void setvId(Integer vId) {
        this.vId = vId;
    }

    public Integer getvScore() {
        return vScore;
    }

    public void setvScore(Integer vScore) {
        this.vScore = vScore;
    }

    public String getvContext() {
        return vContext;
    }

    public void setvContext(String vContext) {
        this.vContext = vContext;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }
}
