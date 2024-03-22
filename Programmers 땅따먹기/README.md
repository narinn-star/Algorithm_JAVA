# [Programmers 땅따먹기] 

## 분류
> 연습문제

## 코드
```java
class Solution {
    int solution(int[][] land) {
        int answer = 0;
        
        int dp[][] = new int[land.length][land[0].length];
        
        for(int i = 0; i < dp[0].length; i++){
            dp[0][i] = land[0][i]; // 첫 줄 셋팅
        }
        
        for(int i = 1; i < dp.length; i++){ 
            for(int j = 0; j < dp[0].length; j++){
                int max = -1;   // 최댓값 찾기 준비
                for(int k = 0; k < dp[0].length; k++){
                    if(j == k) continue; // 같은 열을 연속해서 밟을 수 없다.
                    max = Math.max(max, dp[i-1][k]); // 한 행의 최댓값 구하기
                }
                dp[i][j] = max + land[i][j]; // 구한 최댓값과 현재 자리 아래값을 더해 dp를 채운다.
            }
            
        }
        
        for(int i = 0; i < dp[0].length; i++){
            answer = Math.max(dp[dp.length-1][i], answer); // 마지막 행에서 가장 큰 값이 최댓값
        }

        return answer;
    }
}
```

## 문제풀이

dp문제를 풀어보려고 추천받아 풀었는데, 처음엔 왜 이게 dp인가를 한참 고민했다.
dp다 dp다 계속 생각하면서 보니 최댓값을 쌓아가면 되는 것 같아서 그쪽으로 생각을 했다.

내가 손으로 풀어낸 풀이는 아래와 같다.

입력
1 2 3 5
5 6 7 8
4 3 2 1

dp[][]
1  2  3  5
9  10 11 12
12 14 15 16

인덱스가 너무 헷갈려서 한참을 집중한 듯..
나머지 해설은 위의 주석이 다입니당 ~

* 첫 줄을 셋팅한 이유는 이전 값에서 굳이 더해줄 필요가 없기 때문!
