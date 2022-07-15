package com.github.alllef.task;

import com.github.alllef.algorithm.result.AvgWordLengthStats;
import com.github.alllef.algorithm.result.CommonWords;
import com.github.alllef.algorithm.result.KeyWordsPercentage;

import java.io.File;
import java.util.Set;
import java.util.concurrent.ForkJoinPool;

public class PoolExecution {

    public AvgWordLengthStats executeAvgWordLength(String filePath) {
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        return forkJoinPool.invoke(FolderSearchTask.getAvgWordLengthTask(new File(filePath)));
    }

    public CommonWords executeCommonWords(String filePath) {
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        return forkJoinPool.invoke(FolderSearchTask.getCommonWordsTask(new File(filePath)));
    }

    public KeyWordsPercentage executeKeyWordsPercentage(String filePath, Set<String> keyWords) {
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        return forkJoinPool.invoke(FolderSearchTask.getKeyWordsSearchTask(new File(filePath), keyWords));
    }

}
