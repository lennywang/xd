package broadView;

import java.text.SimpleDateFormat;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalDemo_Gc {
    static volatile ThreadLocal<SimpleDateFormat> threadLocal =new ThreadLocal<SimpleDateFormat>();

    @Override
    protected void finalize() throws Throwable {
        System.out.println(this.toString()+" is gc");
    }

    static volatile CountDownLatch countDownLatch=new CountDownLatch(10000);
    public static class ParseDate implements Runnable{
        int i=0;
        public ParseDate(int i)
        {
            this.i=i;
        }

        public void run() {
            try{
                if(threadLocal.get()==null)
                {
                    threadLocal.set(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"){
                        @Override
                        protected void finalize() throws Throwable {
                            System.out.println(this.toString()+" is gc");
                        }
                    });
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally{
                countDownLatch.countDown();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10000; i++) {
            executorService.execute(new ParseDate(i));
        }
        countDownLatch.await();
        threadLocal=null;
        System.gc();
        System.out.println("first GC complete!! ");
        threadLocal=new ThreadLocal<SimpleDateFormat>();
        countDownLatch=new CountDownLatch(10000);
        for (int i = 0; i < 10000; i++) {
            executorService.execute(new ParseDate(i));
        }
        countDownLatch.await();
        Thread.sleep(1000);
        System.gc();
        System.out.println("second GC complete!! ");
    }
}
