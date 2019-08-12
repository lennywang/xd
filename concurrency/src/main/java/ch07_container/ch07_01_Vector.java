package ch07_container;

import java.util.Iterator;
import java.util.Vector;

public class ch07_01_Vector {
    public static void main(String[] args) {
        final Vector<String> stringVector = new Vector<String>();
        for (int i = 0; i < 1000; i++) {
            stringVector.add("demo"+i);
        }

        stringVector.forEach(e->{
            if (e.equals("demo3")){
                stringVector.remove(e);
            }
        });

        Iterator<String> stringIterator = stringVector.iterator();
        while (stringIterator.hasNext()){
            String next = stringIterator.next();
            if (next.equals("demo2")){
                stringIterator.remove();
            }
        }

        for (int i = 0; i < 4; i++) {
            new Thread(()->{
                synchronized (stringIterator){
                    while (stringIterator.hasNext()){
                        String next = stringIterator.next();
                        if (next.equals("demo2")){
                            stringIterator.remove();
                        }
                    }
                }
            }).start();
        }

    }
}
