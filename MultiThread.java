package LinkedIn;

import java.util.LinkedList;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

class BlockQueue {
    LinkedList<Integer> q;
    int size;

    public BlockQueue(int size) {
        q = new LinkedList<Integer>();
        this.size = size;
    }

    public synchronized void add(int val) {
        while (q.size() == size) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        q.add(val);
        notifyAll();
    }

    public synchronized int get() {
        while (q.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int t = q.poll();
        notifyAll();
        return t;
    }

}

class producer1 implements Runnable {
    BlockQueue q;

    public producer1(BlockQueue q) {
        this.q = q;
    }

    public void run() {
        for (int i = 1; i < q.size; i++) {
            q.add(i);
            System.out.println("producer1:" + i);
        }
    }
}

class consumer1 implements Runnable {
    BlockQueue q;

    public consumer1(BlockQueue q) {

        this.q = q;
    }

    public void run() {
        while (true) {
            System.out.println("consumer1:" + q.get());
        }
    }
}

class produer implements Runnable {
    BlockingDeque<Integer> bq = new LinkedBlockingDeque<Integer>();

    public produer(BlockingDeque<Integer> q) {
        bq = q;
    }

    public void run() {
        for (int i = 1; i < 100; i++) {
            System.out.println("proder:" + i);
            try {
                bq.put(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class consumer implements Runnable {
    BlockingDeque<Integer> bq = new LinkedBlockingDeque<Integer>();

    public consumer(BlockingDeque<Integer> q) {
        bq = q;
    }

    public void run() {
        while (true) {
            try {
                System.out.println("consumer:" + bq.take());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

public class MultiThread {

    public static void main(String[] args) {
        BlockQueue q = new BlockQueue(15);
        Thread t1 = new Thread(new producer1(q));
        Thread t2 = new Thread(new consumer1(q));
        t2.start();
        t1.start();
    }

}
