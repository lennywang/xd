package ch05_communication;

import utils.TimeUtil;

import java.text.MessageFormat;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Ch05_01_Wait {
    public static void main(String[] args) {
        //ThreadPoolExecutor线程池中线程不能超过核心线程数量的问题
        //https://www.cnblogs.com/snailmanlilin/p/8005787.html
        //核心线程满了，接下来进队列，队列也满了，创建新线程，直到达到最大线程数，之后再超出，会进入拒绝rejectedExecution

        //线程池ThreadPoolExecutor核心参数
        //https://blog.csdn.net/huofuman960209/article/details/87618647
        int arg1=2;
        int arg2=40;
        int arg3=100;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(arg1, arg2, arg3, TimeUnit.MINUTES, new LinkedBlockingQueue<Runnable>());
        System.out.println(TimeUtil.getCurrentTime());
        for (int i = 0; i < 10; i++) {
            threadPoolExecutor.execute(new MyThread());
        }
        System.out.println(TimeUtil.getCurrentTime());
    }


}

class MyThread implements Runnable{

    public void run() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String tmp="线程：{0}，时间：{1}";
        String msg= MessageFormat.format(tmp,Thread.currentThread().getName(),TimeUtil.getCurrentTime());
        System.out.println(msg);
    }
}