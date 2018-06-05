package com.tul.ksr.Fuzzy.Operations;

/**
 * Created by Kaszuba on 05.06.2018.
 */
public class SummarizationAnswer {
    private String answer;
    private double quality;

    public SummarizationAnswer(String answer, double quality) {
        this.answer = answer;
        this.quality = quality;
    }

    public String getAnswer() {
        return answer;
    }

    public double getQuality() {
        return quality;
    }

    @Override
    public String toString() {
        return answer +" [" + quality + "] ";
    }
}
