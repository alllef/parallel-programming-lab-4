package com.github.alllef.task;

import java.io.File;
import java.util.concurrent.RecursiveTask;

public class FolderSearchTask extends RecursiveTask {
    private final File folder;

    public FolderSearchTask(File folder) {
        this.folder = folder;
    }

    @Override
    protected Object compute() {
        File[] files = folder.listFiles();

    }
}
