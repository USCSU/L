package LinkedIn;

/**
 * Created by Trace_route on 11/17/14.
 */
public class SingltonPrac {
    private static SingltonPrac instance;
    //lazy initialization
    /*
    public SingltonPrac getInstance(){
        if(instance == null)
            instance = new SingltonPrac();
        return instance;
    } //Cons: When multi-threading, thread A initialize, thread B may initialize again.
    */
    //may incur too many resource, every time may need a mutex to to call the function,even the instance is created
    //*****
    /*
    public synchronized SingltonPrac getInstance(){
        if(instance == null)
            instance = new SingltonPrac();
        return instance;
    }
    */
    //double-check locking
    /*
    public SingltonPrac getInstance(){
        if(instance == null){
                synchronized (instance){
                    if(instance == null)
                        instance = new SingltonPrac();
                }
            }
        return instance;
    }
    */
    //cons: when memory is given, the whole memory may not be initialized, when other thread is using that memory,
    //the problem may incur.
    //在java里，赋值和创建对象是分开的，比如thread A 给了一个空白空间，还未初始化，这时线程B 发现已经初始化，要用，这时候内存的空间未初始化，
    //就出现了问题。
    //best solution ever as follows:
    //1. lazy initialization
    //2. use less resource
    //3. initialization problem
    private SingltonPrac(){

    }
    private static class container{
        public static SingltonPrac instance = new SingltonPrac();
    }
    public static SingltonPrac getInstance(){
        return container.instance;
    }
    //JVM保证加载类的时候，是互斥的，并且保证初始化完事。
    //调用getInstance的时候保证只初始化一次。
    //惰性加载

    public static void main(String[] args){
        SingltonPrac.getInstance();
    }
}
