# [Leetcode 150] Evaluate Reverse Polish Notation

## 분류
> Array
> 
> Math
> 
> Stack

## 코드
```java
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> operands = new Stack<>();
        
        for(int i = 0; i < tokens.length; i++){
            try{
                operands.push(Integer.parseInt(tokens[i]));
            }catch(NumberFormatException e){
                int b = operands.pop();
                int a = operands.pop();
                switch(tokens[i]){
                    case "+": operands.push(a + b);
                    break;
                    case "-": operands.push(a - b);
                    break;
                    case "*": operands.push(a * b);
                    break;
                    case "/": operands.push(a / b);
                }
            }
        }   
        return operands.pop();
    }
}
```

## 문제풀이

첫 Medium 문제라 긴장하고 시작했는데, 스택의 기본적인 문제였다. 스택을 구현하는 건 아니고, 스택이 last in first out 구조인 것만 알면 쉽게 풀 수 있는 문제다.

영문으로 된 문제라, Reverse Polish Notation이 뭔지 몰라서 알아보는데, 거기에 스택을 활용해서 구현하는 거라고 보란듯이 나와있었긴 하지만.. 백준에서도 여러번 풀어봤던 문제라 어렵지 않았다.

if-else문을 사용할 수도 있고, switch문을 사용할 수도 있는데 나는 항상 switch문을 사용해왔던 것 같다. 시간복잡도를 찾아보니 3개 이상일 때는 switch가 낫다 뭐라뭐라,,, 아무튼 if가 맞고 switch가 맞고 할 건 없는 듯 했다. 다만, try-catch문을 사용해서인지 시간이 엄청 크게 나오긴 했다. 

시간을 줄이려면 그냥 try-catch 없애고 if-else문 만으로도 충분할 듯하긴 하다. 
