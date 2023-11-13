import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IllegalArgumentException {
        Scanner scanner = new Scanner(System.in);
        String year = scanner.nextLine();
        int years = Integer.parseInt(year);
        if(years < 2002 || years >= 2022){
            throw new IllegalArgumentException();
        }
        int counter = 1;
        double[] arrTest = new double[2022 - years];
        for (int i = years; i < 2022; i++) {
            double startPrice = Constants.MOEX_RATE[i - 2002];
            double finalPrice = Constants.MOEX_RATE[i - 2002 + 1];
            double profit = (finalPrice - startPrice) / startPrice * 100;
            double infl = Constants.INFLATION_RATE[i - 2002];
            double percentageForLife = profit - infl;

            arrTest[counter - 1] = percentageForLife;
            counter++;
        }
        double sum = 0;
        for (double v : arrTest) {
            sum += v;
        }
        double number = sum / counter;
        double result = Math.round(number * 2) / 2.0;
        System.out.println(result);
    }
}