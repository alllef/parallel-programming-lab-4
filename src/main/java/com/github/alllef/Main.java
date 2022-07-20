package com.github.alllef;

import com.github.alllef.algorithm.performance.AvgWordLengthBenchmark;
import com.github.alllef.algorithm.performance.WordsGenerator;

public class Main {
    public static void main(String[] args) {
    // WordsGenerator wordsGenerator = new WordsGenerator();
   //  wordsGenerator.generateTexts(10,20000,50);
           AvgWordLengthBenchmark avgWordLengthBenchmark = new AvgWordLengthBenchmark();
        avgWordLengthBenchmark.writeResults("src/main/resources/text");
    }
}
