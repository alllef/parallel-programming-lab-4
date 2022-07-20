package com.github.alllef.algorithm.performance;

import com.github.alllef.algorithm.result.AvgWordLengthStats;
import com.github.alllef.task.FolderSearchTask;
import com.github.alllef.task.PoolExecution;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.junit.jupiter.params.shadow.com.univocity.parsers.csv.CsvWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AvgWordLengthBenchmark {

    public void writeResults(String fileName) {
        PoolExecution poolExecution = new PoolExecution();
        long startTime = System.currentTimeMillis();
        AvgWordLengthStats stats = poolExecution.executeAvgWordLength(fileName);
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        ResultsBean bean = new ResultsBean(stats.wordsNum(), resultTime);

        try (CSVWriter writer = new CSVWriter(new FileWriter("src/main/resources/results.csv", true))) {
            StatefulBeanToCsv<ResultsBean> converter = new StatefulBeanToCsvBuilder<ResultsBean>(writer)
                    .build();
            converter.write(bean);
        } catch (IOException | CsvRequiredFieldEmptyException | CsvDataTypeMismatchException e) {
            e.printStackTrace();
        }
    }

}
