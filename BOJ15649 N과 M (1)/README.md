# [15649] N과 M (1)

## 분류
> 브루트포스
>
> 백트래킹

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15649 {
    private static int N, M;
    private static boolean[] visited;
    private static int[] res;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];
        res = new int[M + 1];

        nm(0);
        System.out.println(sb);
    }
    private static void nm(int index){
        //다 탐색했으면 종료
        if(index == M){
            for(int i = 0; i < M; i++){ // 출력할 갯수만큼
                sb.append(res[i] + " ");
            }
            sb.append("\n");
            return;
        }

        //계속 탐색
        for(int i = 1; i <= N; i++){ // [1, ...], [2, ...], [3, ...]
            if(visited[i]) continue; //이미 방문했다면 패스
            visited[i] = true;
            res[index] = i; //숫자 넣고
            nm(index + 1); // 다음으로 넘어가기
            visited[i] = false; // 다시 열어줘야 다음 반복에서 방문 가능
        }
    }
}
```

## 문제풀이

백트래킹의 대표적인 문제라고 해서 한 번 풀어봤다.

두번째 예제를 예로 들어 풀이하면 다음과 같다.
N = 4, M = 2이면 4개 중 2개를 중복없이 나열하는 것이다. [1, 2] [1, 3] [1, 4] [2, 1] [2, 3] ...

각각 N, M 크기의 배열을 만들어 주고, 바로 함수를 호출한다.
함수 내부에서는 먼저 [1 , n]의 n을 결정한다.
visited는 모두 false로 들어가있으니, 첫 줄은 무시하고 지나가게 된다.
이제 1은 방문 했으니, 바로 true로 바꿔주고 출력할 배열 res에 하나씩 숫자를 쌓는다. (여기서는 1)
그럼 다시 함수를 호출하게 되고, index가 2 즉, 함수를 두번 호출하여 index가 M과 같아지면 출력 한 줄이 완성되므로 현재 호출되어진 함수를 종료하고 그 전 단계로 돌아가게 된다.

visited를 다시 false로 바꾸는 이유는 [1, 2] [1, 3] [1, 4] 를 하고 나면 1, 2, 3, 4가 모두 방문된 상태이므로 [2, 1]은 물론 [4, 3]까지 아무것도 실행되지 않은 채 함수가 모두 종료되기 때문이다.

