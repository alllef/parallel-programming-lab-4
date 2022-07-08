package com.github.alllef.algorithm.implementation;

import java.util.function.Consumer;
import java.util.function.Supplier;

public interface TextAnalyzeAlgo<T> {
    T analyze(String text);
}
