package fr.ippon.tennis;

interface ResultProvider {

    boolean checkScore();
    TennisResult getResult();
}