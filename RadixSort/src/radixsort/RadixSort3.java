/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package radixsort;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author 50enta
 */
public class RadixSort3 {

    public static void sort(int[] inputArray) {
        final int RADIX = 10;
        ArrayList<Integer>[] bucketArray = new ArrayList[RADIX];

        for (int pos = 0; pos < bucketArray.length; pos++) {
            bucketArray[pos] = new ArrayList<>();
        }

        boolean maxDigitsLengthReached = false;
        int temp = -1, placeValue = 1;

        while (!maxDigitsLengthReached) {
            maxDigitsLengthReached = true;
            for (Integer element : inputArray) {
                temp = element / placeValue;
                bucketArray[temp % RADIX].add(element);

                if (maxDigitsLengthReached && temp > 0) {
                    maxDigitsLengthReached = false;
                }
            }

            int a = 0;
            for (int b = 0; b < RADIX; b++) {
                for (Integer i : bucketArray[b]) {
                    inputArray[a++] = i;
                }
                bucketArray[b].clear();
            }
            placeValue = placeValue * RADIX;
        }//while

    }

    public static void main(String[] args) {
        int a[] = {100, 54, 35, 102, 45, 10, 287, 005};
        sort(a);
        Arrays.stream(a).forEach(System.out::println);
    }// main

}//classe
