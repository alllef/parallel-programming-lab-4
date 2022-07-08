package com.github.alllef.task;

import com.github.alllef.algorithm.implementation.AvgWordLengthTextAnalyzeAlgo;
import com.github.alllef.algorithm.implementation.CommonWordsTextAnalyzeAlgo;
import com.github.alllef.algorithm.implementation.TextAnalyzeAlgo;
import com.github.alllef.algorithm.result.AvgWordLengthStats;
import com.github.alllef.algorithm.result.CommonWords;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.RecursiveTask;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DocumentSearchTask<T> extends RecursiveTask<T> {
    private TextAnalyzeAlgo<T> textAnalyzeAlgo;
    private final File document;

    private DocumentSearchTask(File document, TextAnalyzeAlgo<T> textAnalyzeAlgo) {
        this.document = document;
        this.textAnalyzeAlgo = textAnalyzeAlgo;
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

    public static DocumentSearchTask<AvgWordLengthStats> getAvgWordLengthTask(File file) {
        return new DocumentSearchTask<>(file, new AvgWordLengthTextAnalyzeAlgo());
    }

    public static DocumentSearchTask<CommonWords> getCommonWordsTask(File file) {
        return new DocumentSearchTask<>(file, new CommonWordsTextAnalyzeAlgo());
    }
}
