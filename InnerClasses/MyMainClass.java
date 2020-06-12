package InnerClasses;

/**
 * One advantage of inner classes, is that they can access attributes and methods of the outer class:
 */
class OuterClass4 {
  int x = 10;

  class InnerClass4 {
    public int myInnerMethod() {
      return x;
    }
  }
}

public class MyMainClass {
  public static void main(String args[]) {
    OuterClass4 myOuter = new OuterClass4();
    OuterClass4.InnerClass4 myInner = myOuter.new InnerClass4();
    System.out.println(myInner.myInnerMethod());
  }
}