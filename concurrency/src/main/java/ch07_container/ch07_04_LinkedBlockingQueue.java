package ch07_container;

import java.util.concurrent.LinkedBlockingDeque;

public class ch07_04_LinkedBlockingQueue {
    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingDeque<String> strings = new LinkedBlockingDeque<>();
        strings.add("111");
        strings.offer("111");
        strings.put("111");

        String remove = strings.remove();
        strings.poll();
        strings.take();
    }
}
