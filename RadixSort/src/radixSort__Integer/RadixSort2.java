/*
Algorítmo RadixSort, ideal para classisicar inteiros
 */
package radixSort__Integer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author 50enta
 */
public class RadixSort2 {

    /**
     * Método que recebe o array que se deseja ordenar e faz a ordenação usando
     * o método radix sort
     *
     * @param arrayPorOrdenar
     */
    public static void sort(int[] arrayPorOrdenar) {
        final int RADIX = 10;
        ArrayList<Integer>[] matrizAuxiliar = new ArrayList[RADIX];

        for (int pos = 0; pos < matrizAuxiliar.length; pos++) {
            matrizAuxiliar[pos] = new ArrayList<>();
        }

        boolean maxDigitsLengthReached = false;
        int temp = -1, placeValue = 1;

        while (!maxDigitsLengthReached) {
            maxDigitsLengthReached = true;
            for (Integer element : arrayPorOrdenar) {
                temp = element / placeValue;
                matrizAuxiliar[temp % RADIX].add(element);

                if (maxDigitsLengthReached && temp > 0) {
                    maxDigitsLengthReached = false;
                }
            }

            int a = 0;
            for (int b = 0; b < RADIX; b++) {
                for (Integer i : matrizAuxiliar[b]) {
                    arrayPorOrdenar[a++] = i;
                }
                matrizAuxiliar[b].clear();
            }
            placeValue = placeValue * RADIX;
        }
    }

    public static void main(String[] args) {
        int a[] = {100, 54, 35, 102, 45, 10, 287, 005};
        sort(a);
        Arrays.stream(a).forEach(System.out::println);
    }

}
