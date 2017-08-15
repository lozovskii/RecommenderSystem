package com.recommendSystem.service;

public interface CountService {

    double mainFormulaForGiveAMarkMu(double eta, double mu, double r);

    double mainFormulaForGiveAMarkMuPlusOne(double mu);

    double timeLearningFormula(int n);

    double oblivionFormula(double muOld);

    double formulaForGiveAMarkUpLow();

    double getR(int duration, int status);

}
