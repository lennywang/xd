package ch02_thread;

import java.io.IOException;
import java.io.Serializable;

public class ch02_03_02_MyRunnable implements Runnable, Serializable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new ch02_03_02_MyRunnable());
        thread.setName("CreateThread-implements Runnable");
        thread.start();
    }
}
