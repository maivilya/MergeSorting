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

    public static void main(String[] args) throws IOException{

        System.out.print(choosing());
        int choose = scan.nextInt();
        if (choose == 1){
            int[] arr = fillArray(getLengthTerminal(), getMinValueTerminal(), getMaxValueTerminal());
            System.out.println("INITIAL ARRAY: " + toString(arr));
            mergeSort(arr);
            System.out.println("RESULT ARRAY: "+ toString(arr));
        } else if (choose == 2){
            int[] arr = fillArray(getDataFromFile(inputFile, "length"),
                    getDataFromFile(inputFile, "min"),
                    getDataFromFile(inputFile, "max"));
            System.out.println("INITIAL ARRAY: " + toString(arr));
            mergeSort(arr);
            System.out.println("RESULT ARRAY: "+ toString(arr));
        } else {
            System.out.println("entered uncorrected operation");
        }

    }

    private static String choosing(){
        return  "\n ---OPERATION---\n" +
                "Choose 1 to work with terminal:\n" +
                "Choose 2 to work with file:\n" +
                "Your choosing is: ";
    }
    private static String toString(int[] array) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int length = array.length;
        for (int i = 0; i < length; i++) {
            if (i < (length - 1)) {
                sb.append(String.format("%d, ", array[i]));
            } else {
                sb.append(String.format("%d]", array[i]));
            }
        }
        return sb.toString();
    }

    private static void merge(int[] src1, int src1Start, int[] src2, int src2Start,
                              int[] dest, int destStart, int size) {

        int index1 = src1Start;
        int index2 = src2Start;

        int src1End = Math.min(src1Start + size, src1.length);
        int src2End = Math.min(src2Start + size, src2.length);

        if (src1Start + size > src1.length) {
            for (int i = src1Start; i < src1End; i++) {
                dest[i] = src1[i];
            }
            return;
        }

        int iterationCount = src1End - src1Start + src2End - src2Start;

        for (int i = destStart; i < destStart + iterationCount; i++) {
            if (index1 < src1End && (index2 >= src2End || src1[index1] < src2[index2])) {
                dest[i] = src1[index1];
                index1++;
            } else {
                dest[i] = src2[index2];
                index2++;
            }
        }
    }

    private static int[] mergeSort(int[] array) {
        int[] temp;
        int[] currentSrc = array;
        int[] currentDest = new int[array.length];

        int length = array.length;
        int size = 1;
        while (size < length) {
            for (int i = 0; i < length; i += size * 2) {
                merge(currentSrc, i, currentSrc, i + size, currentDest, i, size);
            }

            temp = currentSrc;
            currentSrc = currentDest;
            currentDest = temp;

            size *= 2;
        }
        return currentSrc;
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