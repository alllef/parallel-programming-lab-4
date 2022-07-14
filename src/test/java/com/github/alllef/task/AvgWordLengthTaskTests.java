package com.github.alllef.task;

import com.github.alllef.algorithm.result.AvgWordLengthStats;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AvgWordLengthTaskTests {
    /*@Test
    void computeTest() {
        // data1 has 3 words with length 6 5 6
        // data2 has 2 words with length 4 5
        AvgWordLengthStats stats = new PoolExecution().execute("src/main/resources/test-dir");

        Map<Integer, Integer> histogram = Map.of( 6, 2,5,2,4,1);
        assertEquals(5.08, stats.avgLength(), 0.1);
        assertEquals(histogram, stats.histogram());
        assertEquals(0.48, stats.standardDeviation(), 0.01);
        assertEquals(5,stats.wordsNum());
    }*/
}
