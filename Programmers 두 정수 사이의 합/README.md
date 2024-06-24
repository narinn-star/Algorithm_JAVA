# [Programmers 두 정수 사이의 합] 

## 분류
> 연습문제

## 코드
```java
class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        
        if(a > b) {
            int tmp = b;
            b = a;
            a = tmp;
        }
        
        for(int i = a; i <= b; i++){
            answer += i;
        }
        
        return answer;
    }
}
```

## 문제풀이

a > b일 때는 b와 a를 바꾸어서 더해줘야하는 것 말고는 너무나도 기본적인 문제다.
백준에서는 아마 long인걸 안줬으니 한 번 틀렸겠다 싶었음..
