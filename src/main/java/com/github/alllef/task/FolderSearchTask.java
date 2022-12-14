package com.github.alllef.task;

import com.github.alllef.algorithm.result.AvgWordLengthStats;
import com.github.alllef.algorithm.result.Combineable;
import com.github.alllef.algorithm.result.CommonWords;
import com.github.alllef.algorithm.result.KeyWordsPercentage;
import com.github.alllef.task.factory.AvgWordLengthTaskFactory;
import com.github.alllef.task.factory.CommonWordsTaskFactory;
import com.github.alllef.task.factory.KeyWordsSearchTaskFactory;
import com.github.alllef.task.factory.TaskFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class FolderSearchTask<T extends Combineable<T>> extends RecursiveTask<T> {
    private final File folder;
    private final TaskFactory<T> taskFactory;
    private Set<String> keyWords;

    private FolderSearchTask(File document, TaskFactory<T> taskFactory) {
        this.folder = document;
        this.taskFactory = taskFactory;
    }

    public FolderSearchTask(File folder, TaskFactory<T> taskFactory, Set<String> keyWords) {
        this.folder = folder;
        this.taskFactory = taskFactory;
        this.keyWords = keyWords;
    }

    @Override
    protected T compute() {
        File[] files = folder.listFiles();
        List<ForkJoinTask<T>> tasks = new ArrayList<>();
        for (File file : files) {
            if (file.isFile())
                tasks.add(taskFactory.getDocumentSearchTask(file));
            else if (keyWords != null)
                tasks.add(taskFactory.getKeyWordsFolderSearchTask(file, keyWords));
            else
                tasks.add(taskFactory.getKeyWordsFolderSearchTask(file));
        }
        return combineTasks(FolderSearchTask.invokeAll(tasks));
    }

    protected T combineTasks(Collection<ForkJoinTask<T>> forkJoinTasks) {
        var forkJoinTaskList = forkJoinTasks.stream().toList();
        var finalStats = forkJoinTaskList.get(0).join();
        for (int i = 1; i < forkJoinTaskList.size(); i++)
            finalStats = finalStats.combine(forkJoinTaskList.get(i).join());
        return finalStats;
    }

    public static FolderSearchTask<AvgWordLengthStats> getAvgWordLengthTask(File file) {
        return new FolderSearchTask<>(file, new AvgWordLengthTaskFactory());
    }

    public static FolderSearchTask<CommonWords> getCommonWordsTask(File file) {
        return new FolderSearchTask<>(file, new CommonWordsTaskFactory());
    }

    public static FolderSearchTask<KeyWordsPercentage> getKeyWordsSearchTask(File file, Set<String> keyWords) {
        return new FolderSearchTask<>(file, new KeyWordsSearchTaskFactory(keyWords), keyWords);
    }

}