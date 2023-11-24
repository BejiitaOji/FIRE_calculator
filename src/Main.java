import java.util.Scanner;

public class Main {
    private static int startYear = 2002;
    private static int finalYear = 2022;
    public static void main(String[] args) throws IllegalArgumentException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите год начала жизни на проценты с 2002 по 2021 включительно");
        String input = scanner.nextLine();
        int inputYear = Integer.parseInt(input);
        if(inputYear < startYear || inputYear >= finalYear){
            throw new IllegalArgumentException();
        }
        double abbreviatedResult = Calculate.getAbbreviatedResult(inputYear);
        System.out.println(abbreviatedResult);
    }
}