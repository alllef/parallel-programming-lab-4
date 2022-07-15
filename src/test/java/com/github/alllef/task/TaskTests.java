package com.github.alllef.task;

import com.github.alllef.algorithm.result.AvgWordLengthStats;
import com.github.alllef.algorithm.result.CommonWords;
import com.github.alllef.algorithm.result.KeyWordsPercentage;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskTests {
    private final String filePath = "src/main/resources/test-dir";

    @Test
    void avgWordLengthTaskTest() {
        // data1 has 3 words with length 6 5 6
        // data2 has 2 words with length 4 5
        AvgWordLengthStats stats = new PoolExecution().executeAvgWordLength(filePath);

        Map<Integer, Integer> histogram = Map.of(6, 2, 5, 2, 4, 1);
        assertEquals(5.08, stats.avgLength(), 0.1);
        assertEquals(histogram, stats.histogram());
        assertEquals(0.48, stats.standardDeviation(), 0.01);
        assertEquals(5, stats.wordsNum());
    }

    @Test
    void commonWordsTaskTest() {
        CommonWords commonWords = new PoolExecution().executeCommonWords(filePath);
        Set<String> expectedSet = Set.of();
        Set<String> actualSet = commonWords.words();
        assertEquals(expectedSet, actualSet);
    }

    @Test
    void keyWordsSearchTaskTest() {
        KeyWordsPercentage keyWordsPercentage = new PoolExecution().executeKeyWordsPercentage(filePath, Set.of("ffsfsf", "egwef"));
     //   Map<String, Double> expectedMap = Map.of("data1", 66.6, "data2", 0);
        var actualMap = keyWordsPercentage.percentageByFile();
        assertEquals(actualMap.get("data1.txt"),66.6,0.2);
        assertEquals(actualMap.get("data2.txt"),0,0.2);
    }
}
