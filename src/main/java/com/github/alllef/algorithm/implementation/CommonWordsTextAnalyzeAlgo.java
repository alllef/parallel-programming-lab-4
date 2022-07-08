package com.github.alllef.algorithm.implementation;

import com.github.alllef.algorithm.result.CommonWords;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CommonWordsTextAnalyzeAlgo implements TextAnalyzeAlgo<CommonWords> {
    @Override
    public CommonWords analyze(String text) {
        return new CommonWords(new HashSet<>(getWords(text)));
    }

    private List<String> getWords(String text) {
        return Arrays.stream(text.split("[\\W]"))
                .filter(str -> !str.equals(""))
                .collect(Collectors.toList());
    }
}
