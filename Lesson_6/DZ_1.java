package Lesson_6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DZ_1 {
    public static void main(String[] args) {
    }
}

class ArrSearch{
    int[] arrIn;
    private int[] arrOut;

    public int[] arr(int[] arrIn){

        int index = 0;
        for (int i = 0; i < arrIn.length; i++) {
            if (arrIn[i] == 4){
                index = i;
            }
        }
        if (index == 0) throw new RuntimeException("Цифра 4 отсутствует");
        int[] arrOut = new int[arrIn.length - index - 1];
        int r = 0;
        for (int j = index + 1; j < arrIn.length; j++) {
            arrOut[r] = arrIn[j];
            r++;
        }
        return arrOut;
    }
}

class DZ_1_Test{

    @Test
    public void test1(){
        int[] arrIn = new int[]{1,2,4,4,2,3,4,1,7};
        int[] arrIn1 = new int[]{1,7};
        ArrSearch arrSearch = new ArrSearch();
        Assertions.assertArrayEquals(arrIn1, arrSearch.arr(arrIn));
    }

    @Test
    public void test2(){
        int[] arrIn = new int[]{1,2,3,7};
        int[] arrIn1 = new int[]{};
        ArrSearch arrSearch = new ArrSearch();
        Assertions.assertArrayEquals(arrIn1, arrSearch.arr(arrIn));
    }

    @Test
    public void test3(){
        int[] arrIn = new int[]{1,2,4,5,2,3,8,1,7};
        int[] arrIn1 = new int[]{5,2,3,8,1,7};
        ArrSearch arrSearch = new ArrSearch();
        Assertions.assertArrayEquals(arrIn1, arrSearch.arr(arrIn));
    }
}
