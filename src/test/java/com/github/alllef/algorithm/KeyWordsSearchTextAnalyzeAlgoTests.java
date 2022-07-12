package com.github.alllef.algorithm;

import com.github.alllef.algorithm.implementation.KeyWordsSearchTextAnalyzeAlgo;
import com.github.alllef.algorithm.implementation.TextAnalyzeAlgo;
import com.github.alllef.algorithm.result.KeyWordsPercentage;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Set;

public class KeyWordsSearchTextAnalyzeAlgoTests {
    private final TextAnalyzeAlgo<KeyWordsPercentage> algo = new KeyWordsSearchTextAnalyzeAlgo(Set.of("hello", "no", "yes"), "something");

    @Test
    void algoTest() {
        String testString = "Hello yes something";
        KeyWordsPercentage percentage = algo.analyze(testString);
        assertEquals(percentage.percentageByFile().get("something"),66,2);
    }

    @Test
    void combineTest(){
        KeyWordsPercentage percentageFirst = new KeyWordsPercentage(Map.of("hello",25.4));
        KeyWordsPercentage percentageSecond = new KeyWordsPercentage(Map.of("good",35.6,"bad",45.8));
        KeyWordsPercentage result = percentageFirst.combine(percentageSecond);
        assertEquals(Set.of("hello,good,bad"),result.percentageByFile().keySet());
    }
}
