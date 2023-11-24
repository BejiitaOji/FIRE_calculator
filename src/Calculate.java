public class Calculate {
    public static double getAbbreviatedResult(int inputYear) {
        double result = 0.0;

        for (double percentageOfSpending = Constants.STEP; percentageOfSpending <= 100; percentageOfSpending += Constants.STEP) {
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

        for (int year = inputYear; year < Constants.FINAL_YEAR; year++) {
            capital -= budget;
            double profit = calculateProfit(year);
            capital += capital * profit / 100;
            budget += budget * Constants.INFLATION_RATE[year - Constants.START_YEAR] / 100;
        }

        return capital;
    }

    private static double calculateProfit(int year) {
        double startIndex = Constants.MOEX_RATE[year - Constants.START_YEAR];
        double finalIndex = Constants.MOEX_RATE[year + 1 - Constants.START_YEAR];
        double profit = (finalIndex - startIndex) / startIndex * 100;
        return profit;
    }
}