# [Programmers 정수 삼각형]

## 분류
> 동적계획법(Dynamic Programming)

## 코드
```java
class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int len = triangle.length;
        
        int dp[][] = new int[len][len];
        
        dp[0][0] = triangle[0][0]; // 7
        
        for(int i = 1; i < len; i++){
            dp[i][0] = dp[i-1][0] + triangle[i][0]; // 맨 왼쪽 줄
            
            for(int j = 1; j <= i; j++){
                dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]) + triangle[i][j]; // 나머지
            }
            
            dp[i][i] = dp[i-1][i-1] + triangle[i][i]; // 맨 오른쪽 줄
        }
        
        for(int i = 0; i < len; i++){
            answer = Math.max(answer, dp[len-1][i]);
        }
        
        return answer;
    }
}
```

## 문제풀이

어제 풀었던 땅따먹기랑 유사한 문제다.
어쩌면 조금 더 쉬웠을지도..!

입출력 예를 가지고 손으로 풀었을 땐 dp 배열이 아래와 같이 채워졌다.

7
10 15
18 11/16 15
20 25/23 20/19 19
24 25/30 27/22 26/25 24

가운데 두개 값만 나오는 것들만 max값을 찾아주면 되는데, 그럼 그렇지 않은 한개 값만 나오는 것은 어떻게 해야할지를 오래 고민했다. 아주 바보같은 고민이었지만..
그냥 왼쪽/오른쪽 따로 구하고, 가운데 친구들만 max를 찾아주면 되는 거였다! 인덱싱 하는 것도 꽤나 쉬워서 알고 나서는 바로 뚝딱 풀어냈다. 

DP에 조금 흥미를 붙인 그런 문제..!! 
