package com.github.alllef.algorithm.performance.matrix_multiply;

public class MultiplyResultsBean {
    private int matrixSize;
    private long timeInMillisSeconds;
    private double speedup;

    public MultiplyResultsBean(int matrixSize, long timeInMillisSeconds, double speedup) {
        this.matrixSize = matrixSize;
        this.timeInMillisSeconds = timeInMillisSeconds;
        this.speedup = speedup;
    }

    public int getMatrixSize() {
        return matrixSize;
    }

    public void setMatrixSize(int matrixSize) {
        this.matrixSize = matrixSize;
    }

    public long getTimeInMillisSeconds() {
        return timeInMillisSeconds;
    }

    public void setTimeInMillisSeconds(long timeInMillisSeconds) {
        this.timeInMillisSeconds = timeInMillisSeconds;
    }

    public double getSpeedup() {
        return speedup;
    }

    public void setSpeedup(double speedup) {
        this.speedup = speedup;
    }
}
