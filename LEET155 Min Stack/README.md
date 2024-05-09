# [Leetcode 155] Min Stack

## 분류
> Stack
> 
> Design

## 코드
```java
class MinStack {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public MinStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    public void push(int val) {
        stack1.push(val);
        if(stack2.isEmpty() || val <= stack2.peek()){
            stack2.push(val);
        }
    }
    
    public void pop() {
        int a = stack1.pop();
        if(a == stack2.peek()) stack2.pop();
    }
    
    public int top() {
        return stack1.peek();
    }
    
    public int getMin() {
        return stack2.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
```

## 문제풀이

이렇게 Stack 자체를 가지고 풀어도 되는 문제인지는 모르겠지만,, 

최솟값을 정할 때 스택을 하나 더 만들어서 구현했다. stack1에 저장할 때 stack2의 peek()값과 비교해 작다면 넣고, 아니라면 그냥 넘어갔다. 그렇게하면 stack2에서 가장 먼저 꺼낼 값이 최솟값이 된다. 
나머지 push, pop, top은 stack 클래스의 메서드 push, pop, peek을 사용했다. 
pop에서는 꺼내지는 값이 최솟값일 경우 stack2에서도 빼줘야하기 때문에 같이 빼주었다.

