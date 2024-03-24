# [2606] 바이러스

## 분류
> 그래프 이론
>
> 그래프 탐색
>
> 너비 우선 탐색
>
> 깊이 우선 탐색

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2606_2 {
    private static int computer, connectNum, cnt = 0;
    private static boolean connectArray[][];
    private static boolean visited[];
    private static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        computer = Integer.parseInt(br.readLine());
        connectNum = Integer.parseInt(br.readLine());

        connectArray = new boolean[computer + 1][computer + 1];
        visited = new boolean[computer + 1];

        for(int i = 1; i <= connectNum; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            connectArray[a][b] = true;
            connectArray[b][a] = true;
        }

        queue.add(1);
        visited[1] = true;

        bfs();

        System.out.println(cnt);
    }

    private static void bfs(){
        while(!queue.isEmpty()){
            int q = queue.poll();

            for(int i = 1; i <= computer; i++){
                if(!visited[i] && connectArray[q][i]){
                    visited[i] = true;
                    queue.add(i);
                    cnt++;
                }
            }
        }
    }
}

```

## 문제풀이

dfs, bfs 문제를 풀때마다 dfs가 쉽게 여겨져서 항상 dfs로만 문제를 풀었던 것 같아서, 오늘은 bfs로만 문제를 풀었다. (왜인지 dfs가 먼저 떠올라..)

bfs는 queue를 이용해서 넣고 빼고를 반복하면 된다. 
한 가지 주의할 점은 방문하는 지점을 잘 체크해주고, 새로 큐에 넣는 정점도 잘 체크하고 넣어주면 된다. 카운팅이야 큐에 추가할 때마다 넣어주면 되는 것이고.. 전염되지 않는 것은 어차피 배열에 체크가 안되어 있어서 bfs 함수가 돌아도 닿지를 못하기 때문에 전혀 신경쓰지 않아도 된다.

! 인덱싱에 주의하쟈
