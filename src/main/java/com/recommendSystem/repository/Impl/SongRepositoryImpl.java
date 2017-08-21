package com.recommendSystem.repository.Impl;

import com.recommendSystem.model.Song;
import com.recommendSystem.model.User;
import com.recommendSystem.repository.AbstractRepository;
import com.recommendSystem.repository.SongRepository;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Override
    public List<Song> getAllSongs(User user) {
        SQLQuery sqlQuery = getSession().createSQLQuery("SELECT * FROM user u JOIN user_activ s ON u.imei = s.imei_fk WHERE s.imei_fk=:idUser");
        sqlQuery.addEntity("user_activ", Song.class);
        sqlQuery.addEntity("user", User.class);

        sqlQuery.setParameter("idUser", user.getImei());

        return (List<Song>)sqlQuery.list();
    }
}