package ch02_runtimedataarea;

import java.util.concurrent.atomic.AtomicInteger;

public class Ch02_03_JVMStack {
    public static void a() {
        System.out.println("enter method a");
    }

    public static void b() {
        a();
        System.out.println("enter method b");
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        b();
        System.out.println("enter method main");
        AtomicInteger atomicInteger = new AtomicInteger(1);
        atomicInteger.compareAndSet(1, 2);

        //栈：先进后出
        //enter method a
        //enter method b
        //enter method main
    }
}
