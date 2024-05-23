# [Leetcode 70] Climbing Stairs

## 분류
> Math
> 
> Dynamic Programming
> 
> Memoization

## 코드
```java
class Solution {
    public int climbStairs(int n) {
        int[] stairs = new int[46];

        stairs[1] = 1;
        stairs[2] = 2;
        
        for(int i = 3; i < stairs.length; i++){
            stairs[i] = stairs[i - 2] + stairs[i - 1];
        }

        return stairs[n];
    }
}
```

## 문제풀이

간단한 dp문제다. 

문제를 보자마자 dp인걸 안 건 아니고, n의 범위 `( 1 <= n <= 45 )`와 n이 4, 5일때를 하나씩 적어 규칙을 찾으려했다. n = 5까지만 적어봐도 n-1번째와 n-2번째를 합한 값이라는 게 바로 나왔고, n의 범위도 크지 않기 때문에 배열에 모두 담아두고 원하는 값(n번째)을 리턴해줘도 무리가 없겠다 생각했다.

EASY ~
