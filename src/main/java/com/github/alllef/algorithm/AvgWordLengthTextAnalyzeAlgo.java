package com.github.alllef.algorithm;

import java.util.Arrays;
import java.util.function.Supplier;

public class AvgWordLengthTextAnalyzeAlgo implements TextAnalyzeAlgo {
    @Override
    public Supplier<?> analyze(String text) {
        return () -> Arrays.stream(text.split(" +"))
                .mapToInt(String::length)
                .average()
                .stream()
                .mapToInt(d -> Double.valueOf(d).intValue())
                .findAny()
                .orElse(0);

    }
}
