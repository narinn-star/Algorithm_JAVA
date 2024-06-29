# [15649] N과 M (1)

## 분류
> 백트래킹

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15649 {
    static int N, M;
    static int[] numbers;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[M];
        visited = new boolean[N + 1];

        dfs(0);
    }

    static void dfs(int n){
        if(n == M) {
            for(int i : numbers) System.out.print(i + " ");
            System.out.println();
            return;
        }

        for(int i = 1; i <= N; i++){
            if(!visited[i]) {
                numbers[n] = i;
                visited[i] = true;
                dfs(n + 1);
                visited[i] = false;
            }
        }
    }
}
```

## 문제풀이

약 1년만에 풀어보는 백트래킹. 아주 조금 기억에 의존해서 풀었지만, 이제 며칠동안은 백트래킹만 풀어볼 예정이라 되돌아보면서 풀었다.

1부터 N까지의 숫자로 길이가 M인 수열을 만드는 것으로, 출력도 작은 수부터 하면되는 문제다.
백트래킹의 가장 중요한 점은 방문했던 곳을 체크했던 것을 다시 풀어주는 것이다. for문이 어떻게 돌아가는지, 함수를 호출하고 함수가 끝난 후에 어느 자리 어느 시점으로 돌아오는지에 대한 개념만 있으면 쉬운 문제였다. 
그래도 작년에는 이 함수가 어떻게 돌아가는지도 이해하기 힘겨웠던 것 같은데, 이제는 다행히(?) 척척 풀어낼 수 있음에 감사 ,,,

매개변수로 깊이 (길이)를 넣어주고 재귀 호출할 때마다 +1 해서 호출하고 길이가 M이 됐을 때는 그때까지 채워져 있는 배열을 출력해주면 된다.
