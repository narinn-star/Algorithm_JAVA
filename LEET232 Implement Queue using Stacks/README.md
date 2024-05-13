# [Leetcode 232] Implement Queue using Stacks

## 분류
> Stack
> 
> Design
> 
> Queue


## 코드
```java
class MyQueue {
    Stack<Integer> stack;
    Stack<Integer> queue;

    public MyQueue() {
        stack = new Stack<>();
        queue = new Stack<>();    
    }
    
    public void push(int x) {   
        if(stack.size() == 0 && queue.size() == 0) stack.push(x);
        else{
            if(queue.size() != 0) queue.push(x);
            else stack.push(x);
        }
    }
    
    public int pop() {
        if(stack.size() != 0) {
            while(stack.size() > 1) queue.push(stack.pop());

            int pop = stack.pop();

            while(queue.size() > 0) stack.push(queue.pop());
            return pop;
        } else {
            while(queue.size() > 1) stack.push(queue.pop());

            int pop = queue.pop();

            while(stack.size() > 0) queue.push(stack.pop());
            return pop;
        }
    }
    
    public int peek() {
        if(stack.size() != 0) {
            while(stack.size() > 1) queue.push(stack.pop());

            int peek = stack.peek();

            while(queue.size() > 0) stack.push(queue.pop());
            return peek;
        } else {
            while(queue.size() > 1) stack.push(queue.pop());

            int peek = queue.peek();

            while(stack.size() > 0) queue.push(stack.pop());
            return peek;
        }
    }
    
    public boolean empty() {
        if(stack.size() == 0 && queue.size() == 0) return true;
        else return false;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
```

## 문제풀이

Stack 두개 만을 가지고 Queue를 구현하는 문제다.

Stack은 LIFO, Queue는 FIFO로 Stack으로 Queue를 구현하려면 넣고빼는 것을 잘 해주면 된다. 

