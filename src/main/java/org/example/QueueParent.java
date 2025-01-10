package org.example;

import java.util.LinkedList;

public class QueueParent {

    private LinkedList<Integer> list;
    private int min,capacity;

    public int getCapacity()
    {
        return capacity;
    }

//    public Queue2(int cap)
//    {
//        list = new LinkedList<>();
//        min = Integer.MAX_VALUE;
//        capacity=cap;
//    }

    private void calibrateMin()
    {
        int cand = Integer.MAX_VALUE;
        for(int x: list)cand=Math.min(x,cand);
        min=cand;
    }

    public int enqueue(int x)
    {
        if(list.size()<capacity)
        {
            list.addLast(x);
            if(x<min)min=x;

            return 0;
        }
        else {
            return -1;
        }
    }

    public int dequeue()
    {
        if(!list.isEmpty())
        {

            int popped = list.removeFirst();
            calibrateMin();
            return popped;
        }
        else {
            return Integer.MAX_VALUE;
        }
    }

    public int getMin()
    {
        return min;
    }

}
