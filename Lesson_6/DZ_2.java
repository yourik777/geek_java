package Lesson_6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class DZ_2 {
    public static void main(String[] args) {
    }
}

class ArrSearch2{
    public boolean test_1_4 (int[] arr){
        boolean flag = true;
        int count_1 = 0;
        int count_4 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1){
                count_1++;
            }else{
                if(arr[i] == 4){
                    count_4++;
                }else {
                    flag = false;
                }
            }

        }
        return flag;
    }
}

class DZ_2_Test{

    @Test
    public void test1(){
        int[] arrIn = new int[]{1,2,4,4,2,3,4,1,7};
        ArrSearch2 arrSearch2 = new ArrSearch2();
        Assertions.assertEquals(false, arrSearch2.test_1_4(arrIn));
    }

    @Test
    public void test2(){
        int[] arrIn = new int[]{1,4,4,4,1,1,4,1,4};
        ArrSearch2 arrSearch2 = new ArrSearch2();
        Assertions.assertEquals(true, arrSearch2.test_1_4(arrIn));
    }

    @Test
    public void test3(){
        int[] arrIn = new int[]{1,4,4,4,1,1,4,1,4};
        ArrSearch2 arrSearch2 = new ArrSearch2();
        Assertions.assertEquals(false, arrSearch2.test_1_4(arrIn));
    }
}
