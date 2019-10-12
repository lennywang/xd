package ch02_thread;

public class ch02_04_01_MyThread {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        },"CreateThread-Runnable+Lambda");
        thread.start();
    }
}
