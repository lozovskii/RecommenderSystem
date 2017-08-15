package com.recommendSystem.service;

import com.recommendSystem.model.Track;

public interface TrackService extends CountService {

    void addTrack(Track track);

//    Track fetchTrack(long idUserFk);

    boolean isExist(Track track);

    void updateTrack(Track track);

}
