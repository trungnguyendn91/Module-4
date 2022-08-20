package com.codegym.repository;

import com.codegym.model.Music;

import java.util.List;

public interface IMusicRepositoryService {
    List<Music> findAll();

    void addMusic(Music music);

    void delete(int id);

    Music findById(int id);

    void update( Music music);
}
