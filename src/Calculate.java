import java.awt.geom.Arc2D;

public class Calculate {
    public static double getAbbreviatedResult(int startYear) {
        int counter = 1;
        double sum = 0.0;
        for (int year = startYear; year < 2022; year++) {
            double startIndex = Constants.MOEX_RATE[year - 2002];
            double indexing = Math.pow((6731.43 / startIndex), 1/counter);
            double profit = (indexing - 1) * 100;
            double inflation = Constants.INFLATION_RATE[year - 2002];
            double percentageOfProfit = profit - inflation;
            sum += percentageOfProfit;
            counter++;
        }
        double result = sum / counter;
        double abbreviatedResult = Math.round(result * 2) / 2.0;
        return abbreviatedResult;
    }
}