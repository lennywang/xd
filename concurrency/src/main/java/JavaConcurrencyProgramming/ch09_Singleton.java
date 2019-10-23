package JavaConcurrencyProgramming;

public class ch09_Singleton {
    private static int x= 0;
    private static int y;
    private static ch09_Singleton instance = new ch09_Singleton();

    public ch09_Singleton() {
        x++;
        y++;
    }

    public static ch09_Singleton getInstance(){
        return instance;
    }

    public static void main(String[] args) {
        ch09_Singleton singleton = ch09_Singleton.getInstance();
        System.out.println(singleton.x);//1
        System.out.println(singleton.y);//1
    }
}
