# [15664] N과 M (10)

## 분류
> 백트래킹

## 코드
```java
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15663 {
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

        dfs(0, 0);

        bw.flush();
        bw.close();
    }

    static void dfs(int depth, int root)throws IOException{
        if(depth == M){
            for(int n : numbers) bw.write(n +" ");
            bw.write("\n");
            return;
        }

        int tmp = 0;
        for(int i = root; i < N; i++){
            if(tmp != inputArr[i]){
                numbers[depth] = inputArr[i];
                tmp = inputArr[i];
                dfs(depth + 1, i + 1);
            }
        }
    }
}
```

## 문제풀이

N과 M 9에서 이전 값을 저장해두고 비교해주는 방식과 또 다른 이전 N과 M에서 j = i + 1을 초기값으로 하는 반복문을 떠올려서 합쳤다. 저장해두는 방식이 9에서는 확실하게 이해가 잘 안갔는데, 오늘 풀면서 하나씩 디버깅 해보니 확실하게 이해를 할 수 있었따.
