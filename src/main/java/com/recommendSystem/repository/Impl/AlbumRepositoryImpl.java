package com.recommendSystem.repository.Impl;

import com.recommendSystem.model.Album;
import com.recommendSystem.repository.AbstractRepository;
import com.recommendSystem.repository.AlbumRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class AlbumRepositoryImpl extends AbstractRepository implements AlbumRepository {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void addAlbum(Album album) {
        persist(album);
    }

    @Override
    public Album fetchAlbum(long id) {
        return (Album)getSession().get(Album.class, id);
    }
}
