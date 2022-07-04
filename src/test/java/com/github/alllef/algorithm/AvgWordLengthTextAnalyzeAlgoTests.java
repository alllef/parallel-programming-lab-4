package com.github.alllef.algorithm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AvgWordLengthTextAnalyzeAlgoTests {
    private final AvgWordLengthTextAnalyzeAlgo avgWordLengthTextAnalyzeAlgo = new AvgWordLengthTextAnalyzeAlgo();

    @Test
    void executeTest() {
        String defaultString = """
                Will it work as expected, I hope it will work?""";
        String emptyString = "";
        String trickyString = "doesn't ain't match I see";
        String[] resultedString = trickyString.split("[\\W]");
        Assertions.assertEquals(3, (int) avgWordLengthTextAnalyzeAlgo.analyze(defaultString).get());
        Assertions.assertEquals(0, (int) avgWordLengthTextAnalyzeAlgo.analyze(emptyString).get());
        Assertions.assertEquals(4, (int) avgWordLengthTextAnalyzeAlgo.analyze(trickyString).get());
    }
}
