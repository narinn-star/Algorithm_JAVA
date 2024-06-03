# [11725] 트리의 부모 찾기

## 분류
> 그래프 이론
> 
> 그래프 탐색
> 
> 트리
> 
> 너비 우선 탐색
> 
> 깊이 우선 탐색

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ11725_2 {
    private static int N;
    private static int[] parent;
    private static boolean[] visited;
    private static ArrayList<Integer> tree[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        parent = new int[N + 1];
        visited = new boolean[N + 1];
        tree = new ArrayList[N + 1];

        for(int i = 0; i < N+1; i++){
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree[a].add(b);
            tree[b].add(a);
        }
        dfs(1);

        for(int i = 2; i < parent.length; i++){
            System.out.println(parent[i]);
        }
    }

    private static void dfs(int root){
        visited[root] = true;

        for(int c : tree[root]){
            if(!visited[c]){
                parent[c] = root;
                dfs(c);
            }
        }
    }
}
```

## 문제풀이

겨우 5개월 전에 풀었던 문제인데 이렇게 감쪽같이 기억이 나지 않을 수가 있다. 😅

하나씩 트리를 그려보니, DFS로 풀면 간단히 풀리겠다 싶었다. (BFS도 마찬가지!) 처음엔 int 이차원 배열에 저장했는데 그러면 연결된 값을 하나씩 가져오는 게 힘들 것 같아서 ArrayList에 저장했다. 그럼 root에 연결된 값을 가져올 수 있고, 이를 루트로 하는 자식 노드를 바로 탐색할 수 있다.
