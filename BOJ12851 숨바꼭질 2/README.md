# [12851] 숨바꼭질 2

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

public class BOJ12851 {
    static int N, K;
    static int min = Integer.MAX_VALUE;
    static int cnt = 0;
    static int[] visitTime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if(N == K){
            bw.write(0 + "\n" + 1);
            bw.flush();
            bw.close();
            return;
        }

        visitTime = new int[100001];

        bfs();

        bw.write(min + "\n" + cnt + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        visitTime[N] = 1;
        queue.add(N);

        while(!queue.isEmpty()){
            int q = queue.poll();

            if(min < visitTime[q]) return;

            for(int i = 0; i < 3; i++){
                int dest = 0;

                if(i == 0) dest = q + 1;
                else if(i == 1) dest = q - 1;
                else dest = q * 2;

                if(dest < 0 || dest > 100000) continue;

                if(dest == K) { // 도착
                    min = visitTime[q];
                    cnt++;
                }

                if(visitTime[dest] == 0 || visitTime[dest] == visitTime[q] + 1) {
                    visitTime[dest] = visitTime[q] + 1;
                    queue.add(dest);
                }
            }

        }
    }
}
```

## 문제풀이

숨바꼭질 1에서 구했던 최단 시간으로 동생을 찾을 수 있는 방법의 수까지 계산해줘야 하는 문제다.  

1을 풀 땐 for문을 쓰지 않고 그냥 if 세개로 넣어뒀는데 가독성도 안좋고.. 다시 푸는 나도 너무 헷갈려서 for문으로 간단히 세개를 돌려줬다.  
처음엔 숨바꼭질 1 문제에서 visited[K] != 0일 때 최솟값을 정해주면서, 최솟값과 같으면 카운팅해주는 방법을 사용했는데, 그러면 가는 방법의 수가 제대로 세어지지 않았다. 예를들어 N = 1, K = 3일 때 방법은 총 두가지다. 1 -> 2 -> 3 (+1, +1), 1 -> 2 -> 3 (x2, +1) 그런데 내가 한 방식으로는 방식은 생각하지 않고 경로만 생각해서 1 -> 2 -> 3 한 개로 카운팅이 됐다.  
이를 해결하기 위해서 조건문을 하나 더 추가했다. 도착하게 될 곳의 걸린 시간과 현재까지 걸린 시간 + 1이 같다면, 한 번 더 큐에 넣어줬다.  

숨바꼭질 3, 4도 풀어볼건디 어렵겠찌 ,.. ?
