import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] array = fillArray(10, 1, 20);
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
}