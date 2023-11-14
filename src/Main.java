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
        double abbreviatedResult = Calculate.getAbbreviatedResult(startYear);
        System.out.println(abbreviatedResult);
    }
}