import java.util.*;
import java.util.concurrent.locks.*;

class H2O implements Runnable
{
    static final Lock lock = new ReentrantLock();
    static LinkedList<Condition> hQueue = new LinkedList<Condition>();
    static LinkedList<Condition> oQueue = new LinkedList<Condition>();

    private String particle;
    private int id;

    public H2O(String particle, int id)
    {
        this.particle = particle;
        this.id = id;
    }

    public void run()
    {
        if (particle.equals("h"))
        {
            H(id);
        }
        else if (particle.equals("o"))
        {
            O(id);
        }
    }

    public static void H(int hid)
    {
        lock.lock();
        try {
            if (hQueue.size() >= 1 && oQueue.size() >= 1)
            {
                // generate water
                Condition hc = hQueue.poll();
                Condition oc = oQueue.poll();
                hc.signal();
                oc.signal();
                System.out.println("H:" + hid);
            }
            else
            {
                // wait
                Condition c = lock.newCondition();
                hQueue.add(c);
                c.await();
                System.out.println("H:" + hid);
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void O(int oid)
    {
        lock.lock();
        try {
            if (hQueue.size() >= 2)
            {
                // generate water
                Condition hc1 = hQueue.poll();
                Condition hc2 = hQueue.poll();
                hc1.signal();
                hc2.signal();
                System.out.println("O:" + oid);
            }
            else
            {
                // wait
                Condition c = lock.newCondition();
                oQueue.add(c);
                c.await();
                System.out.println("O:" + oid);
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}

public class WaterH2O {
    public static void main(String args[]) throws InterruptedException {
        for (int i = 1; i <= 6; i++)
        {
            new Thread(new H2O("h", i)).start();
        }
        Thread.sleep(1000);
        for (int i = 1; i <= 6; i++)
        {
            new Thread(new H2O("o", i)).start();
        }
        Thread.sleep(1000);
        for (int i = 7; i <= 36; i++)
        {
            new Thread(new H2O("h", i)).start();
        }
        Thread.sleep(1000);
        for (int i = 7; i <= 12; i++)
        {
            new Thread(new H2O("o", i)).start();
        }
        Thread.sleep(1000);
        for (int i = 13; i <= 18; i++)
        {
            new Thread(new H2O("o", i)).start();
        }
    }
}