package com.github.alllef.task.factory;

import com.github.alllef.algorithm.result.CommonWords;
import com.github.alllef.task.DocumentSearchTask;
import com.github.alllef.task.FolderSearchTask;

import java.io.File;

public class CommonWordsTaskFactory implements TaskFactory<CommonWords>{
    @Override
    public DocumentSearchTask<CommonWords> getDocumentSearchTask(File file) {
        return DocumentSearchTask.getCommonWordsTask(file);
    }

    @Override
    public FolderSearchTask<CommonWords> getFolderSearchTask(File file) {
        return FolderSearchTask.getCommonWordsTask(file);
    }
}
