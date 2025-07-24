package org.example;

import java.io.*;
import java.util.Arrays;
import java.util.List;

//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void mergeBinaryFiles(List<String> inputFiles, String outputFile)
            throws IOException {
        try (OutputStream outputStream = new BufferedOutputStream(
                new FileOutputStream(outputFile))) {

            byte[] buffer = new byte[8192];

            for (String inputFile : inputFiles) {
                try (InputStream inputStream = new BufferedInputStream(
                        new FileInputStream(inputFile))) {
                    int bytesRead;
                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }
                }
            }
        }
    }
    public static void main(String[] args) {

        List<String> inputFiles = Arrays.asList(
                "part1.bin",
                "part2.bin"
        );

        String outputFile = "combined.bin";

        try {
            mergeBinaryFiles(inputFiles, outputFile);
            System.out.println("merge successfully！");
        } catch (IOException e) {
            System.err.println("merge fail: " + e.getMessage());
        }
    }
}