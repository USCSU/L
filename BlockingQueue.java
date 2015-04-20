package LinkedIn;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Trace_route on 11/6/14.
 */
public class BlockingQueue {
     LinkedList<Integer> list;
     int size;
     public BlockingQueue(int size){
         this.size = size;
         list= new LinkedList<Integer>();
     }
    public synchronized int get(){
        if(list.size() ==0){
            try{
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
       int res =  list.poll();
        notifyAll();
        return res;
    }
    public synchronized void add(int val){
        if(list.size() == size){
            try {
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        list.add(val);
        notifyAll();
    }

}
class Producer implements  Runnable{
    BlockingQueue q;
    public Producer(BlockingQueue q){
        this.q = q;
    }
    public void run(){
        for(int i =0;i<q.size;i++){
            q.add(i+1);
            System.out.println("Producer:"+(i+1));
        }
    }
}
class Consumer implements  Runnable{
    BlockingQueue q;
    public Consumer(BlockingQueue q){
        this.q = q;
    }
    public void run(){
        while(q.list.size()!=0){
            System.out.println("Consumer:"+q.get());
        }
    }
}
class test{
    public static void main(String[] args){
        BlockingQueue q= new BlockingQueue(12);
        Thread producer = new Thread(new Producer(q));
        Thread consumer = new Thread(new Consumer(q));
        producer.start();
        consumer.start();
        try{
            producer.join();
            consumer.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
