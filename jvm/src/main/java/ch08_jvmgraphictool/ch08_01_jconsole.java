package ch08_jvmgraphictool;

import utils.ThreadUtil;

public class ch08_01_jconsole {
    public byte[] bytes= new byte[1024*512];

    public static void main(String[] args) {
        System.out.println("main thread start");
        ThreadUtil.sleep(1);

    }
    
    public static void allocate(int n)
    {
       // ArryList<ch08_01_jconsole> ch08_01_jconsoleArryList = new ArryList<ch08_01_jconsole>();
    }
}
