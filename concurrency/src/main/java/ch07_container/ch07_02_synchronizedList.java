package ch07_container;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ch07_02_synchronizedList {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        List<String> stringList = Collections.synchronizedList(strings);
    }
}
