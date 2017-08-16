package com.recommendSystem.repository;

import com.recommendSystem.model.Track;

import java.util.List;

public interface TrackRepository {

    void addTrack(Track track);

    Track fetchTrack(long idUserFk);

    Track fetchTrackId(long id);

    boolean isExist(Track track);

    void updateTrack(Track track);

    List getAllTracks();

}
