package ch09_pritice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 **/
@RestController
public class ch09_FullGCSimulate {

    private static final int SIZE=100*1024*1024;


    @ResponseBody
    @RequestMapping("/hello")
    public String hello() throws InterruptedException {
        byte[] bytes = new byte[SIZE];
        Thread.sleep(1000);
        return "Hello World";
    }

}
