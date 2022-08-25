package com.codegym.model;

import javax.persistence.*;

@Entity
@Table (name = "music")
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "music_name")
    private String musicName;

    @Column(name = "single_name")
    private String singleName;

    private String type;

    public Music() {
    }

    public Music(Integer id, String musicName, String singleName, String type) {
        this.id = id;
        this.musicName = musicName;
        this.singleName = singleName;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
