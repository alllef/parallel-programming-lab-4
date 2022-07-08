package com.github.alllef.task;

import com.github.alllef.algorithm.implementation.TextAnalyzeAlgo;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.function.Supplier;

public abstract class FolderSearchTask<T> extends RecursiveTask<T> {
    private final File folder;
    private TaskFactory<T> taskFactory;

    public FolderSearchTask(File document) {
        this.folder = document;
        this.taskFactory=getTaskFactory();
    }

    @Override
    protected T compute() {
        File[] files = folder.listFiles();
        List<ForkJoinTask<T>> tasks = new ArrayList<>();
        for (File file : files) {
            if (file.isFile())
                tasks.add(taskFactory.getDocumentSearchTask(file));
            else
                tasks.add(taskFactory.getFolderSearchTask(file));
        }
        return combineTasks(FolderSearchTask.invokeAll(tasks));
    }

    protected abstract T combineTasks(Collection<ForkJoinTask<T>> tasks);
    protected abstract TaskFactory<T> getTaskFactory();
}