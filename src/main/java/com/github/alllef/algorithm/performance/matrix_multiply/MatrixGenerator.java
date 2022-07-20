package com.github.alllef.algorithm.performance.matrix_multiply;

import java.util.Random;

public class MatrixGenerator {

    public static int[][] generateMatrix(int matrixSize) {
        int[][] matrix = new int[matrixSize][matrixSize];
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                matrix[i][j] = new Random().nextInt(10);
            }
        }
        return matrix;
    }
}
