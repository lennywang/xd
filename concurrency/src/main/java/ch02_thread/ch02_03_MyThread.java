package ch02_thread;

public class ch02_03_MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        ch02_03_MyThread myThread = new ch02_03_MyThread();
        myThread.setName("CreateThread-extends Thread");
        myThread.start();
    }
}
