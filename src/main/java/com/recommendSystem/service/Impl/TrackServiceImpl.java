package com.recommendSystem.service.Impl;

import com.recommendSystem.model.Track;
import com.recommendSystem.repository.TrackRepository;
import com.recommendSystem.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class TrackServiceImpl extends CountServiceImpl implements TrackService{

    @Autowired
    TrackRepository trackRepository;

    @Override
    public void addTrack(Track track) {
        trackRepository.addTrack(track);
    }

//    @Override
//    public Track fetchTrack(long idUserFk) {
//        return trackRepository.fetchTrack(idUserFk);
//    }

    @Override
    public boolean isExist(Track track) {
        return trackRepository.isExist(track);
    }

    @Override
    public void updateTrack(Track track) {
        trackRepository.updateTrack(track);
    }

//    @Override
//    public double mainFormulaForGiveAMarkMu(double eta, double mu, double r) {
//        return super.mainFormulaForGiveAMarkMu(eta, mu, r);
//    }
//
//    @Override
//    public double mainFormulaForGiveAMarkMuPlusOne(double mu) {
//        return super.mainFormulaForGiveAMarkMuPlusOne(mu);
//    }
//
//    @Override
//    public double timeLearningFormula(int n) {
//        return super.timeLearningFormula(n);
//    }
//
//    @Override
//    public double oblivionFormula(double muOld) {
//        return super.oblivionFormula(muOld);
//    }
//
//    @Override
//    public double formulaForGiveAMarkUpLow() {
//        return super.formulaForGiveAMarkUpLow();
//    }
}
