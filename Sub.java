package LinkedIn;

class Base{
    public static int a = 10;
    public int b = 20;
    static
    {
        System.out.println("Static Init Base " + a);
        //System.out.println("Null Init " + b);
    }
    public Base()
    {
        System.out.println("Init Base " + this.b);
    }
}
//一级子类和基类包含的内容一样
 class SuperClass extends Base{
    //静态变量、静态块执行顺序，按书写先后顺序
    public static int a1 = getSuperStaticNumber();
    //public static SuperClass instance;

    public int b1 = getSuperInstanceNumber();
    public SuperClass()
    {
        System.out.println("Init SuperClass" + this.b1);
    }
    static
    {
        System.out.println("Static Init SuperClass" + a1);
    }
    public static int getSuperStaticNumber()
    {
        System.out.println("Static member init");
        return 100;
    }
    public int getSuperInstanceNumber()
    {
        System.out.println("Instance member init");
        return 200;
    }
}

//二级子类为测试该代码的驱动类

public class Sub extends SuperClass{
    public static int a2 = getStaticNumber();
    public int b2 = getInstanceNumber();
    static class container{

        public static Sub instance = new Sub();
        public container (){
            System.out.println("singlton static initilization");
        }
    }
    public Sub getInstance(){
        System.out.println("get Instance");
        return container.instance;
    }
    public Sub()
    {
        System.out.println("Init SubClass " + this.b2);
    }
    public static int getStaticNumber()
    {
        System.out.println("Static member init Sub");
        return 1000;
    }
    public int getInstanceNumber()
    {
        System.out.println("Instance member init Sub");
        return 2000;
    }
    static
    {
        System.out.println("Static Init " + a2);
    }

    // 程序入口,main
    public static void main(String args[])
    {
        new Sub();
    }
}
