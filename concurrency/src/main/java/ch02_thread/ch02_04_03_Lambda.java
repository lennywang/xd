package ch02_thread;

public class ch02_04_03_Lambda {
    public static void main(String[] args) {
        new Thread(()->{
            System.out.println(Thread.currentThread().getName());
        }).start();
    }
}
