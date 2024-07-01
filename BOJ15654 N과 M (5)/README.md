# [15654] N과 M (5)

## 분류
> 백트래킹

## 코드
```java
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15654 {
    static int N, M;
    static int[] inputArr, numbers;
    static boolean[] visited;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[M];
        inputArr = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            inputArr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(inputArr);

        dfs(0);

        bw.flush();
        bw.close();
    }

    static void dfs(int depth) throws IOException {
        if(depth == M) {
            for(int n : numbers) bw.write(n + " ");
            bw.write("\n");
            return;
        }

        for(int i = 0; i < N; i++){
            if(!visited[i]){
                visited[i] = true;
                numbers[depth] = inputArr[i];
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}

```

## 문제풀이

N과 M (1)번이랑 다른 점은 숫자가 주어지느냐 주어지지 않느냐의 차이다. 아마 1-5, 2-6, 3-7, 4-8 이렇게 로직은 같고 숫자가 주어지는가 주어지지 않는가의 차이만 다를 것이므로, 따로 풀이를 자세히 적지는 않겠다. 

[N과 M (1)](https://github.com/narinn-star/Algorithm_JAVA/tree/master/BOJ15649%20N%EA%B3%BC%20M%20(1\)%5B2%5D)
