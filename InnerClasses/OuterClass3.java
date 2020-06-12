package InnerClasses;

/**
 * An inner class can also be static, which means that you can access it without creating an object of the outer class:
 */
public class OuterClass3 {

    int x = 10;

    static class InnerClass3{
        int y = 5;
    }
}

class MyMainClass3{

    public static void main(String[] args) {
        OuterClass3.InnerClass3 innerClass1 = new OuterClass3.InnerClass3();
        System.out.println(innerClass1.y);
    }
}
