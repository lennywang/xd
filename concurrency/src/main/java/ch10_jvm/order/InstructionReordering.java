package ch10_jvm.order;

import java.text.MessageFormat;

public class InstructionReordering {
    static int x=0,y=0,a=0,b=0;
    public static void main(String[] args) throws InterruptedException {
        int i=0;
        boolean flag=true;

        while (flag){
            i++;
            Thread thread1 =   new Thread(()->{
                a=1;
                x=b;
            });

            Thread thread2 = new Thread(() -> {
                b = 1;
                y = a;
            });

            thread1.start();
            thread2.start();
            thread1.join();
            thread2.join();

            System.out.println(MessageFormat.format("第{0}次{1}x=====>{2}{1}y=====>{3}",i,"\t",x,y));

            if (x==0 && y==0){
                flag=false;
            }else {
                x=0;
                y=0;
                a=0;
                b=0;
            }
        }
    }
}


