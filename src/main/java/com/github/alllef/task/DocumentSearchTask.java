package com.github.alllef.task;

import com.github.alllef.algorithm.TextAnalyzeAlgo;

import java.util.concurrent.RecursiveTask;

public class DocumentSearchTask extends RecursiveTask {
    private final TextAnalyzeAlgo textAnalyzeAlgo;
    private final String text;

    public DocumentSearchTask(TextAnalyzeAlgo textAnalyzeAlgo, String text) {
        this.textAnalyzeAlgo = textAnalyzeAlgo;
        this.text = text;
    }

    @Override
    protected Long compute() {
        return textAnalyzeAlgo.analyze(text);
    }
}
