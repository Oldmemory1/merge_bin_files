package org.example;

import lombok.extern.java.Log;

import java.util.Arrays;
import java.util.List;

@Log//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {

    public static void main(String[] args) {

        List<String> inputFiles = Arrays.asList(
                "part1.bin",
                "part2.bin"
        );

        String outputFile = "combined.bin";

        Merger merger = new Merger(inputFiles, outputFile);
        log.info(merger.toString());
        merger.merge();

    }
}