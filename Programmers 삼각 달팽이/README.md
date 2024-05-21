# [Programmers 삼각 달팽이]

## 분류
> 월간 코드 챌린지 시즌1

## 코드
```java
class Solution {
    public int[] solution(int n) {
        int[] answer = new int[(n*(n + 1)) / 2];

        int[][] snail = new int[n][n];
        int cnt = 0, x = -1, y = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                if(i % 3 == 0) { // 밑으로
                    x++;
                }else if(i % 3 == 1) { // 오른쪽
                    y++;
                } else if(i % 3 == 2){ // 대각선
                    x--;
                    y--;
                }
                snail[x][y] = ++cnt;
            }
        }
        
        int idx = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(snail[i][j] == 0) break;
                answer[idx++] = snail[i][j];
            }
        }
        
        
        return answer;
    }
}
```

## 문제풀이

1시간 걸려서 푼 문제..

문제를 보자마자 배열 인덱스값으로 계산해야 할 건 알았는데, i % 3을 찾기까지 참 오래 걸렸다. 
아래로 가는 것, 오른쪽으로 가는 것, 대각선으로 가는 것 세가지로 나눠져서 조건문 세개로 나눠주고 반복문을 돌기만하면 끝이다. 
간단한 구현 문제가 어째 자료구조보다 더 힘든 것 같다. 자료구조가 문제가 아니었음을 계속해서 깨닫는 중이다.😂 

