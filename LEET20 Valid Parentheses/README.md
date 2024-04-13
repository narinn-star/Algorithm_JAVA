# [Leetcode 20] Valid Parentheses

## 분류
> String
> 
> Stack

## 코드
```java
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{') stack.push(c);
            else{
                if(stack.size() == 0) return false;
                char pop = stack.pop();
                if((c == ')' && pop != '(') || (c == ']' && pop != '[') || (c == '}' && pop !='{')){
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
```

## 문제풀이

백준에서 비슷한 문제를 풀었던 것 같은데, 오래전이기도 하고 기억이 가물가물해서 기억을 더듬는 건 포기했다. 사실 기억을 더듬어서 풀어야할 문제가 아니기도 했지만😅

스택을 이용했다. 만약 시작 괄호라면 스택에 넣어주고, 닫는 괄호라면 스택에서 빼준다. 그리고 뺀 문자와 스택에 넣었던 값이 짝이 맞는지 확인해주기만 하면 된다. 예시들 처럼 괄호가 순서대로 ()[]{} 등 묶여있지 않고 ([{}])이렇게 되어있어도 마지막에 넣은 값이 { 이기때문에 }와 짝이 맞고, )까지 짝이 맞아떨어지는 것을 알 수 있따.

마지막에 stack.isEmpty()를 반환한 이유는, 괄호가 하나가 남아있거나, 짝이 맞아떨어지지 않아 남아있는 값이 있을수도 있기 때문에 남아있다면 false, 모두 짝이 맞아 비어있다면 true를 반환하도록 했다.
