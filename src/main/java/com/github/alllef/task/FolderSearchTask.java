package com.github.alllef.task;

import com.github.alllef.algorithm.TextAnalyzeAlgo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.function.Supplier;

public class FolderSearchTask extends RecursiveTask<Supplier<?>> {
    private final TextAnalyzeAlgo textAnalyzeAlgo;
    private final File folder;

    public FolderSearchTask(TextAnalyzeAlgo textAnalyzeAlgo, File document) {
        this.textAnalyzeAlgo = textAnalyzeAlgo;
        this.folder = document;
    }

    @Override
    protected Supplier<?> compute() {
        File[] files = folder.listFiles();
        List<ForkJoinTask<Supplier<?>>> tasks = new ArrayList<>();
        for (File file : files) {
            if (file.isFile())
                tasks.add(new DocumentSearchTask(textAnalyzeAlgo, file));
            else
                tasks.add(new FolderSearchTask(textAnalyzeAlgo,file));
        }
        return ()-> FolderSearchTask.invokeAll(tasks)
                .stream()
                .mapToInt(task->(int)task.join().get())
                .average();
    }
}
