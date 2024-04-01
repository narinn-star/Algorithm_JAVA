# [Leetcode 283] Move Zeroes

## 분류
> Tree
> 
> Depth-First Search
> 
> Breadth-First Search
> 
> Binary Tree

## 코드
```java
class Solution {
    public boolean isPalindrome(int x) {
        /* ------------------1------------------- */
        if(x < 0) return false;
        else {
            int reverse = 0;
            int temp = x;
            while(temp != 0){
                reverse *= 10;
                reverse += temp % 10;
                temp /= 10;
            }
            return (reverse == x);
        }
        /* ------------------2------------------- */
        // String input = Integer.toString(x);
        // String output = "";
        // for(int i = input.length() - 1; i >= 0; i--){
        //     output += input.charAt(i);
        // }

        // return input.equals(output);
        /* ------------------3------------------- */
        // String input = Integer.toString(x);
        
        // StringBuffer sb = new StringBuffer(input);

        // String output = sb.reverse().toString();

        // return input.equals(output);
        /* ------------------4------------------- */
        // Stack<Character> stack = new Stack<>();

        // String input = Integer.toString(x);

        // for(int i = 0; i < input.length(); i++){
        //     stack.push(input.charAt(i));
        // }

        // String output = "";
        // for(int i = 0; i < input.length(); i++){
        //     output += stack.pop();
        // }
        
        // if(input.equals(output)){
        //     return true;
        // }else {
        //     return false;
        // }
    }
}
```

## 문제풀이

여러가지 풀이 방법이 떠올라서 하나씩 다 작성해보았다.
크게 String으로 바꾸어 푸는 방법과 int형 그대로 사용해서 푸는 방법 두가지로 나뉜다.

1. int형 그대로 사용하는 방법이다.
나머지를 구하고 10씩 곱한 수에 더해가면 된다.

0 * 10 + 4 => 4 * 10 + 3 => 43 * 10 + 2 => 432 * 10 + 1 = 4321

음수는 뒤집었을 때 펠린드롬수가 나올 수 없기 때문에 사전에 제외했다.

String으로 변환하는 함수를 사용하지 않아서인지 시간이 가장 짧게 나왔다. (4ms)

2. 단순 반복문을 이용하는 방법이다.
반복문을 맨 뒷자리부터 시작해 0자리까지 수행하며 String에 쌓아간다. (17ms)

3. 통째로 한 번에 뒤집는 방법이다.
일반 문자열은 reverse()함수를 지원하지 않기 때문에 StringBuffer를 사용한다.

문자열로 변환하고 반복문을 사용하는 것보다는 시간이 짧게 나왔다. (7ms)

4. 스택을 사용하는 방법이다.

FIFO 방식이 떠올라서 작성해봤는데, 아마도 반복문이랑 크게 다를 바가 없어보이긴 한다.

반복문을 이용한 방법과 같은 시간이 나왔다. (17ms)
