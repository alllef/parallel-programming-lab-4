package com.github.alllef.task;

import java.io.File;

public interface TaskFactory<T> {
    DocumentSearchTask<T> getDocumentSearchTask(File file);
    FolderSearchTask<T> getFolderSearchTask(File file);
}
