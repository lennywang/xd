package ch04_lock.mylock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public class UnsafeThread {
    private static int num =0;
    private static CountDownLatch countDownLatch =new CountDownLatch(10);
    private static Lock lock =new MyLock();

    public static void inCreate(){
        lock.lock();
        num++;
        lock.unlock();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                for (int j = 0; j < 100; j++) {
                    inCreate();

                    try {
                        TimeUnit.MILLISECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    countDownLatch.countDown();
                }
            }).start();
        }

        while (true){
            if (countDownLatch.getCount()==0){
                System.out.println(num);
                break;
            }
        }

    }
}
