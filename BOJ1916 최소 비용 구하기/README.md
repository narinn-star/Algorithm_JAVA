# [1916] 최소 비용 구하기

## 분류
> 그래프 이론
>
> 데이크스트라
> 
> 최단 경로

## 코드
```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.*;

public class BOJ1916 {
    static class Bus {
        int end;
        int cost;
        Bus(int end, int cost){
            this.end = end;
            this.cost = cost;
        }
    }
    private static int[] res;
    private static boolean[] visited;
    private static ArrayList<ArrayList<Bus>> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        list = new ArrayList<>();

        for(int i = 0; i <= N; i++){
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list.get(start).add(new Bus(end, cost));
        }

        visited = new boolean[N + 1];
        res = new int[N + 1];
        Arrays.fill(res, Integer.MAX_VALUE);

        st = new StringTokenizer(br.readLine());
        int resStart = Integer.parseInt(st.nextToken());
        int resEnd = Integer.parseInt(st.nextToken());

        dijkstra(resStart);

        bw.write(res[resEnd] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
    private static void dijkstra(int resStart){
        PriorityQueue<Bus> queue = new PriorityQueue<>((q1, q2) -> q1.cost - q2.cost);
        queue.add(new Bus(resStart, 0));
        res[resStart] = 0;

        while(!queue.isEmpty()){
            Bus now = queue.poll();
            int nowEnd = now.end;

            if(!visited[nowEnd]){
                visited[nowEnd] = true;
                for(Bus bus : list.get(nowEnd)){
                    if(!visited[bus.end] && res[bus.end] > res[nowEnd] + bus.cost){
                        res[bus.end] = res[nowEnd] + bus.cost;
                        queue.add(new Bus(bus.end, res[bus.end]));
                    }
                }
            }
        }
    }
}
```

## 문제풀이

이제 시간 제한을 신경쓰게 됐다.. 0.5초라고 해서 바로 인접리스트를 선택했고, 읽고 쓰는 것 모두 버퍼를 사용했다. 그래서인지 일단 첫 제출 때 틀리긴 했지만 메모리초과나 시간초과는 없었다.

손으로 직접 그려봤을 때 너비탐색으로 해야겠다 생각해서 바로 방문여부를 체크할 배열과 큐를 만들어줬다. 출발지점과 현재 최소비용을 넣은 객체를 큐에 넣으면서 시작한다. (출발지점이 곧 도착지점)
큐에 있는 값을 꺼내 현재 가야할 도착지점을 저장해주고, 만약 가지 않았던 지점이라면 방문 여부를 체크해주고 최소비용을 구해준다.
최소비용을 구할 땐 다음 도착지점의 방문 여부를 체크함과 동시에 그 도착 지점의 최소비용이(현재까지 구해진 비용) 다음 도착지점까지의 비용을 더한 값을 비교해서 최소비용을 선택해준다. 말로 푸니까 엄청 복잡해보이긴 한데, 단순히 두 값을 비교해서 더 작은 값을 선택해준 것. 그리고 큐에 도착지점과 최소비용을 넣은 객체를 넣어주면 된다.

제출 전에 반례를 찾아서 실행했는데, 정확하게 틀린 답이 나왔다. 보려고 본 건 아니지만 아래에 작게 '우선순위 큐'를 사용하는 힌트가 나와있어서, 곰곰히 생각해보니 우선순위 큐를 사용하면 정렬이 쉽게 가능했다. 바로 Queue에서 PriorityQueue로 수정하고 람다식으로 정렬까지 해줬더니 맞았다.
