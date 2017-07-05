package javas;

public class Polymorphism {
    static void prn(int... num) {
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i] + "\t");
        }
        System.out.println("int");
    }
     
    // 다형성도 적용가능
    static void prn(double... num) {
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i] + "\t");
        }
        System.out.println("double");
    }
 
    public static void main(String[] args) {
        prn(10, 20, 30);
        prn(40.0, 50.0);
        prn(60);
    }
}

