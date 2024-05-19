# [Programmers 괄호 회전하기] 

## 분류
> 월간 코드 챌린지 시즌2

## 코드
```java
import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        
        for(int i = 0; i < s.length(); i++){
            if(isBracket(sb.toString())) {
                answer++;
            }
            char c = s.charAt(i);
            sb.append(c);
            sb.deleteCharAt(0);
        }
        
        return answer;
    }
    
    private static boolean isBracket(String bracket) {
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < bracket.length(); i++){
            char c = bracket.charAt(i);
            switch(c){
                case '[': stack.push('[');
                    break;
                case '(': stack.push('(');
                    break;
                case '{': stack.push('{');
                    break;
                case ']': if(stack.isEmpty() || stack.pop() != '[') return false;
                    break;
                case ')': if(stack.isEmpty() || stack.pop() != '(') return false;
                    break;
                case '}': if(stack.isEmpty() || stack.pop() != '{') return false;
                    break;
            }
        }
        
        return stack.isEmpty();
    }
}
```

## 문제풀이

괄호가 올바르게 짝지어져 있는지 확인하는 것은 이전에 백준에서도, 릿코드에서도 해본 적이 있어서 복습삼아 쉽게 풀 수 있었다. 그래서 문제를 풀 때는 Rotate 하는 것에 조금 더 신경을 썼다. 

최근 알고리즘을 풀면서 StringBuilder 관련 메서드를 많이 사용했는데, 그래서 이를 활용해서 붙이고 떼어내는 것을 해봤다. 먼저 첫번째 문자를 맨 뒤에 추가해주고, 맨 앞 문자는 없애주는 방법이다. deleteCharAt() 메서드를 사용하면 원하는 인덱스에 위치한 문자를 없앨 수 있고, 없앤 곳은 공백이 아니라 하나씩 앞으로 당겨지기 때문에 사용하기에 적절했다. 

올바른 괄호인지 확인하는 함수는 stack을 이용했다. 열림 괄호라면 stack에 넣고, 닫힘 괄호라면 stack에서 하나 꺼내 비교해 맞는 괄호인지 확인했다. 이 때, 스택이 비어있으면 이미 올바르지 않은 괄호이기 때문에 false를 반환해야한다. 마지막으로 함수 전체 리턴값은 true가 아닌 stack.isEmpty()이다. 반복문이 모두 끝난 후에도 stack에 값이 남아있다면 짝지어진 괄호가 없는, 올바르지 않은 괄호이기 때문에 false를 반환할 수 있도록 했다.
