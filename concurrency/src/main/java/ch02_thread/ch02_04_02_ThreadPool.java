package ch02_thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ch02_04_02_ThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(()->{
            System.out.println(Thread.currentThread().getName());
        });
    }
}

