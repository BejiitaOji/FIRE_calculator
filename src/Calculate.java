public class Calculate {
    private static int startYear = 2002;
    private static int finalYear = 2022;
    public static double getAbbreviatedResult(int inputYear) {
        double result = 0.0;

        for (double percentageOfSpending = 0.5; percentageOfSpending <= 100; percentageOfSpending += 0.5) {
            double capital = calculateCapital(percentageOfSpending, inputYear);
            if (capital < 0) {
                break;
            } else {
                result = percentageOfSpending;
            }
        }

        return result;
    }
    private static double calculateCapital(double percentageOfSpending, int inputYear) {
        double budget = 1.0;
        double capital = 100 / percentageOfSpending * budget;

        for (int year = inputYear; year < finalYear; year++) {
            capital -= budget;
            double profit = calculateProfit(year);
            capital += capital * profit / 100;
            budget += budget * Constants.INFLATION_RATE[year - startYear] / 100;
        }

        return capital;
    }

    private static double calculateProfit(int year) {
        double startIndex = Constants.MOEX_RATE[year - 2002];
        double finalIndex = Constants.MOEX_RATE[year + 1 - 2002];
        double profit = (finalIndex - startIndex) / startIndex * 100;
        return profit;
    }
}