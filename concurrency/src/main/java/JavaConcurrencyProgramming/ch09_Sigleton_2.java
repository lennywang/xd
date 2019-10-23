package JavaConcurrencyProgramming;

public class ch09_Sigleton_2 {
    private static ch09_Sigleton_2 instance = new ch09_Sigleton_2();
    private static int y;
    private static int x= 0;

    public ch09_Sigleton_2() {
        x++;
        y++;
    }

    public static ch09_Sigleton_2 getInstance(){
        return instance;
    }

    public static void main(String[] args) {
        ch09_Sigleton_2 singleton = ch09_Sigleton_2.getInstance();
        System.out.println(singleton.x);//0
        System.out.println(singleton.y);//1
    }
}
