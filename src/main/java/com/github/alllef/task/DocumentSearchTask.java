package com.github.alllef.task;

import com.github.alllef.algorithm.implementation.TextAnalyzeAlgo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.RecursiveTask;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class DocumentSearchTask<T> extends RecursiveTask<T> {
    private TextAnalyzeAlgo<T> textAnalyzeAlgo;
    private final File document;

    public DocumentSearchTask(File document) {
        this.document = document;
        this.textAnalyzeAlgo=getTextAnalyzeAlgo();
    }

    @Override
    protected T compute() {
        return textAnalyzeAlgo.analyze(documentToText());
    }

    private String documentToText() {
        try (Stream<String> lines = Files.lines(Paths.get(document.toURI()))) {
            return lines.collect(Collectors.joining());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public abstract TextAnalyzeAlgo<T> getTextAnalyzeAlgo();
}
