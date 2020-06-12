package InnerClasses;

/**
 * To access the inner class, create an object of the outer class, and then create an object of the inner class
 */
public class OuterClass1 {

    int x = 10;

    class InnerClass1{
        int y = 5;
    }
}

class MyMainClass1{

    public static void main(String[] args) {
        OuterClass1 outerClass1 = new OuterClass1();
        OuterClass1.InnerClass1 innerClass1 = outerClass1.new InnerClass1();
        System.out.println(innerClass1.y + outerClass1.x);
    }
}
