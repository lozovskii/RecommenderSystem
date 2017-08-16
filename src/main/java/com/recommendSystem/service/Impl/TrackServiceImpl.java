package com.recommendSystem.service.Impl;

import com.recommendSystem.model.Track;
import com.recommendSystem.repository.TrackRepository;
import com.recommendSystem.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class TrackServiceImpl extends CountServiceImpl implements TrackService{

    @Autowired
    TrackRepository trackRepository;

    @Override
    public void addTrack(Track track) {
        trackRepository.addTrack(track);
    }

    @Override
    public Track fetchTrack(long idUserFk) {
        return trackRepository.fetchTrack(idUserFk);
    }

    @Override
    public Track fetchTrackId(long id) {
        return trackRepository.fetchTrackId(id);
    }

    @Override
    public boolean isExist(Track track) {
        return trackRepository.isExist(track);
    }

    @Override
    public void updateTrack(Track track) {
        trackRepository.updateTrack(track);
    }

    @Override
    public List getAllTracks() {
        return trackRepository.getAllTracks();
    }

}
