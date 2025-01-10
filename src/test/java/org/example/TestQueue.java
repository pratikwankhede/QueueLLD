package org.example;

import org.junit.Assert;
import org.junit.Test;


public class TestQueue {

    public static final int CAP = 1000000000;

    @Test
    public void test()
    {
        QueueOptimised q = new QueueOptimised(10);

        q.enqueue(1);
        q.enqueue(7);
        q.enqueue(2);
        q.enqueue(4);
        q.enqueue(3);

        Assert.assertEquals(1,q.getMin());
        Assert.assertEquals(1,q.dequeue());
        Assert.assertEquals(2,q.getMin());
        Assert.assertEquals(7,q.dequeue());
        Assert.assertEquals(2,q.dequeue());
        Assert.assertEquals(3,q.getMin());
    }


    public int Perf(QueueParent qarg)
    {
        int CAP = qarg.getCapacity();
        //Queue, 300000,35620ms
        QueueParent q = qarg;

        int tstart = (int) System.currentTimeMillis();
        for(int i=CAP;i>=1;i--)
        {
            q.enqueue(i);
        }
        for(int i=CAP;i>=1;i--)
        {
            q.dequeue();
        }
        int tend = (int) System.currentTimeMillis();
        System.out.println("Time taken in ms by "+ q.getClass().getName()+ " : "+ (tend-tstart));
        return (tend-tstart);
    }

    @Test
    public void testPerf()
    {
        int CAP = 110000;
        int t1 = Perf(new Queue(CAP));
        int t2 = Perf(new Queue2(CAP));
        int t3 = Perf(new QueueOptimised(CAP));
    }

}
