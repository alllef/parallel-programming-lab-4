package com.github.alllef.algorithm.performance;

public class ResultsBean {
    private int wordsNum;
    private long timeInMillisSeconds;

    public ResultsBean(int wordsNum, long timeInMillisSeconds) {
        this.wordsNum = wordsNum;
        this.timeInMillisSeconds = timeInMillisSeconds;
    }

    public int getWordsNum() {
        return wordsNum;
    }

    public void setWordsNum(int wordsNum) {
        this.wordsNum = wordsNum;
    }

    public long getTimeInMillisSeconds() {
        return timeInMillisSeconds;
    }

    public void setTimeInMillisSeconds(long timeInMillisSeconds) {
        this.timeInMillisSeconds = timeInMillisSeconds;
    }
}
