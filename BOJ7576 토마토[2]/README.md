# [7576] 토마토

## 분류
> 그래프 이론
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

public class BOJ7576_2 {
    private static int M, N, day = 0;
    private static int dx[] = {-1, 0, 1, 0}; // 상 우 하 좌
    private static int dy[] = {0, 1, 0, -1}; // 상 우 하 좌
    private static int[][] tomato;

    private static Queue<int[]> queue = new LinkedList<int[]>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        tomato = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                tomato[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (tomato[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        bfs();

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (tomato[i][j] == 0) {
                    System.out.println(-1);
                    return;
                } else {
                    if (day < tomato[i][j]) day = tomato[i][j];
                }
            }
        }
        System.out.println(day - 1);
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            int qX = queue.peek()[0];
            int qY = queue.peek()[1];
            queue.poll();

            for (int i = 0; i < 4; i++) {
                int tempX = qX + dx[i];
                int tempY = qY + dy[i];

                if (tempX >= 1 && tempY >= 1 && tempX <= N && tempY <= M) {
                    if (tomato[tempX][tempY] == 0) {
                        queue.add(new int[]{tempX, tempY});
                        tomato[tempX][tempY] = tomato[qX][qY] + 1;
                    }
                }
            }
        }
    }
}

```

## 문제풀이

너비 우선 탐색으로만 풀 수 있는 문제! 

풀면서 고민했던 두가지 문제가 있다.
1. 날짜를 어떻게 세는가?
2. 익은 토마토가 2개 이상일 때 어떻게 동시에 너비 탐색을 하는가?

1. 날짜는 원래 상하좌우를 탐색하고 나서 day++를 해줬다. 당연히 틀림. 왜냐면 토마토 하나가 상하좌우를 다 돌때마다 +1이 되는 것이기 때문에 그냥 단순히 익은 토마토 갯수를 세어주는 것 밖에 안된다. 그래서 생각해 낸 방법은 그냥 토마토 배열에 날짜를 +1씩 해주는 것. 1이 익은 것이니, 그 다음 날엔 1 상하좌우에 있는 토마토가 2가 되는 것이다. 나중에 날짜를 출력할 때 -1을 해주면 되니까, 하루씩 쌓여가는 것은 틀린 로직이 아닌 것을 확인했다.

2. 정말 오래 고민해보고, 계속 예제 3번 즉 익은 토마토가 2개 이상일 때 오류가 나는 것을 고치지 못했다.. 그래서 다른 사람의 코드를 잠깐 봤는데, 정말 단순한 문제였던 것.. bfs의 가장 큰 특징이 큐 내부가 다 빌때까지 반복문을 실행한다는 것이니까 가장 초기에 익어있는 토마토는 모두 큐에 담아주면 되는 것.. 그럼 bfs 함수가 실행되면서 큐에 있는 것들이 선입선출의 원리에 의해 하나씩 순서대로 빠진다. 그러다 보면 숫자가 채워진 부분끼리 만나게 되고, 그 때 bfs가 종료되면 가장 큰 수 -1을 해주면 된다.

익지 않은 토마토는 애초에 bfs에서 tomato[tempX][tempY] == 0인 걸로 조건문을 넣어놨기 때문에 걸러지고 있다는 점~
