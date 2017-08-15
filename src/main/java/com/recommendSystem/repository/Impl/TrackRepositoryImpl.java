package com.recommendSystem.repository.Impl;

import com.recommendSystem.model.Track;
import com.recommendSystem.repository.AbstractRepository;
import com.recommendSystem.repository.TrackRepository;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TrackRepositoryImpl extends AbstractRepository implements TrackRepository {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void addTrack(Track track) {
        persist(track);
    }

//    @Override
//    public Track fetchTrack(long idUserFk) {
//        Query query = getSession().createQuery("from Track where idUserFk=:idUserFk");
//        query.setParameter("idUserFk", idUserFk);
//        return (Track) query.uniqueResult();
//    }

    @Override
    public boolean isExist(Track track) {
        try {
            Query query = getSession().createQuery("from Track where trackName=:songName and trackNameArtist=:songNameArtist and idUserFk=:idUserFk");
            query.setParameter("idUserFk", track.getIdUserFk());
            query.setParameter("songName", track.getTrackName());
            query.setParameter("songNameArtist", track.getTrackNameArtist());
            Track track1 = (Track) query.uniqueResult();
            return track1.getTrackName() != null;
        }catch (NullPointerException e){
            return false;
        }
    }

    @Override
    public void updateTrack(Track track) {
        getSession().update(track);
    }

    @Override
    public int getTrackDurationFromUserActiv(long idUserFk) {
        try{
//            Query query = getSession().createQuery("from Song where ");
            return 0;
        }catch (NullPointerException e){
            return 0;
        }
    }

    @Override
    public int getTrackStatusFromUserActiv(long idUserFk) {
        return 0;
    }
}