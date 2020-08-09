package Lesson_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calc {
    public static void main(String[] args) throws IOException {
        System.out.println("Введите операцию");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Operationable operation = null;
        String s = "";
        try {
             s = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Введите первое число");
        int a = Integer.parseInt(bufferedReader.readLine());
        System.out.println("Введите второе число");
        int b = Integer.parseInt(bufferedReader.readLine());
        switch (s){
            case "+":
                operation = (x,y) -> x+y;
                break;
            case "-":
                operation = (x,y) -> x-y;
                break;
            case "/":
                operation = (x,y) -> x/y;
                break;
            case "*":
                operation = (x,y) -> x*y;
                break;
            default: System.out.println("Вводите точнее");

        }
        int result = operation.calculate(a,b);
        System.out.println(a + " " + s + " " + b +" = " + result);

        bufferedReader.close();
    }

    interface Operationable{
        int calculate(int x, int y);
    }
}
