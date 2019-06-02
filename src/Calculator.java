public class Calculator {

    MoneyEntry[] mainNumbers;


    public Calculator (MoneyEntry... args){
        mainNumbers = args;
    }

    public double calculate() throws Exception {
        if (mainNumbers.length <= 0) throw new Exception();

        double total = 0;

        for (MoneyEntry entry : mainNumbers){
            total += entry.getMoneyAfterInterest();
        }

        return total;

    }


    public static void main(String[] args) {



        Calculator calc = new Calculator(new MoneyEntry(100, 10));
        try {
            System.out.println(calc.calculate());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
