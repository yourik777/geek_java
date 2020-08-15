package Lesson_7;

import java.util.ArrayList;

public class DZ_3 {
    public static void main(String[] args) {
        arr(4);

    }

    public static int[][] arr(int size){
        int[][] arrOut = new int[size][size];
        int inc = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                inc++;
                arrOut[i][j] = inc;

            }

        }

        return arrOut;
    }

    public void print(int[][] arr){

    }
}
