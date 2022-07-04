package com.github.alllef.task;

import com.github.alllef.algorithm.AvgWordLengthTextAnalyzeAlgo;
import com.github.alllef.algorithm.TextAnalyzeAlgo;

import java.io.File;
import java.util.concurrent.Callable;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Supplier;

public class PoolExecution {

    public Supplier<?> execute(String filePath,TextAnalyzeAlgo textAnalyzeAlgo) {
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        return ()->forkJoinPool.invoke(new FolderSearchTask(textAnalyzeAlgo, new File(filePath))).get();
    }
}
