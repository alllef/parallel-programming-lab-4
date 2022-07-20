package com.github.alllef.algorithm.performance.matrix_multiply;

import com.github.alllef.task.PoolExecution;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class MatrixMultiplyBenchMark {

    private static Map<Integer, Long> timeInMillisPerSize = Map.of(512, 82L, 1024, 972L, 2048, 18499L);

    public void calculate() {
        try (CSVWriter csvWriter = new CSVWriter(new FileWriter("src/main/resources/results.csv", true))) {
            StatefulBeanToCsv<MultiplyResultsBean> converter = new StatefulBeanToCsvBuilder<MultiplyResultsBean>(csvWriter)
                    .build();

            for (Integer matrixSize : timeInMillisPerSize.keySet()) {
                PoolExecution execution = new PoolExecution();
                long time = calcMilliSecondTime(() -> execution.executeMatrixMultiply(MatrixGenerator.generateMatrix(matrixSize), MatrixGenerator.generateMatrix(matrixSize)));
                double speedup = calcSpeedup(timeInMillisPerSize.get(matrixSize), time);
                MultiplyResultsBean serialBean = new MultiplyResultsBean(matrixSize, time, speedup);
                converter.write(serialBean);

            }
        } catch (IOException | CsvRequiredFieldEmptyException | CsvDataTypeMismatchException e) {
            throw new RuntimeException(e);
        }
    }

    private double calcSpeedup(long thread, long forkJoinPool) {
        return (double) thread / forkJoinPool;
    }

    private long calcMilliSecondTime(Runnable runnable) {
        long time = System.currentTimeMillis();
        runnable.run();
        long afterTime = System.currentTimeMillis();
        return (afterTime - time);
    }
}
