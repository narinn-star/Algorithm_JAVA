# [15663] N과 M (9)

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
            if(visited[i]) continue;

            if(tmp != inputArr[i]){
                visited[i] = true;
                numbers[depth] = inputArr[i];
                tmp = inputArr[i];
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}
```

## 문제풀이

앞전의 N과 M 문제와 다른 것은 이전 값을 저장해놓는 것이다. 처음에는 그냥 numbers[depth] == inputArr[i]일 때 재귀호출을 하지 않는 것으로 했는데 출력 초과가 나왔다. 근데 진짜 이유를 모름.. 다른 반례를 돌려봤을 때 값이 틀리게 나와서 이전 값을 따로 저장해두고 비교해줫는데 맞앗음.. 이유를 모름.........
