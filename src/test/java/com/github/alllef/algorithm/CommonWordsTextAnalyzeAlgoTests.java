package com.github.alllef.algorithm;

import com.github.alllef.algorithm.implementation.CommonWordsTextAnalyzeAlgo;
import com.github.alllef.algorithm.implementation.TextAnalyzeAlgo;
import com.github.alllef.algorithm.result.CommonWords;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.Set;

public class CommonWordsTextAnalyzeAlgoTests {
    private final TextAnalyzeAlgo<CommonWords> algo = new CommonWordsTextAnalyzeAlgo();

    @Test
    void algoTest() {
        String text = "double double triple triple four";
        CommonWords result = algo.analyze(text);
        CommonWords expected = new CommonWords(Set.of("triple","double", "four"));
        assertEquals(expected,result);
    }

    @Test
    void combineTest(){
        CommonWords first = new CommonWords(Set.of("one","two","three"));
        CommonWords second = new CommonWords(Set.of("one","two","four"));
        CommonWords result = first.combine(second);
        assertEquals(Set.of("one","two"),result.words());
    }
}
