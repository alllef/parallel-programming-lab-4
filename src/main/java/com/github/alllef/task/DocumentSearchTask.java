package com.github.alllef.task;

import com.github.alllef.algorithm.TextAnalyzeAlgo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.RecursiveTask;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DocumentSearchTask extends RecursiveTask<Supplier<?>> {
    private final TextAnalyzeAlgo textAnalyzeAlgo;
    private final File document;

    public DocumentSearchTask(TextAnalyzeAlgo textAnalyzeAlgo, File document) {
        this.textAnalyzeAlgo = textAnalyzeAlgo;
        this.document = document;
    }

    @Override
    protected Supplier<?> compute() {
        Supplier<?> algo = () -> textAnalyzeAlgo.analyze(documentToText());
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
}
