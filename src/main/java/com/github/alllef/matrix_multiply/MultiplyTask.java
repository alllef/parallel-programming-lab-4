package com.github.alllef.matrix_multiply;

import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class MultiplyTask extends RecursiveTask<int[][]> {
    private final int subTaskNum;
    private final int[] firstMatrRow;
    private final int[][] secondMatr;
    private final int[][] resultMatr;
    private final int currIter;

    public MultiplyTask(int currIter, int subTaskNum, int[] firstMatrRow, int[][] secondMatr, int[][] resultMatr) {
        super();
        this.subTaskNum = subTaskNum;
        this.currIter = currIter;
        this.firstMatrRow = firstMatrRow;
        this.secondMatr = secondMatr;
        this.resultMatr = resultMatr;
    }

    @Override
    protected int[][] compute() {
        int iterNum = secondMatr[0].length;
        int columnNum = firstMatrRow.length;
        int currSecondMatrCol = subTaskNum - currIter;
        if (currSecondMatrCol < 0)
            currSecondMatrCol = iterNum - (-currSecondMatrCol);
        for (int currCol = 0; currCol < columnNum; currCol++) {
            resultMatr[subTaskNum][currSecondMatrCol] += firstMatrRow[currCol] * secondMatr[currCol][currSecondMatrCol];
        }
        if (currIter+1 < iterNum) {
            MultiplyTask multiplyTask = new MultiplyTask(currIter + 1, subTaskNum, firstMatrRow, secondMatr, resultMatr);
            ForkJoinTask.invokeAll(List.of(multiplyTask));
        }
        return null;
    }
}
