package com.codegym.model;
import org.springframework.web.multipart.MultipartFile;
public class MusicForm {
    private int id;
    private String musicName;
    private String singleName;
    private MultipartFile link;

    public MusicForm() {
    }

    public MusicForm(int id, String musicName, String singleName, MultipartFile link) {
        this.id = id;
        this.musicName = musicName;
        this.singleName = singleName;
        this.link = link;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public MultipartFile getLink() {
        return link;
    }

    public void setLink(MultipartFile link) {
        this.link = link;
    }
}
