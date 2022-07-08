package com.github.alllef.task;

import com.github.alllef.algorithm.implementation.AvgWordLengthTextAnalyzeAlgo;
import com.github.alllef.algorithm.implementation.TextAnalyzeAlgo;
import com.github.alllef.algorithm.result.AvgWordLengthStats;

import java.io.File;

public class AvgWordLengthDocumentSearchTask extends DocumentSearchTask<AvgWordLengthStats>{
    public AvgWordLengthDocumentSearchTask(File document) {
        super(document);
    }

    @Override
    public TextAnalyzeAlgo<AvgWordLengthStats> getTextAnalyzeAlgo() {
        return new AvgWordLengthTextAnalyzeAlgo();
    }
}
