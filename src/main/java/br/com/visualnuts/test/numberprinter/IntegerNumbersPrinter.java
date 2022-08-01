package br.com.visualnuts.test.numberprinter;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntegerNumbersPrinter {
    public void printIntegerNumbersUntil(int numbersToPrint) {
        ResultPrinter resultPrinter = new VisualNutsResult(
                new VisualResult(
                        new NutsResult(
                                new IntegerResult()
                        )
                )
        );

        IntStream.rangeClosed(1, numbersToPrint)
                .boxed()
                .collect(Collectors.toList())
                .forEach(integer -> System.out.println(resultPrinter.getResult(integer)));

    }

}
