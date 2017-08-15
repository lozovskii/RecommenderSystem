package com.recommendSystem.repository.Impl;

import com.recommendSystem.model.Song;
import com.recommendSystem.repository.AbstractRepository;
import com.recommendSystem.repository.SongRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SongRepositoryImpl extends AbstractRepository implements SongRepository {

    @Autowired
    SessionFactory sessionFactory;

    public void addSong(Song song) {
        persist(song);
    }

    public Song fetchSong(long id) {
        return (Song)getSession().get(Song.class, id);
    }

    @Override
    public void updateSong(Song song) {
        getSession().update(song);
    }

}