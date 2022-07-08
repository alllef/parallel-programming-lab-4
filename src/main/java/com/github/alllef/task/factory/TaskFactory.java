package com.github.alllef.task.factory;

import com.github.alllef.algorithm.result.Combineable;
import com.github.alllef.task.DocumentSearchTask;
import com.github.alllef.task.FolderSearchTask;

import java.io.File;

public interface TaskFactory<T extends Combineable<T>> {
    DocumentSearchTask<T> getDocumentSearchTask(File file);
    FolderSearchTask<T> getFolderSearchTask(File file);
}
