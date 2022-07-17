package com.github.alllef;

import com.github.alllef.algorithm.performance.WordsGenerator;

public class Main {
    public static void main(String[] args) {
        WordsGenerator wordsGenerator = new WordsGenerator();
        wordsGenerator.generateTexts(10,500,20);
    }
}
