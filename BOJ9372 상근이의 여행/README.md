# [9372] 상근이의 여행

## 분류
> 그래프 이론
> 
> 트리

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ9372 {
    private static int N, M, res;
    private static boolean[] visited;
    private static int[][] plain;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            res = 0;

            plain = new int[N + 1][N + 1];
            visited = new boolean[N + 1];

            for(int i = 0; i < M; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                plain[a][b] = 1;
                plain[b][a] = 1;
            }

            bfs();
            System.out.println(res - 1);
        }
    }

    private static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;

        while(!queue.isEmpty()){
            res++;
            int value = queue.poll();

            for(int i = 1; i <= N; i++){
                if(plain[value][i] != 0 && !visited[i]){
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
```

## 문제풀이

트리 문제인데 DFS/BFS 문제로 푸는 건가.. 어떻게 푸는 건가 참고 해보니 MST, 최소 신장 트리 문제였다. 

신장 트리는 그래프의 모든 정점을 포함하는 트리다.
하나의 그래프에 아래와 같이 여러 신장 트리가 존재할 수 있다.

![신장트리 그림](https://velog.velcdn.com/images/suk13574/post/798355fe-79bb-47c1-a1a7-f147ab31637b/image.png)

이 중에서도 가중치 합이 가장 작은 트리가 최소 신장 트리다. 
간선의 갯수는 n개의 정점을 가질 때, n - 1개의 간선을 사용한다.

즉, 그냥 정답은 N - 1이 되는 것😅

뭐 그래도 BFS로도 당연히 풀 수 있는거임

참고
https://velog.io/@suk13574/%EC%9E%90%EB%A3%8C%EA%B5%AC%EC%A1%B0-%EC%B5%9C%EC%86%8C-%EC%8B%A0%EC%9E%A5-%ED%8A%B8%EB%A6%AC
