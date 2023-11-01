package _15_Stack;
import java.util.*;
/*
15. 스택 두개로 큐를, 큐 두개로 스택을 구현하는 코드를 작성해 보세요.
 */
public class QueueUsingStack {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public QueueUsingStack(){
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void enqueue(int item){
        stack1.push(item);
    }

    public Integer dequeue(){
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        if(stack2.isEmpty()){
            throw new RuntimeException();
        }
        return stack2.pop();
    }
}
