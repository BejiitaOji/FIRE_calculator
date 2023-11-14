import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IllegalArgumentException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите год начала жизни на проценты с 2002 по 2021 включительно");
        String input = scanner.nextLine();
        int startYear = Integer.parseInt(input);
        if(startYear < 2002 || startYear >= 2022){
            throw new IllegalArgumentException();
        }
        int counter = 1;
        double[] profitList = new double[2022 - startYear];
        for (int year = startYear; year < 2022; year++) {
            double startIndex = Constants.MOEX_RATE[year - 2002];
            double finalIndex = Constants.MOEX_RATE[year - 2002 + 1];
            double profit = (finalIndex - startIndex) / startIndex * 100;
            double inflation = Constants.INFLATION_RATE[year - 2002];
            double percentageOfProfit = profit - inflation;

            profitList[counter - 1] = percentageOfProfit;
            counter++;
        }
        double sum = 0;
        for (double v : profitList) {
            sum += v;
        }
        double result = sum / counter;
        double abbreviatedResult = Math.round(result * 2) / 2.0;
        System.out.println(abbreviatedResult);
    }
}