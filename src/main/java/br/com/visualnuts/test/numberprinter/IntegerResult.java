package br.com.visualnuts.test.numberprinter;

public class IntegerResult implements ResultPrinter {

    public String getResult(int number){
        return String.valueOf(number);
    }

}
