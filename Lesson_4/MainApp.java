package Lesson_4;

public class MainApp {
    public static class Task1 {
        static char ch = 'A';
        static Object lock = new Object();

        static class WaitNotifyClass implements Runnable {
            private char currCh;
            private char nextCh;

            public WaitNotifyClass(char currCh, char nextCh) {
                this.currCh = currCh;
                this.nextCh = nextCh;
            }

            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    synchronized (lock) {
                        try {
                            while (ch != currCh)
                                lock.wait();
                            System.out.print(currCh);
                            ch = nextCh;
                            lock.notifyAll();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        public static void main(String[] args) {
            new Thread(new WaitNotifyClass('A', 'B')).start();
            new Thread(new WaitNotifyClass('B', 'C')).start();
            new Thread(new WaitNotifyClass('C', 'A')).start();
        }
    }


}
