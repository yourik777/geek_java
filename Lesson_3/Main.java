package Lesson_3;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //        System.out.println("Задание 1_______________________________________________");
//        try (InputStreamReader in = new InputStreamReader(new FileInputStream("C:\\Users\\1\\Documents\\geek\\java3\\src\\main\\java\\Lesson_3\\test.txt"), "UTF-8")){
//
//            byte [] bytes = new byte[512];
//            int x;
//            while ((x=in.read()) != -1){
//                System.out.print((char) x);
//            }
//            in.close();
//
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        System.out.println("Задание 2_______________________________________________");
//
//        ArrayList<InputStream> temp =new ArrayList<>();
//
//        try {
//            temp.add(new FileInputStream("C:\\Users\\1\\Documents\\geek\\java3\\src\\main\\java\\Lesson_3\\1.txt"));
//            temp.add(new FileInputStream("C:\\Users\\1\\Documents\\geek\\java3\\src\\main\\java\\Lesson_3\\2.txt"));
//            temp.add(new FileInputStream("C:\\Users\\1\\Documents\\geek\\java3\\src\\main\\java\\Lesson_3\\3.txt"));
//            temp.add(new FileInputStream("C:\\Users\\1\\Documents\\geek\\java3\\src\\main\\java\\Lesson_3\\4.txt"));
//            temp.add(new FileInputStream("C:\\Users\\1\\Documents\\geek\\java3\\src\\main\\java\\Lesson_3\\5.txt"));
//
//            SequenceInputStream in = new SequenceInputStream(Collections.enumeration(temp));
//            System.out.println(temp.size());
//            int x;
//
//            while ((x = in.read()) != -1){
//                System.out.println((char) x);
//            }
//            in.close();
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//
        System.out.println("Задание 3_______________________________________________");


        long t = System.currentTimeMillis();

        System.out.println("Введите номер страницы:");
        BufferedReader bufferedInputStream = new BufferedReader(new InputStreamReader(System.in)) ;
        int number = 0;
        int v = 0;
        v = Integer.parseInt((bufferedInputStream.readLine()));
        while (v != 1111){

//            number = Integer.parseInt(bufferedInputStream.readLine());

            if (number == 0){
                number = 1;
            }else{
                number = number*1800;
            }

            try (
                    RandomAccessFile raf = new RandomAccessFile("C:\\Users\\1\\Documents\\geek\\java3\\src\\main\\java\\Lesson_3\\33.txt", "r")){

                String str = "";
                raf.seek(number);
                int b = raf.read();
                int count = 0;

                while (b != -1){
                    str += (char) b;
                    b = raf.read();
//                System.out.print((char) b);
                    if (count == 1800) break;
                    count++;
                }
                raf.close();
                System.out.println(str); //new String(str.getBytes("UTF-8"), "UTF-8"));

            } catch (
                    FileNotFoundException e) {
                e.printStackTrace();
            } catch (
                    IOException e) {
                e.printStackTrace();
            }

            System.out.println();
            System.out.println(System.currentTimeMillis() - t);
            v = Integer.parseInt((bufferedInputStream.readLine()));
        }

        System.out.println("Задание 4_______________________________________________");
    }
}
