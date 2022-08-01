package br.com.visualnuts.test;

import br.com.visualnuts.test.numberprinter.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertNotEquals;

public class IntegerNumbersPrinterTest {

    private ResultPrinter resultPrinter;

    @BeforeEach
    public void setUp(){
        resultPrinter = new VisualNutsResult(
                new VisualResult(
                        new NutsResult(
                                new IntegerResult()
                        )
                )
        );
    }

    @Test
    public void testIntegerNumbers(){

        new IntegerNumbersPrinter()
                .printIntegerNumbersUntil(500);

    }

    @Test
    public void shouldPrintVisualOnlyWhenIntegerIsDividedByThree(){

        String resultNine = resultPrinter.getResult(9);
        assertEquals(null,"Visual", resultNine);

        String resultSeven = resultPrinter.getResult(7);
        assertNotEquals(null,"Visual", resultSeven);

    }

    @Test
    public void shouldPrintNutsOnlyWhenIntegerIsDividedByFive(){

        String resultTen = resultPrinter.getResult(10);
        assertEquals(null,"Nuts", resultTen);

        String resultSeven = resultPrinter.getResult(7);
        assertNotEquals(null,"Nuts", resultSeven);

    }

    @Test
    public void shouldPrintVisualNutsOnlyWhenIntegerIsDividedByThreeAndFive(){

        String result = resultPrinter.getResult(15);
        assertEquals(null,"Visual Nuts", result);

        String resultFive = resultPrinter.getResult(5);
        assertNotEquals(null,"Visual Nuts", resultFive);

    }

    @Test
    public void shouldPrintTheNumberOnlyWhenNumberIsNotDividedByThreeNietherByFive(){

        String result = resultPrinter.getResult(23);
        assertEquals(null,"23", result);

        String resultFive = resultPrinter.getResult(15);
        assertNotEquals(null,"23", resultFive);

    }


}
