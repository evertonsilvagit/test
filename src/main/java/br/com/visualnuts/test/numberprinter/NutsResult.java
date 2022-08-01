package br.com.visualnuts.test.numberprinter;

public class NutsResult implements ResultPrinter {

    private ResultPrinter next;

    public NutsResult(ResultPrinter next) {
        this.next = next;
    }

    public String getResult(int number){
        if (number % 5 == 0) {
            return "Nuts";
        }
        return next.getResult(number);
    }

}
