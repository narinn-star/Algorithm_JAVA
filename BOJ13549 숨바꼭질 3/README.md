# [13549] 숨바꼭질 3

## 분류
> 그래프 이론
>
> 그래프 탐색
> 
> 너비 우선 탐색
> 
> 데이크스트라
> 
> 최단 경로
> 
> 0-1 너비 우선 탐색

## 코드
```java
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ13549 {
    static int N, K;
    static int[] visitTime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if(N == K){
            bw.write(0 + "");
            bw.flush();
            bw.close();
            return;
        }

        visitTime = new int[100001];

        bfs();

        bw.write(visitTime[K] - 1 + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        visitTime[N] = 1;
        queue.add(N);

        while(!queue.isEmpty()){
            int q = queue.poll();

            if (visitTime[K] != 0) break;

            if (q * 2 < visitTime.length && visitTime[q * 2] == 0) {
                visitTime[q * 2] = visitTime[q];
                queue.add(q * 2);
            }
            if (q - 1 >= 0 && visitTime[q - 1] == 0) {
                visitTime[q - 1] = visitTime[q] + 1;
                queue.add(q - 1);
            }
            if (q + 1 < visitTime.length && visitTime[q + 1] == 0) {
                visitTime[q + 1] = visitTime[q] + 1;
                queue.add(q + 1);
            }
        }
    }
}
```

## 문제풀이

순간이동이 0초로 바뀌어서 처음엔 visitTime[q]에 +1을 해주지 않았는데, 바로 틀려버림 🤯  

첫 날부터 계속 생각해온 반례 하나 (3 1)로 해보니 또 2기 나왓음.. 1이 나와야 정상이다. 왜냐면 1 x 2 + 1 해서 1초가 나오기 때문. 그래서 곱셈 조건문을 첫번째로 올려줬다. 그래야 곱셈이 먼저 되니까. 그래도 계속 1이 나오는 매직 🪄  
아마 첫 값을 0으로 넣어둬서 x2를 해도 visitTime에 계속 문제가 있었던 것 같다. 그래서 1부터 시작해주고 -1을 해줌.. 정답 ~ 

총 4번이나 시도했던,, 문제
