package com.recommendSystem.service.Impl;

import com.recommendSystem.constant.ConstantsConservative;
import com.recommendSystem.service.CountService;

public class CountServiceImpl implements CountService {

    @Override
    public double mainFormulaForGiveAMarkMu(double eta, double mu, double r) {
        double muNewN = 0;
        if(Math.abs(r) > mu){
            muNewN = (1 - eta) * mu + eta * r;
        }else if(Math.abs(r) <= mu){
            muNewN = mu;
        }
        return muNewN;
    }

    @Override
    public double mainFormulaForGiveAMarkMuPlusOne(double mu) {
        double muNewN = 0;
        if(mu < 0){
            muNewN = 0;
        }else if((mu >= 0) && (mu <= 1)) {
            muNewN = mu;
        }else if(mu > 1){
            muNewN = 1;
        }
        return muNewN;
    }

    @Override
    public double timeLearningFormula(int n) {
        return (ConstantsConservative.ALPHA / (ConstantsConservative.BETA + n));
    }

    @Override
    public double oblivionFormula(double muOld) {
        return ConstantsConservative.DELTA * muOld;
    }

    @Override
    public double formulaForGiveAMarkUpLow() {
        return 0;
    }

    @Override
    public double getR(int duration, int status) {
        double r = 0;
        double statusBuff = 0.15;
        if(status != 0){
            r = (((double)duration/100) - 0.2) + statusBuff;
            if(r <= statusBuff){
                r = 0.2;
            }
        }

        return r;
    }
}