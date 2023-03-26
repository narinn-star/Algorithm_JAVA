# [2167] 2차원 배열의 합

## 분류
> 구현
>
> 누적 합

## 코드
```java
import java.io.*;
import java.util.StringTokenizer;

public class BOJ2167 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n+1][m+1]; //기본 배열 선언

        for(int i = 1; i <= n; i++){ //문제에서 (0,0)부터가 아니라 (1,1)부터로 계산하도록 했으니, 편의를 위해 1부터 반복
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1; j <= m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken()); //배열 채우기
            }
        }

        int k = Integer.parseInt(br.readLine());

        for(int l = 0; l < k; l++) {
            st = new StringTokenizer(br.readLine(), " ");
            int i = Integer.parseInt(st.nextToken());   //이렇게 하나씩 받는 방법밖에 없을까?
            int j = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int sum = 0;    //출력할 값

            for (int a = j; a <= y; a++) {
                for (int b = i; b <= x; b++) {
                    sum += arr[b][a];   //세로로 반복해야하니까!
                }
            }
            System.out.println(sum);
        }
    }
}

```

## 문제풀이

단순 반복문 문제다.

배열을 초기화 하고 구간을 하나씩 입력받는 것 때문에 코드가 길어지긴 했지만 어렵지 않은 문제다.
무슨 생각 때문인지, 반복을 (0,0) (0,1) (0,2) (1,0) (1,1) (1,2) 이렇게가 아니고 (0,0) (1,0) (0,1) (1,1) (0,2) (1,2) 이렇게 해야한다 생각해서 반복문 상태가 저렇게 됐다..
어떻게든 반복해서 더하면 끝인 문제인데 혼자 꼬아서 풀어낸 것 같다. 그래도 이렇게 저렇게 생각해볼 수 있는 좋은 기회라 여기기로 했다😅


