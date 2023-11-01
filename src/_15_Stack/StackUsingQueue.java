package _15_Stack;

import java.util.*;

/*
15. 스택 두개로 큐를, 큐 두개로 스택을 구현하는 코드를 작성해 보세요.
 */
public class StackUsingQueue {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public StackUsingQueue() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int item) {
        queue1.add(item);
        while(!queue2.isEmpty()){
            queue1.add(queue2.poll());
        }
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = queue1;
    }

    public Integer dequeue() {
        if(queue2.isEmpty()){
            throw new RuntimeException("stack is empty");

        }
        return queue2.poll();
    }
}
