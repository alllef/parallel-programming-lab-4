package com.github.alllef.task;

import com.github.alllef.algorithm.implementation.TextAnalyzeAlgo;
import com.github.alllef.algorithm.result.AvgWordLengthStats;

import java.io.File;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Supplier;

public class PoolExecution {

   /* public AvgWordLengthStats execute(String filePath) {
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        return forkJoinPool.invoke(new AvgWordLengthFolderSearchTask(new File(filePath)));
    }*/
}
