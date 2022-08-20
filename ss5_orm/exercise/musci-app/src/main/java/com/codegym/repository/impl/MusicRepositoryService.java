package com.codegym.repository.impl;

import com.codegym.model.Music;
import com.codegym.repository.IMusicRepositoryService;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
@Service
@Repository
public class MusicRepositoryService implements IMusicRepositoryService {

    @Override
    public List<Music> findAll() {
        TypedQuery typedQuery = BaseRepository.entityManager.createQuery
                ("select m from Music m", Music.class);
        return typedQuery.getResultList();

    }

    @Override
    public void addMusic(Music music) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(music);
        entityTransaction.commit();
    }


    @Override
    public void delete(int id) {
        Music music = BaseRepository.entityManager.find(Music.class,id);
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.remove(music);
        entityTransaction.commit();
    }

    @Override
    public Music findById(int id) {
            return BaseRepository.entityManager.find(Music.class, id);
    }

    @Override
    public void update(Music music) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(music);
        entityTransaction.commit();
    }
}
