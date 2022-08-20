package com.codegym.service;

import com.codegym.model.Music;

import java.util.List;

public interface IMusic {
    List<Music> findAll();

    void addMusic(Music music);

    void delete(int id);

    Music findById(int id);

    void update( Music music);
}
