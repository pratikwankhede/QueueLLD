package org.example;

import java.util.ArrayList;

public class Queue extends QueueParent
{
    private ArrayList<Integer> list;
    private int min;
        int capacity;

    public int getCapacity()
    {
        return capacity;
    }
    public Queue(int cap)
    {
        list = new ArrayList<>();
        min = Integer.MAX_VALUE;
        capacity=cap;
    }

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
            list.add(x);
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
            int popped = list.remove(0);
            //System.out.println("Removed "+popped);
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
