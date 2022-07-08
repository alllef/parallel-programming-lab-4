package com.github.alllef.task;

import com.github.alllef.algorithm.result.AvgWordLengthStats;

import java.io.File;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ForkJoinTask;

public class AvgWordLengthFolderSearchTask extends FolderSearchTask<AvgWordLengthStats> {
    public AvgWordLengthFolderSearchTask(File document) {
        super(document);
    }

    @Override
    protected AvgWordLengthStats combineTasks(Collection<ForkJoinTask<AvgWordLengthStats>> forkJoinTasks) {
        var forkJoinTaskList = forkJoinTasks.stream().toList();
        var finalStats = forkJoinTaskList.get(0).join();
        for (int i = 1; i < forkJoinTaskList.size(); i++)
            finalStats =finalStats.add(forkJoinTaskList.get(i).join());
        return finalStats;
    }

    @Override
    protected TaskFactory<AvgWordLengthStats> getTaskFactory() {
        return new AvgWordLengthTaskFactory();
    }
}
