package com.github.alllef.task.factory;

import com.github.alllef.algorithm.result.KeyWordsPercentage;
import com.github.alllef.task.DocumentSearchTask;
import com.github.alllef.task.FolderSearchTask;

import java.io.File;
import java.util.Set;

public class KeyWordsSearchTaskFactory implements TaskFactory<KeyWordsPercentage>{
    private final Set<String> keyWords;

    public KeyWordsSearchTaskFactory(Set<String> keyWords) {
        this.keyWords = keyWords;
    }

    @Override
    public DocumentSearchTask<KeyWordsPercentage> getDocumentSearchTask(File file) {
        return DocumentSearchTask.getKeyWordsSearchTask(file,keyWords);
    }

    @Override
    public FolderSearchTask<KeyWordsPercentage> getFolderSearchTask(File file) {
        return FolderSearchTask.getKeyWordsSearchTask(file,keyWords);
    }
}
