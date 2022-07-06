package com.github.alllef.algorithm;

import com.github.alllef.Main;

import java.util.Arrays;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class AvgWordLengthTextAnalyzeAlgo implements TextAnalyzeAlgo {
    @Override
    public Supplier<?> analyze(String text) {
        return () -> Arrays.stream(text.split("[\\W]"))
                .filter(str -> !str.equals(""))
                .mapToInt(String::length)
                .average()
                .orElse(0);
    }

    private Stream<String> getWords(String text) {
        return Arrays.stream(text.split("[\\W]"))
                .filter(str -> !str.equals(""));
    }

    private double calcAverage(String text) {
        return getWords(text)
                .mapToInt(String::length)
                .average()
                .orElse(0);
    }

    private double calcStandardDeviation(String text) {
        double average = calcAverage(text);

        long wordsNum = getWords(text)
                .count();

        return getWords(text)
                .map(str -> Double.valueOf(str.length()))
                .reduce(0.0, (partial, next) -> partial + Math.pow(next - average, 2)) / wordsNum;
    }
}
