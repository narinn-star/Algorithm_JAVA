# [Programmers 숫자의 표현]

## 분류
> 연습문제

## 코드
```java
class Solution {
    public int solution(int n) {
        int answer = 0;

        for(int i = 1; i <= n; i++){
            int sum = 0;
            for(int j = i; j <= n; j++){
                sum += j;
                
                if(sum >= n){
                    if(sum == n) answer++;
                    break;
                }
            }
        }   
        return answer;
    }
}
```

## 문제풀이

하나씩 계속 더하면서 확인해주는 방법이 최선이었따 ... 
너무 쉬운 문제라 따로 풀이는 필요가 없다. 하나씩 더해주면서 탈출만 잘해주면 됨!!
