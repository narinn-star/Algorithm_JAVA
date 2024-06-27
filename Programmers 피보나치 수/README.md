# [Programmers 피보나치 수] 

## 분류
> 연습문제

## 코드
```java
public class Pro피보나치_수 {
        public int solution(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 0;
            dp[1] = 1;
            dp[2] = 1;

            for(int i = 3; i <= n; i++){
                dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
            }

            return dp[n];
        }
}
```

## 문제풀이

제일 기본적인 dp문제, 피보나치 수다. 

프로그래머스가 이상한건지 자꾸 실패가 뜨는데 제출할 때마다 같은 코드임에도 점수가 달라지는 매직✨ 내일 다시 채점해봐야징
