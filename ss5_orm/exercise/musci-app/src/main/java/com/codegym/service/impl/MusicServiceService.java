package com.codegym.service.impl;

import com.codegym.model.Music;
import com.codegym.repository.IMusicRepositoryService;
import com.codegym.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicServiceService implements IMusicService {
    @Autowired
    IMusicRepositoryService iMusicRepositoryService;
    @Override
    public List<Music> findAll() {
        return iMusicRepositoryService.findAll();
    }

    @Override
    public void addMusic(Music music) {
        iMusicRepositoryService.addMusic(music);
    }

    @Override
    public void delete(int id) {
        iMusicRepositoryService.delete(id);
    }

    @Override
    public Music findById(int id) {
        return iMusicRepositoryService.findById(id);
    }

    @Override
    public void update(Music music) {
        iMusicRepositoryService.update(music);
    }
}
