package LinkedIn;

/**
 * Created by Trace_route on 11/6/14.
 */
public class Singleton {
    public static Singleton instance;
    public Singleton(){

    }
    //multithreading may incur some problems
//    public Singleton getInstance(){
//        if(instance == null)
//            instance = new Singleton();
//        return instance;
//
//    }
    // waste too many resources because once instance is created, no need to use lock
//    public synchronized  Singleton getInstance(){
//        if(instance == null){
//            instance = new Singleton();
//        }
//        return instance;
//    }
    // when one thread ask for memory, the memory hasn't been initialized. So once another thread is using the
    //memory, the problems may be incurred.
//    public Singleton getInstance(){
//        if(instance == null){
//            synchronized (instance){
//                if(instance == null)
//                    instance = new Singleton();
//            }
//        }
//        return instance;
//    }

}
/*
lazy initialization:
    only getinstance is called, the class may be initialized.
Low efficiency:
    only first call may incur mutual exclusion mechanism.
Last initialization:
    first call getinstsance(), JVM will make sure it's thread safe and every memory is initialized fully.
*/
class singlton{
    private singlton(){

    }
    private static class  container{
        public static singlton instance = new singlton();
    }
     singlton getInstance(){
        return container.instance;
    }
}
