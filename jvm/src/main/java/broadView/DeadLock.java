package broadView;

import java.util.concurrent.TimeUnit;

public class DeadLock {
    public static final String resource1="resource1";
    public static final String resource2="resource2";

    public static void main(String[] args) {
        Thread thread1 = new Thread(new BusinessA());
        Thread thread2 = new Thread(new BusinessB());
        thread1.start();
        thread2.start();
    }

    static class BusinessA implements Runnable{

        public void run() {
            try{
                System.out.println("BusinessA启动");
                while (true){
                    synchronized (DeadLock.resource1){
                        System.out.println("BusinessA拿到了resource1的锁");
                        TimeUnit.SECONDS.sleep(3);
                        synchronized (DeadLock.resource2){
                            System.out.println("BusinessA拿到了resource2的锁");
                        }
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    static class BusinessB implements Runnable{

        public void run() {
            try {
                System.out.println("BusinessB启动");
                while(true){
                    synchronized (DeadLock.resource2){
                        System.out.println("BusinessB拿到了resource2的锁");
                        TimeUnit.SECONDS.sleep(3);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


}
