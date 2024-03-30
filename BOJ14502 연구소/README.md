# [14502] 퇴사

## 분류
> 구현
>
> 그래프 이론
> 
> 브루트포스 알고리즘
> 
> 그래프 탐색
> 
> 너비 우선 탐색

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14502 {
    private static int N, M, res = 0;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int[][] region, wallRegion, virus;
    private static Queue<int[]> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        region = new int[N][M];
        wallRegion = new int[N][M];
        virus = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                wallRegion[i][j] = Integer.parseInt(st.nextToken());
                region[i][j] = wallRegion[i][j];
            }
        }

        wall(0);

        System.out.println(res);

    }

    private static void wall(int cnt) {
        int regionCount = 0;

        if(cnt == 3){
            bfs();

            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(virus[i][j] == 0){
                        regionCount++;
                    }
                }
            }
            res = Math.max(res, regionCount);

            return;
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(wallRegion[i][j] == 0){
                    wallRegion[i][j] = 1;
                    wall(cnt + 1);
                    wallRegion[i][j] = 0;
                }
            }
        }
    }

    private static void bfs(){
        queue = new LinkedList<>();

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                virus[i][j] = wallRegion[i][j];
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(virus[i][j] == 2){
                    queue.add(new int[]{i, j});
                }
            }
        }

        while(!queue.isEmpty()){
            int qX = queue.peek()[0];
            int qY = queue.peek()[1];
            queue.poll();

            for(int i = 0; i < 4; i++){
                int X = qX + dx[i];
                int Y = qY + dy[i];

                if(X >= 0 && Y >= 0 && X < N && Y < M){
                    if(virus[X][Y] == 0){
                        virus[X][Y] = 2;
                        queue.add(new int[]{X,Y});
                    }
                }
            }
        }
    }
}
```

## 문제풀이
1. 벽 세개 세우기
2. 바이러스 다 전파시키기
3. 빈칸 세기
4. 최댓값 구하기

간단하게 풀이 순서를 적어봤다. 문제는 간단히 풀지 못했지만 ...

1. 벽을 세개 세우기 전에, 한참 고민했다. 전체 다 돌면서 3개씩 넣는 것이 맞는가에 대하여.. 근데 이 방법 말고는 3개를 넣을 수 있는 방법이 없다고 생각해서, 일단 넣었다. 벽을 세우다가 3개 모두 세워지면 영역을 세어야하기 때문에, 벽 갯수를 담은 벽세우기 함수를 재귀호출 했다. 3개를 모두 세웠다면 bfs로 바이러스를 전파시키고, 3개까지는 계속해서 벽을 세우는 것이다. 그리고 재귀를 탈출할 때에는 다음 3개를 또 세워야하기 때문에 0으로 다시 돌려두었다.

2. 바이러스를 전파시키는 건 bfs으로 풀었다. 큐에 넣기 전에, 여러번 탐색해야하기 때문에 virus 배열을 하나 더 만들어서 복사해주었다. 그리고 그 값이 2일 때 큐에 담아두고 bfs를 시작했다.

3. bfs를 다 돌고오면 감염되지 않은 공간, 빈칸을 세어주고
4. 계속해서 최댓값을 갱신해주었다.

이 로직을 생각해내기까지 정말 오래 걸렸다.. 어찌저찌 풀어내긴 했지만, 완전탐색이 들어가있으면 항상 '이게 맞나'라는 의문이 먼저 들긴 한다. 일단 무지성으로 풀어보자 해서 풀어낸건데, 맞긴 하더라..

추가적으로, 자바에는 배열을 clone할 수 있는 함수가 있다. 

```java
for(int i = 0; i < N; i++){
    for(int j = 0; j < M; j++){
        virus[i][j] = wallRegion[i][j];
    }
}
        
for(int i = 0; i < N; i++){
    virus[i] = wallRegion[i].clone();
}
```

그리고 내 코드에서는 배열이 총 세개 선언되어 있는데 region 배열은 저래놓고 쓰지도 않고 있음.. 지워도 됨... 그리고 bfs에서도 복사하고 큐에 집어넣는 작업을 한 반복문 내에서 바로 다 처리해도 될 것 같다. 반복문이 우다다닥 너무 많아요.
