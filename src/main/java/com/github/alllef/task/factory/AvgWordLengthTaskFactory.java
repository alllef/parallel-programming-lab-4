package com.github.alllef.task.factory;

import com.github.alllef.algorithm.result.AvgWordLengthStats;
import com.github.alllef.task.DocumentSearchTask;
import com.github.alllef.task.FolderSearchTask;
import com.github.alllef.task.factory.TaskFactory;

import java.io.File;

public class AvgWordLengthTaskFactory implements TaskFactory<AvgWordLengthStats> {
    @Override
    public DocumentSearchTask<AvgWordLengthStats> getDocumentSearchTask(File file) {
        return DocumentSearchTask.getAvgWordLengthTask(file);
    }

    @Override
    public FolderSearchTask<AvgWordLengthStats> getKeyWordsFolderSearchTask(File file) {
        return FolderSearchTask.getAvgWordLengthTask(file);
    }
}
