package com.github.alllef.algorithm.performance.word_length;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.stream.IntStream;

public class WordsGenerator {

    private String generateWord(int maxSize) {
        Random random = new Random();
        String letters = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder stringBuilder = new StringBuilder();
        int wordSize = random.nextInt(maxSize) + 1;

        for (int i = 0; i < wordSize; i++)
            stringBuilder.append(letters.charAt(random.nextInt(letters.length())));

        return stringBuilder.toString();
    }

    private File generateText(int maxWordsNum, int maxWordSize) {
        File file = new File("src/main/resources/text", generateWord(maxWordSize));
        int wordsNum = new Random().nextInt(maxWordsNum) + 1;
        try (FileWriter writer = new FileWriter(file, true)) {
            for (int i = 0; i < wordsNum; i++)
                writer.write(generateWord(maxWordSize) + " ");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return file;
    }

    public void generateTexts(int textsNum, int maxWordsNum, int maxWordSize) {
        IntStream.range(0,textsNum).forEach(num -> generateText(maxWordsNum, maxWordSize));
    }
}