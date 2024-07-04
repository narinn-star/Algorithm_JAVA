# [15666] N과 M (12)

## 분류
> 백트래킹

## 코드
```java
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15666 {
    static int N, M;
    static int[] numbers, inputArr;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[M];
        inputArr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            inputArr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(inputArr);

        dfs(0, 0);

        bw.flush();
        bw.close();
    }

    static void dfs(int depth, int start) throws IOException {
        if (depth == M) {
            for (int n : numbers) bw.write(n + " ");
            bw.write('\n');
            return;
        }

        int tmp = 0;
        for(int i = start; i < N; i++){
            if(tmp != inputArr[i]){
                numbers[depth] = inputArr[i];
                tmp = inputArr[i];
                dfs(depth + 1, i);
            }
        }
    }
}
```

## 문제풀이

11과 달리 오름차순 수열만 출력한다. 자기자신을 포함한 오름차순이기 때문에, 파라미터 값으로 i를 넘겨주면 j = i부터 N까지 도는 것으로 볼 수 있다. 

이제 N과 M 시리즈 끝 !!
