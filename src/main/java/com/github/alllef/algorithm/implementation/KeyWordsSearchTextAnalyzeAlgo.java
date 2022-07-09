package com.github.alllef.algorithm.implementation;

import com.github.alllef.algorithm.result.KeyWordsPercentage;

import java.util.*;
import java.util.stream.Collectors;

public class KeyWordsSearchTextAnalyzeAlgo implements TextAnalyzeAlgo<KeyWordsPercentage> {
    private final Set<String> keyWords;
    private final String fileName;

    public KeyWordsSearchTextAnalyzeAlgo(Set<String> keyWords, String fileName) {
        this.keyWords = keyWords;
        this.fileName = fileName;
    }

    @Override
    public KeyWordsPercentage analyze(String text) {
        Set<String> words = new HashSet<>(getWords(text));
        int keyWordCounter = 0;
        for (String keyWord : keyWords) {
            if (words.contains(keyWord))
                keyWordCounter++;
        }
        double percentage = ((double) keyWordCounter / words.size()) * 100;
        return new KeyWordsPercentage(Map.of(fileName,percentage));
    }

    private List<String> getWords(String text) {
        return Arrays.stream(text.split("[\\W]"))
                .filter(str -> !str.equals(""))
                .collect(Collectors.toList());
    }
}