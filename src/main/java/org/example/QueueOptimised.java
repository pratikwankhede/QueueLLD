package org.example;

import java.util.LinkedList;
import java.util.Stack;

public class QueueOptimised extends QueueParent {

    private LinkedList<Integer> list;
    private int capacity;
    private LinkedList<Integer> helper;

    public int getCapacity()
    {
        return capacity;
    }

    public QueueOptimised(int cap)
    {
        list = new LinkedList<>();
        helper = new LinkedList<>();

        capacity=cap;
    }



    public int enqueue(int x)
    {
        if(list.size()<capacity)
        {
            list.addLast(x);

            //helper changes
            while(!helper.isEmpty() && helper.get(0)>x)helper.remove(0);
            helper.add(0,x);

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
            if(popped==helper.getLast())
            {
                helper.removeLast();
            }
            return popped;
        }
        else {
            return Integer.MAX_VALUE;
        }
    }

    public int getMin()
    {
        return helper.isEmpty()? -1: helper.getLast();
    }

}
