import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private final static Scanner scan = new Scanner(System.in);
    private final static String inputFile = "src/input.txt";

    public static void main(String[] args) throws IOException {


        System.out.println(getDataFromFile(inputFile, "length"));

        /*int[] array = fillArray(getLengthTerminal(), getMinValueTerminal(), getMaxValueTerminal());
        System.out.println(Arrays.toString(array));*/
    }

    private static int getDataFromFile(String inputFileName, String value) throws IOException {
        String tempResult = "0";
        String line;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFileName));
        while ((line = bufferedReader.readLine()) != null) {
            if (line.contains(value)) {
                tempResult = line.chars()
                        .filter(c -> !Character.isLetter(c))
                        .mapToObj(c -> String.valueOf((char) c))
                        .collect(Collectors.joining())
                        .trim();
            }
        }

        bufferedReader.close();
        return Integer.parseInt(tempResult);
    }

    private static int[] fillArray(int length, int min, int max) {
        int[] array = new int[length];
        Random rnd = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rnd.nextInt((max - min) + 1) + min;
        }
        return array;
    }

    private static int getLengthTerminal() {
        System.out.print("Enter length of array: ");
        return scan.nextInt();
    }

    private static int getMinValueTerminal() {
        System.out.print("Enter min value of array: ");
        return scan.nextInt();
    }

    private static int getMaxValueTerminal() {
        System.out.print("Enter max value of array: ");
        return scan.nextInt();
    }
}