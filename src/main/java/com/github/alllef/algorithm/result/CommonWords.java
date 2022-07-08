package com.github.alllef.algorithm.result;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public record CommonWords(Set<String> words) implements Combineable<CommonWords> {

    @Override
    public CommonWords combine(CommonWords entity) {
        Set<String> intersectionSet = new HashSet<>();

        List.of(entity.words(), this.words)
                .forEach(set -> {
                    for (String word : set) {
                        if (entity.words().contains(word) && this.words.contains(word))
                            intersectionSet.add(word);
                    }
                });

        return new CommonWords(intersectionSet);
    }
}
