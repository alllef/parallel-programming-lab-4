package com.github.alllef.matrix_multiply;

import com.github.alllef.task.PoolExecution;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.github.alllef.matrix_multiply.TestUtils.parseToMatr;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class MatrixMultiplyTests {

    @ParameterizedTest
    @MethodSource("matrProvider")
    void multiplyTest(int[][] firstMatr, int[][] secondMatr, int[][] expectedResultMatr) {
        PoolExecution poolExecution = new PoolExecution();
        int[][] actualResultMatr = poolExecution.executeMatrixMultiply(firstMatr, secondMatr);

        for (int i = 0; i < actualResultMatr.length; i++)
            assertArrayEquals(expectedResultMatr[i], actualResultMatr[i]);
    }

    static Stream<Arguments> matrProvider() {
        return Stream.of(
                arguments(
                        parseToMatr(new int[]{5, 6, 2, 1, 3, 4, 6, 7, 8}, 3, 3),
                        parseToMatr(new int[]{2, 5, 3, 5, 7, 8, 1, 23, 4}, 3, 3),
                        parseToMatr(new int[]{42, 113, 71, 21, 118, 43, 55, 263, 106}, 3, 3)
                ),
                arguments(
                        parseToMatr(new int[]{2, 4, 6, 7, 3, 4}, 3, 2),
                        parseToMatr(new int[]{2, 5, 7, 9, 10, 11, 13, 5}, 2, 4),
                        parseToMatr(new int[]{44, 54, 66, 38, 82, 107, 133, 89, 46, 59, 73, 47}, 3, 4)
                )
        );
    }
}
