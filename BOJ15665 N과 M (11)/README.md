# [15665] N과 M (11)

## 분류
> 백트래킹

## 코드
```java
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15665 {
    static int N, M;
    static int[] numbers, inputArr;
    static boolean[] visited;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        bw = new BufferedWriter(new OutputStreamWriter(System.out));
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

    static void dfs(int depth)throws IOException{
        if(depth == M){
            for(int n : numbers) bw.write(n +" ");
            bw.write("\n");
            return;
        }

        int tmp = 0;
        for(int i = 0; i < N; i++){
            if(tmp != inputArr[i]){
                numbers[depth] = inputArr[i];
                tmp = inputArr[i];
                dfs(depth + 1);
            }
        }
    }
}

```

## 문제풀이

N과 M 9에서부터 이전 값을 저장해두고 비교해주는 건 동일하다. 이중 반복문으로 생각하면, i, j 모두 다 탐색하면서 출력하는 것이기 때문에 depth + 1만 넘겨주면 된다. 이전값을 확인해주는 것은 달라질 것이 전혀 없음.
