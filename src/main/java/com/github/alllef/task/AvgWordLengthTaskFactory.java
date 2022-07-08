package com.github.alllef.task;

import com.github.alllef.algorithm.result.AvgWordLengthStats;

import java.io.File;

public class AvgWordLengthTaskFactory implements TaskFactory<AvgWordLengthStats> {
    @Override
    public DocumentSearchTask<AvgWordLengthStats> getDocumentSearchTask(File file) {
        return new AvgWordLengthDocumentSearchTask(file);
    }

    @Override
    public FolderSearchTask<AvgWordLengthStats> getFolderSearchTask(File file) {
        return new AvgWordLengthFolderSearchTask(file);
    }
}
