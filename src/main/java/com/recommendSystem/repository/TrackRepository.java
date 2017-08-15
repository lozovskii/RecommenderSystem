package com.recommendSystem.repository;

import com.recommendSystem.model.Track;

public interface TrackRepository {

    void addTrack(Track track);

//    Track fetchTrack(long idUserFk);

    boolean isExist(Track track);

    void updateTrack(Track track);

    int getTrackDurationFromUserActiv(long idUserFk);

    int getTrackStatusFromUserActiv(long idUserFk);

}
