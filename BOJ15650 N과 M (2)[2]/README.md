# [15650] N과 M (2)

## 분류
> 백트래킹

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15650_2 {
    static int N, M;
    static int[] numbers;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[M];

        dfs(0, 1);
    }

    static void dfs(int depth, int root){
        if(depth == M){
            for(int n : numbers){
                System.out.print(n + " ");
            }
            System.out.println();
            return;
        }

        for(int i = root; i <= N; i++){
                numbers[depth] = i;
                dfs(depth + 1, i + 1);

        }
    }
}
```

## 문제풀이

N과 M(1)과 다른 점은 수열이 오름차순 이라는 것이다. 

오름차순으로 수열에 넣으려면 가장 먼저 떠오르는 방법은 이중 포문에서 내부에 있는 for반복문의 j를 i + 1부터 시작하는 방법으로 하면 된다. 그렇다는 것은 굳이 방문 여부를 체크해줄 필요도 없고, 재귀 함수를 호출할 때 i + 1부터 for문이 실행되도록 하면 되는 것.

그래서 dfs의 매개변수로 수열의 길이를 체크해줄 depth와 root값을 두고, 방문 여부 관련 로직은 모두 지웠다.

반복문과 재귀 함수 로직을 머리로 팽팽 돌릴 수 있는 훈련을 하는 것 같은 느낌...
