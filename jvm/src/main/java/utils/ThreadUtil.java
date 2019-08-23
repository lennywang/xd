package utils;

import java.util.concurrent.TimeUnit;

public  class ThreadUtil {

    /**
     * 休眠
     * @param  @second 休眠时间，单位：秒
     */
    public static void sleep(long second){
        try {
            TimeUnit.SECONDS.sleep(second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
