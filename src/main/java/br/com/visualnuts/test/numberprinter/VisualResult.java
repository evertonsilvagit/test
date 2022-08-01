package br.com.visualnuts.test.numberprinter;

public class VisualResult implements ResultPrinter {

    private ResultPrinter next;

    public VisualResult(ResultPrinter next) {
        this.next = next;
    }

    public String getResult(int number){
        if (number % 3 == 0) {
            return "Visual";
        }
        return next.getResult(number);
    }

}
