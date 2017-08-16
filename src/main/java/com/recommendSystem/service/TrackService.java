package com.recommendSystem.service;

import com.recommendSystem.model.Track;

import java.util.List;

public interface TrackService extends CountService {

    void addTrack(Track track);

    Track fetchTrack(long idUserFk);

    Track fetchTrackId(long id);

    boolean isExist(Track track);

    void updateTrack(Track track);

    List getAllTracks();

}
