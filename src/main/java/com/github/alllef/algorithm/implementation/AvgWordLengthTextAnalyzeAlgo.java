package com.github.alllef.algorithm.implementation;

import com.github.alllef.algorithm.result.AvgWordLengthStats;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AvgWordLengthTextAnalyzeAlgo implements TextAnalyzeAlgo<AvgWordLengthStats> {
    @Override
    public AvgWordLengthStats analyze(String text) {
        var words = getWords(text);
        return new AvgWordLengthStats(calcAverage(words),getHistogram(words),calcStandardDeviation(words),words.size());
    }

    private List<String> getWords(String text) {
        return Arrays.stream(text.split("[\\W]"))
                .filter(str -> !str.equals(""))
                .collect(Collectors.toList());
    }

    private double calcAverage(List<String> words) {
        return words.stream()
                .mapToInt(String::length)
                .average()
                .orElse(0);
    }

    private Map<Integer, Integer> getHistogram(List<String> words) {
        var groupedMap =words
                .stream()
                .collect(Collectors.groupingBy(String::length));

        Map<Integer, Integer> histogramMap = new HashMap<>();
        groupedMap.forEach((key, value) -> histogramMap.put(key, value.size()));
        return histogramMap;
    }

    private double calcStandardDeviation(List<String> words) {
        double average = calcAverage(words);

        long wordsNum = words
                .size();

        double deviationPart = words
                .stream()
                .map(str -> Double.valueOf(str.length()))
                .reduce(0.0, (partial, next) -> partial + Math.pow(next - average, 2));

        return Math.sqrt(deviationPart / wordsNum);
    }
}
