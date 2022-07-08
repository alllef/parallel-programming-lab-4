package com.github.alllef.algorithm;

import com.github.alllef.algorithm.implementation.AvgWordLengthTextAnalyzeAlgo;

import static org.junit.jupiter.api.Assertions.*;

import com.github.alllef.algorithm.implementation.TextAnalyzeAlgo;
import com.github.alllef.algorithm.result.AvgWordLengthStats;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class AvgWordLengthTextAnalyzeAlgoTests {
    private final TextAnalyzeAlgo<AvgWordLengthStats> avgWordLengthTextAnalyzeAlgo = new AvgWordLengthTextAnalyzeAlgo();

    @Test
    void executeTest() {
        String defaultString = """
                Will it work as expected""";
        AvgWordLengthStats stats = avgWordLengthTextAnalyzeAlgo.analyze(defaultString);
        Map<Integer, Integer> histogram = Map.of( 4, 2,2, 2, 8, 1);
        assertEquals(4.0, stats.avgLength(), 0.1);
        assertEquals(histogram, stats.histogram());
        assertEquals(2.19, stats.standardDeviation(), 0.1);
        assertEquals(5,stats.wordsNum());
    }
}
