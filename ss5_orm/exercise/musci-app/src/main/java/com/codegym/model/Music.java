package com.codegym.model;


import javax.persistence.*;

@Entity
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "music_name")
    private String musicName;

    @Column(name = "single_name")
    private String singleName;

    private String link;

    public Music() {
    }

    public Music(Integer id, String musicName, String singleName, String link) {
        this.id = id;
        this.musicName = musicName;
        this.singleName = singleName;
        this.link = link;
    }

    public Music(String musicName, String singleName, String link) {
        this.musicName = musicName;
        this.singleName = singleName;
        this.link = link;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public String getSingleName() {
        return singleName;
    }

    public void setSingleName(String singleName) {
        this.singleName = singleName;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
