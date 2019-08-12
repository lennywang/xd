package ch02_runtimedataarea;

public class Ch02_07_RuntimeConstantPool {
    public static void main(String[] args) {
        String a = "abc";
        String b = "abc";
        System.out.println(a == b);
        System.out.println(a.equals(b));
        String c = new String("abc");
        System.out.println(a == c);
        System.out.println(a == c.intern());

        //true
        //true
        //false
        //true
    }
}
