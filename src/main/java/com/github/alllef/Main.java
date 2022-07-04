package com.github.alllef;

import com.github.alllef.algorithm.AvgWordLengthTextAnalyzeAlgo;
import com.github.alllef.task.PoolExecution;

public class Main {
    public static void main(String[] args) {
         System.out.println(new PoolExecution().execute("src/main/resources/test-dir",new AvgWordLengthTextAnalyzeAlgo()).get());
    }
}
