package ch04_lock.mylock;

import java.util.concurrent.locks.Lock;

public class Reentry {
    public Lock lock = new MyLock();

    public void methodA(){
        lock.lock();
        System.out.println("进入方法A");
        methodB();
        lock.unlock();
    }

    public void methodB(){
        lock.lock();
        System.out.println("进入方法B");
        lock.unlock();
    }

    public static void main(String[] args) {
        Reentry reentry = new Reentry();
        reentry.methodA();
    }
}
