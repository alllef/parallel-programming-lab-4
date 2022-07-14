package com.github.alllef.task.factory;

import com.github.alllef.algorithm.result.Combineable;
import com.github.alllef.task.DocumentSearchTask;
import com.github.alllef.task.FolderSearchTask;

import java.io.File;
import java.util.Set;

public interface TaskFactory<T extends Combineable<T>> {
    DocumentSearchTask<T> getDocumentSearchTask(File file);
    FolderSearchTask<T> getKeyWordsFolderSearchTask(File file);

    default FolderSearchTask<T> getKeyWordsFolderSearchTask(File file, Set<String> keyWords) {
        return null;
    }
}
