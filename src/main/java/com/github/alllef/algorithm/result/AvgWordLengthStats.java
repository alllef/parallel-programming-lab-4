package com.github.alllef.algorithm.result;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public record AvgWordLengthStats(double avgLength, Map<Integer, Integer> histogram, double standardDeviation,
                                 int wordsNum) implements Combineable<AvgWordLengthStats>{

    @Override
    public AvgWordLengthStats combine(AvgWordLengthStats entity) {
        double newAvgLength = (this.avgLength + entity.avgLength()) / 2;

        Map<Integer, Integer> newHistogram = new HashMap<>();

        Set<Integer> allKeys = new HashSet<>(this.histogram.keySet());
        allKeys.addAll(entity.histogram().keySet());


        for (Integer key : allKeys)
            newHistogram.put(key, this.histogram.getOrDefault(key, 0) + entity.histogram().getOrDefault(key, 0));

        double newStandardDeviation = (this.standardDeviation + entity.standardDeviation()) / 2;
        int newWordsNum = this.wordsNum + entity.wordsNum();
        return new AvgWordLengthStats(newAvgLength, newHistogram, newStandardDeviation, newWordsNum);
    }
}