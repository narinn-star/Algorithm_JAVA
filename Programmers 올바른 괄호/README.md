# [Programmers 올바른 괄호] 

## 분류
> 스택/큐

## 코드
```java
import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(') stack.push(c);
            else {
                if(!stack.isEmpty()){
                    char tmp = stack.peek();
                    if(tmp == '(') stack.pop();
                    else return false;
                } else return false;
            }
        }

        return stack.isEmpty();
    }
}
```

## 문제풀이

이제 괄호 문제는 한 번에 풀 수 있을 듯 하다. 

다른 문제와 달리 괄호 종류가 하나라, if else 조건문들로 간단히 해결할 수 있다.
만약 '(' 라면 스택에 넣어두고, ')'라면 앞에 들어간 괄호가 짝지인지 확인만 해주면 된다. 단, 스택이 비어있다면 꺼낼 수도 없고 틀렸기 때문에 바로 false를 리턴해주면 된다.
마지막 리턴문이 answer이 아니라 stack.isEmpty()인 이유는 for문이 모두 끝나고 나서 stack이 모두 비어있을 때만 올바른 괄호라는 것이 성립되기 때문이다. 열림 괄호나 닫힘 괄호가 하나라도 존재할 경우에는 올바른 괄호가 아니기 때문에 스택이 비었는가를 리턴문으로 넣었다.
