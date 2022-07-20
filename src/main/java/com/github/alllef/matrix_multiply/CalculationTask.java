package com.github.alllef.matrix_multiply;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class CalculationTask extends RecursiveTask<int[][]> {
    private final int[][] firstMatr;
    private final int[][] secondMatr;

    public CalculationTask(int[][] firstMatr, int[][] secondMatr) {
        this.firstMatr = firstMatr;
        this.secondMatr = secondMatr;
    }

    @Override
    protected int[][] compute() {
        int[][] resultMatr = new int[firstMatr.length][secondMatr[0].length];
        List<ForkJoinTask<int[][]>> processes = new ArrayList<>();

        for (int matrRow = 0; matrRow < firstMatr.length; matrRow++) {
            MultiplyTask stripedBlockProcess = new MultiplyTask(0, matrRow, firstMatr[matrRow], secondMatr, resultMatr);
            processes.add(stripedBlockProcess);
        }
        ForkJoinTask.invokeAll(processes).forEach(ForkJoinTask::join);
        return resultMatr;
    }
}

