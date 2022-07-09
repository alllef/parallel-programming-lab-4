package com.github.alllef.algorithm.result;

import java.util.HashMap;
import java.util.Map;

public record KeyWordsPercentage(Map<String ,Double> percentageByFile) implements Combineable<KeyWordsPercentage> {
    @Override
    public KeyWordsPercentage combine(KeyWordsPercentage entity) {
        Map<String,Double> combinedMap = new HashMap<>();
        combinedMap.putAll(this.percentageByFile);
        combinedMap.putAll(entity.percentageByFile());
        return new KeyWordsPercentage(combinedMap);
    }
}
