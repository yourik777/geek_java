package Lesson_4;

public class MFU {
    Object scanLock = new Object();
    Object printLock = new Object();

    public void print(String task, int n){

        synchronized (printLock){
            for (int i = 0; i < n; i++) {
                System.out.println("Печать стр № " + i);

            }
        }
    }

    public void scan(String task, int n){
        synchronized (scanLock){
            synchronized (printLock){
                for (int i = 0; i < n; i++) {
                    System.out.println("Сканирование и печать стр № " + i);

                }
            }
        }
    }

    public static void main(String[] args) {
        MFU mfu = new MFU();
        new Thread(new Runnable() {
            @Override
            public void run() {
                mfu.print("Task_print", 10);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                mfu.scan("Task_scan", 20);
            }
        }).start();
    }

}
