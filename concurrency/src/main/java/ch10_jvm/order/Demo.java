package ch10_jvm.order;

public class Demo {
    private volatile int value=0;

    //b 后调用
    public int getValue() {
        return value;
    }

    //a 先调用
    public void setValue(int value) {
        this.value = value;
    }

    public static void main(String[] args) {
        int i=0;
        int j=1;
    }
}
