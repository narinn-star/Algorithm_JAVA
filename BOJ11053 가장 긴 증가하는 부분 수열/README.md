# [11053] 가장 긴 증가하는 부분 수열

## 분류
> 다이나믹 프로그래밍

## 코드
```java
import java.io.*;
import java.util.StringTokenizer;

public class BOJ11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        int max = 1;
        for(int i = 0; i < N; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                // {10 20 10 30 20 50}
                // i = 1 j = 0
                // dp[1] = 2
                // i = 2 j = 0, 1
                // dp[2] = 1
                // i = 3 j = 0, 1, 2
                // dp[3] = 3
                if(A[i] > A[j] && dp[i] < dp[j] + 1){
                    dp[i] = dp[j] + 1;
                    max = Math.max(max, dp[i]);
                }
            }
        }

        bw.write(max +"");
        bw.flush();
        bw.close();
        br.close();
    }
}
```

## 문제풀이

주석에 풀이 있서용
