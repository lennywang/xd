package ch04_lock;

import java.util.concurrent.locks.ReentrantLock;

public class ch04_01_ReentrantLock {
    private int i=0;
    private ReentrantLock reentrantLock= new ReentrantLock();

    public void inCreate(){
        reentrantLock.lock();
        try{
            i++;
            System.out.println(i);
        }finally {
            reentrantLock.unlock();
        }
    }

    public static void main(String[] args) {
        ch04_01_ReentrantLock ch04_01_reentrantLock = new ch04_01_ReentrantLock();
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                ch04_01_reentrantLock.inCreate();
            }).start();
        }
    }
}
