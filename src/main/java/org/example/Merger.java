package org.example;

import lombok.SneakyThrows;
import lombok.ToString;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@ToString
public class Merger {
    private List<String> BinaryFiles = new ArrayList<String>();
    private String OutputFileName;
    public Merger(List<String> InputBinaryFiles,String OutputFileName) {
        this.BinaryFiles.addAll(InputBinaryFiles);
        this.OutputFileName = OutputFileName;
    }

    @SneakyThrows
    public void merge(){
        try (OutputStream outputStream = new BufferedOutputStream(
                new FileOutputStream(OutputFileName))) {

            byte[] buffer = new byte[8192];

            for (String inputFile : BinaryFiles) {
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
}
