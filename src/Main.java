import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private final static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        int[] array = fillArray(getLengthTerminal(), getMinValueTerminal(), getMaxValueTerminal());
        System.out.println(Arrays.toString(array));
    }

    private static int[] fillArray(int length, int min, int max){
        int[] array = new int[length];
        Random rnd = new Random();
        for (int i = 0; i <array.length; i++){
            array[i] = rnd.nextInt((max - min) +1) + min;
        }
        return array;
    }

    private static int getLengthTerminal(){
        System.out.print("Enter length of array: ");
        return scan.nextInt();
    }
    private static int getMinValueTerminal(){
        System.out.print("Enter min value of array: ");
        return scan.nextInt();
    }
    private static int getMaxValueTerminal(){
        System.out.print("Enter max value of array: ");
        return scan.nextInt();
    }
}