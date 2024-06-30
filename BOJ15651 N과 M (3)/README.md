# [15650] N과 M (3)

## 분류
> 백트래킹

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15651 {
    static int N, M;
    static int[] numbers;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[M];

        dfs(0);

        System.out.print(sb);
    }

    static void dfs(int depth){
        if(depth == M){
            for(int n : numbers) sb.append(n + " ");
            sb.append("\n");
            return;
        }

        for(int i = 1; i <= N; i++){
            numbers[depth] = i;
            dfs(depth + 1);
        }
    }
}
```

## 문제풀이

이번에는 같은 수가 수열 내에 존재해도 된다는 조건이 추가됐다. 

N과 M(2)를 풀었을 때처럼, 반복문으로 생각하면 쉽게 접근할 수 있는 것 같다. (내 기준임)
그래서 이 문제도 반복문으로 대입해봤을 때, 이중 반복문에서 내부 for문도 j = 1이면 된다. 계속 전체를 탐색하면 모든 숫자의 조합을 다 뽑아낼 수 있다.

여기서도 방문 여부 체크는 필요 없고, 시작값도 필요 없다. 그냥 1부터 계속 돌려주면 됨!
