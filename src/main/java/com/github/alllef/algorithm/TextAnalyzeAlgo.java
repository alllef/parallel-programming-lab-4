package com.github.alllef.algorithm;

import java.util.function.Consumer;
import java.util.function.Supplier;

public interface TextAnalyzeAlgo {
    Supplier<?> analyze(String text);
}
