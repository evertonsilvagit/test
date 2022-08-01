package br.com.visualnuts.test.numberprinter;

public class VisualNutsResult implements ResultPrinter {

    private ResultPrinter next;

    public VisualNutsResult(ResultPrinter next) {
        this.next = next;
    }

    public String getResult(int number){
        if (number % 3 == 0 && number % 5 == 0) {
            return "Visual Nuts";
        }
        return next.getResult(number);
    }

}
