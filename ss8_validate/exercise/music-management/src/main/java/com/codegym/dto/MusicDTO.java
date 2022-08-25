package com.codegym.dto;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class MusicDTO {
    private Integer id;
    @NotBlank(message = "Vui Lòng không bỏ trống")
    @Size(max = 800, message = "Không được quá 800 ký tự")
    @Pattern(regexp = "^[A-Za-z0-9 ]*$", message = "Không nhập ký tự đặc biệt")
    private String musicName;
    @NotBlank(message = "Vui Lòng không bỏ trống")
    @Size(max = 300, message = "Không được quá 300 ký tự")
    @Pattern(regexp = "^[A-Za-z0-9 ]*$", message = "Không nhập ký tự đặc biệt")
    private String singleName;
    @NotBlank(message = "Vui Lòng không bỏ trống")
    @Size(max = 1000, message = "Không được quá 1000 ký tự")
    @Pattern(regexp = "^[A-Za-z0-9 \\,]*$", message = "Không nhập ký tự đặc biệt. Ngoại trừ dấu phẩy")
    private String type;

    public MusicDTO() {
    }

    public MusicDTO(Integer id, String musicName, String singleName, String type) {
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
