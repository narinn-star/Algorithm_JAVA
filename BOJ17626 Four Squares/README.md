# [17626] Four Squares

## 분류
> 다이나믹 프로그래밍
>
> 브루트포스 알고리즘

## 코드
```java
import java.io.*;

public class BOJ17626 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];
        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i <= N; i++){
            int min = Integer.MAX_VALUE;
            for(int j = 1; j * j <= i; j++){
                int tmp = i - j * j;
                min = Math.min(min, dp[tmp]);
            }
            dp[i] = min + 1;
        }

        bw.write(dp[N] + "");
        bw.flush();
        bw.close();
        br.close();
    }
}

//        dp[1] = 1;  // 1
//        dp[2] = dp[1 * 1] + 1; // 2
//        dp[2] = dp[1 * 1] + dp[2 - 1 * 1];
//        dp[3] = dp[1 * 1] + dp[3 - 1 * 1]; // 3
//        dp[4] = dp[2 * 2] + dp[4 - 2 * 2]; // 1
//        dp[5] = dp[2 * 2] + dp[5 - 2 * 2]; // 2
//        dp[6] = dp[2 * 2] + dp[6 - 2 * 2]; // 3
//        dp[7] = dp[2 * 2] + dp[7 - 2 * 2]; // 4
//dp[8] = dp[2 * 2] + dp[8 - 2 * 2]; // 2
//        dp[9] = dp[3 * 3]; // 1
//        dp[10] = dp[3 * 3] + dp[10 - 3 * 3]; // 2
//dp[11] = dp[3 * 3] + dp[11 - 3 * 3]; // 3
//        dp[12] = dp[3 * 3] + dp[12 - 3 * 3]; // 4
//예외
//dp[12] = dp[2 * 2] + dp[2 * 2] + dp[2 * 2];
//dp[12] = dp[2 * 2] + dp[12 - 2 * 2];
//dp[12] = dp[2 * 2] + dp[8];
//dp[23] = dp[4 * 4] + dp[23 - 4 * 4]; // 5;
//예외
//dp[23] = dp[3 * 3] + dp[3 * 3] + dp[2 * 2] + dp[1 * 1]; // 4
```

## 문제풀이

제일 처음엔 dp는 생각도 못했고, 이분탐색을 생각했다. 시간도 줄어들기도 할거고, N을 계속 줄여가면서 할 생각이었다. 근데 생각보다 머릿속에 구현만 되고 코드로 잘 작성이 안돼서 친구에게 도움 요청🚨  

친구가 생각한 방법은 규칙찾기였다. dp로 값을 쌓아가면 된다고 생각한 것.. 이게 맞았음. 듣자마자 바로 dp로 접근했다.  

dp로 풀려면 점화식이 가장 중요해서, 규칙을 우선 찾으려고 쭉 풀어서 작성해보았다. 작성한 예시가 위에 주석처리된 부분이고, 12, 23 등 특정 숫자에서 규칙에서 벗어나는 값들이 있었다. 그 값들 마저도 규칙이 있었다. 더 작은 제곱근을 선택하면 값이 더 작아지는 것 ..! 그래서 j를 1부터 `j * j <= i`로 조건을 두었다. 사실 뭐.. 작은거부터 하든 큰거부터 하든 가장 작은 값을 구하는 거라 크게 상관은 없겠지만..!

이 문제에서 포인트는 `dp[i - j * j]`와 반복문을 나오고 나서 dp[i]에 min + 1을 해주는 것이다. dp만큼 코드가 짧은 것도 없지만.. 그렇게 줄이기 위해서 엄청 꼼꼼하게 생각해아하고 어려운 게 dp인 걸 다시 느꼈음..
