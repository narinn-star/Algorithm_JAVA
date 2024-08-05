# [1697] 숨바꼭질

## 분류
> 그래프 이론
> 
> 그래프 탐색
> 
> 너비 우선 탐색

## 코드
```java
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1697 {
    static int N, K;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N == K) {
            bw.write(0 + "");
            bw.flush();
            bw.close();
            br.close();
            return;
        }

        visited = new int[100001];
        bfs();
        bw.write(visited[K] + "");


        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        visited[N] = 0;
        queue.add(N);

        while (!queue.isEmpty()) {
            int q = queue.poll();

            if (visited[K] != 0) break;

            if (q - 1 >= 0 && visited[q - 1] == 0) {
                visited[q - 1] = visited[q] + 1;
                queue.add(q - 1);
            }
            if (q + 1 < visited.length && visited[q + 1] == 0) {
                visited[q + 1] = visited[q] + 1;
                queue.add(q + 1);
            }
            if (q * 2 < visited.length && visited[q * 2] == 0) {
                visited[q * 2] = visited[q] + 1;
                queue.add(q * 2);
            }
        }
    }
}
```

## 문제풀이


