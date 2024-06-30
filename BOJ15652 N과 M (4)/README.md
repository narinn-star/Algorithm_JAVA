# [15652] N과 M (4)

## 분류
> 백트래킹

## 코드
```java
import java.io.*;
import java.util.StringTokenizer;

public class BOJ15652 {
    static int N, M;
    static int[] numbers;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[M];

        dfs(0, 1);

        bw.flush();
        bw.close();
    }

    static void dfs(int depth, int start) throws IOException {
        if(depth == M){
            for(int n : numbers) bw.write(n + " ");
            bw.write("\n");
            return;
        }

        for(int i = start; i <= N; i++){
                numbers[depth] = i;
                dfs(depth + 1, i);
        }
    }
}
```

## 문제풀이

N과 M (2)랑 N과 M (3)을 합친 문제같다. 오름차순인데 같은 수도 혀용이 되는 수열을 뽑아내야한다.

똑같이 이중 반복문으로 생각해보면, 내부 반복문의 j가 i부터 시작되도록 하면 된다. 당연히 방문여부 체크는 필요 없고, 재귀함수 호출 시 현재 i 값을 전달하고, 반복문을 전달받은 i부터 시작하면 된다.


