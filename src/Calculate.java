import java.awt.geom.Arc2D;

public class Calculate {
    public static double getAbbreviatedResult(int startYear) {
        double result = 0.0;

        for (double percentageOfSpending = 0.04; percentageOfSpending <= 100; percentageOfSpending += 0.04) {
            double budget = 1.0;
            double capital = 100 / percentageOfSpending;


            for (int year = startYear; year < 2022; year++) {
                capital -= budget;
                double startIndex = Constants.MOEX_RATE[year - 2002];
                double finalIndex = Constants.MOEX_RATE[year + 1 - 2002];
                double profit = (finalIndex - startIndex) / startIndex * 100;
                capital += capital * profit / 100;
                budget += budget * Constants.INFLATION_RATE[year - 2002] / 100;
            }

            if (capital < 0) {
                break;
            } else {
                result = percentageOfSpending;
            }
        }
        double abbreviatedResult = Math.round(result * 2) / 2.0;
        return abbreviatedResult;
    }
}