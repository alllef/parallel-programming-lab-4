package com.github.alllef.task;

import com.github.alllef.algorithm.AvgWordLengthTextAnalyzeAlgo;
import com.github.alllef.algorithm.TextAnalyzeAlgo;

import java.io.File;
import java.util.concurrent.ForkJoinPool;

public class PoolExecution implements Runnable {
    @Override
    public void run() {
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        TextAnalyzeAlgo textAnalyzeAlgo = new AvgWordLengthTextAnalyzeAlgo();
        String filePath = "src/main/resources/test-dir";
        System.out.println(forkJoinPool.invoke(new FolderSearchTask(textAnalyzeAlgo, new File(filePath))).get());
    }
}
