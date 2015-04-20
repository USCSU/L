package LinkedIn;

import java.util.LinkedList;

public class BlockQueueAndOtherDataStructure{
    private LinkedList<Integer> q;
    private int capacity;
    public BlockQueueAndOtherDataStructure(int size){
        q = new LinkedList<Integer>();
        capacity = size;
    }
    public synchronized void add(int val){
        if(q.size() == capacity){
            try {
                wait();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        q.add(val);
        notifyAll();
    }
    public synchronized int get(){
        if(q.size() == 0){
            try{
                wait();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        int res = q.poll();
        notifyAll();
        return res;
    }
    public int getSize(){
        return q.size();
    }
    public int getCapacity(){
        return capacity;
    }
}
class ProducerTest implements  Runnable{
    BlockQueueAndOtherDataStructure q;
    public ProducerTest(BlockQueueAndOtherDataStructure q){
        this.q = q;
    }
    public void run(){
        for(int i =1;i<q.getCapacity()+1;i++){
            q.add(i);
            System.out.println("Producer:"+i);
        }
    }
}
class ConsumerTest implements Runnable{
    BlockQueueAndOtherDataStructure q;
    public ConsumerTest(BlockQueueAndOtherDataStructure q){
        this.q = q;
    }
    public void run(){
        while(q.getSize()!=0){
            System.out.println("Consumer:"+q.get());
        }
    }
}
class Solution{
    public static void main(String[] args){
        BlockQueueAndOtherDataStructure q = new BlockQueueAndOtherDataStructure(10);
        Thread producer = new Thread(new ProducerTest(q));
        Thread consumer = new Thread(new ConsumerTest(q));
        producer.start();
        consumer.start();
//        try{
//            producer.join();
//            consumer.join();
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
    }
}