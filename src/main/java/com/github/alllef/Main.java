package com.github.alllef;

import com.github.alllef.algorithm.performance.matrix_multiply.MatrixMultiplyBenchMark;
import com.github.alllef.algorithm.performance.word_length.AvgWordLengthBenchmark;

public class Main {
    public static void main(String[] args) {
    // WordsGenerator wordsGenerator = new WordsGenerator();
   //  wordsGenerator.generateTexts(10,20000,50);
          // AvgWordLengthBenchmark avgWordLengthBenchmark = new AvgWordLengthBenchmark();
       // avgWordLengthBenchmark.writeResults("src/main/resources/text");
        MatrixMultiplyBenchMark matrixMultiplyBenchMark = new MatrixMultiplyBenchMark();
        matrixMultiplyBenchMark.calculate();
    }
}
