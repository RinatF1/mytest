
import java.io.IOException;
import java.util.Scanner;

public class Main {
    static int a,b;
    static int result;
    static String operation;
    static String output;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение");
        String input =scanner.nextLine();
        System.out.println(calc(input));

    }
    public static String calc(String input) throws IOException {

        char [] symbol = new char[10];
        for (int i =0; i<input.length(); i++) {
            symbol[i] = input.charAt(i);

            if (symbol[i] == '+') {
                operation = "\\+";
            }
            if (symbol[i] == '-') {
                operation = "-";
            }
            if (symbol[i] == '*') {
                operation = "\\*";
            }
            if (symbol[i] == '/') {
                operation = "/";
            }
        }

        String [] parts = input.split(operation);
        String operand1 = parts[0].trim().toUpperCase();
        String operand2 = parts[1].trim().toUpperCase();

        a= latinNumber(operand1);
        b= latinNumber(operand2);
        if (a < 0 && b < 0){
            result = 0;
        }

        else if (a < b) {
            throw new IOException("Операция неверна, т.к. в римской системе нет отрицательных чисел");
        }

        else {
            result = calculated(a, b, operation);
            output = convertLatin(result);
            System.out.println("Решение");

            return output;
        }

        a = Integer.parseInt(operand1);
        b = Integer.parseInt(operand2);
        result = calculated(a, b, operation);
        output = String.valueOf(result);

        return output;
    }

    private static String convertLatin(int arabic) {
        String [] latin = {"O", "I" , "II" , "III" , "IV", "V", "VI", "VII", "VII", "IX", "X", "XI", "XII",
        "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV",
        "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI",
        "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII",
        "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LIV", "LVII", "LVIII", "LVIX", "LX", "LXI", "LXII",
        "LXIII", "LXVI", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV",
        "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV",
        "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", " XCII", "XCIII", "XCIV", "XCV",
        "XCIV", "XCVIII", "XCVIII", "XCIX", "C"};
        return latin[arabic];
    }

    private static int latinNumber(String latin) {
        return switch (latin) {
            case "I" -> 1;
            case "II" -> 2;
            case "III" -> 3;
            case "IV" -> 4;
            case "V" -> 5;
            case "VI" -> 6;
            case "VII" -> 7;
            case "VIII" -> 8;
            case "IX" -> 9;
            case "X" -> 10;
            default -> -1;
        };
    }

    private static int calculated(int a, int b, String znak) throws IOException {

        int result;
        if (a < 1 || a > 10 || b < 1 || b > 10) {
            throw new IOException("Введено неверное число");
        }

        switch (znak){
                case "\\+" -> result = a + b;
                case "-" -> result = a-b;
                case "\\*" -> result = a * b;
                case "/" -> result = a / b;
                default -> throw new IOException("Неверная операция");
                  }
        return result;

    }

}
