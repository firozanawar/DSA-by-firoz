package InnerClasses;

/**
 * Unlike a "regular" class, an inner class can be private or protected.
 * If you don't want outside objects to access the inner class, declare the class as private:
 */
public class OuterClass2 {

    int x = 10;

    class InnerClass2{
        int y = 5;
    }
}

class MyMainClass2{

    public static void main(String[] args) {
        OuterClass2 outerClass1 = new OuterClass2();
        OuterClass2.InnerClass2 innerClass1 = outerClass1.new InnerClass2();
        System.out.println(innerClass1.y + outerClass1.x);
    }
}
