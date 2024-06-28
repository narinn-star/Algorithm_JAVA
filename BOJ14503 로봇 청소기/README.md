# [14503] 로봇 청소기

## 분류
> 구현
>
> 시뮬레이션

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14503 {
    static int N, M, r, c, d, cnt = 1;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        clean(r, c, d);
        System.out.println(cnt);
    }

    private static void clean(int x, int y, int direction){
        map[x][y] = -1;

        for(int i = 0; i < 4; i++){
            direction = (direction + 3) % 4; // 방향 전환
            int X = x + dx[direction];
            int Y = y + dy[direction];

            if(X >= 0 && Y >= 0 && X < N && Y < M){
                if(map[X][Y] == 0){
                    cnt++;
                    clean(X, Y, direction);

                    return;
                }
            }
        }

        int backDir = (direction + 2) % 4; // 후진 방향
        int backX = x + dx[backDir];
        int backY = y + dy[backDir];

        if(backX >= 0 && backY >= 0 && backX < N && backY < M){
            if(map[backX][backY] != 1){
                clean(backX, backY, direction);
            }
        }
    }

}

```

## 문제풀이

오랜만에 정말 정말 복잡한(?) 구현 문제를 풀었다. 1시간은 집중 안하면서 풀었고, 1시간 집중해서 풀었는데 계속 두번째 예제가 59가 나와서 진짜 포기해버릴까 했다... 디버깅하기 너무 어렵고 예제가 너무 갑자기 커져버려서 하고싶지 않았던 ... 무튼 풀이는 다음과 같다.

먼저 이 문제를 보고 dfs를 바로 생각해낸 나 자신 아주 칭찬해🥹 계속해서 타고 가면서 후진을 어떻게 해주고 회전을 어떻게 하느냐가 포인트였다. 북 동 남 서 순서로 0 1 2 3을 나타내기 때문에 현재 바라보고 있는 방향 값 + 3을 해준 다음 4로 나눈 나머지를 다음 방향으로 넣어줬다. 후진은 + 2를 해준 다음 4로 나눈 나머지를 후진 방향으로 넣었다.
회전 후에 한칸 전진할 때는 4방향을 모두 탐색을 먼저 해주고 하던 중에 청소되지 않은 곳을 만나면 바로 전진해서 청소하면 된다. 

후진은 네 방향을 모두 돌았을 때 청소할 필요가 없을 경우에 하는 것이므로, for문으로 위에서 4방향을 탐색을 다 했음에도 clean 함수를 못 탔을 경우에 수행된다. 그렇기 때문에 바라보고 있는 방향 값 그대로 나올것이므로 그대로 + 2를 해준 후 4로 나눈 나머지를 후진 방향으로 넣어주면 된다. 방향 전환을 하던 중에 나올 일은 없어야 한다. 그리고 후진은 어차피 방향을 정해뒀기 때문에 탐색할 필요 없이 후진 가능 여부만 확인하면 된다. 후진해서 청소를 할지 안할지는 다시 clean 함수로 들어가 4방향을 확인하면서 정할 것이므로 여기까지만 해주면 알아서 돌아간다는 점. 

그리고 59가 나왔던 이유는 for문 내에 return을 해주지 않았기 때문이었다. return이 없으면 중간에 뒤로 가버려서 다른 곳을 청소하게 되어 로직에 오류가 생기는 것이었다. 정말 당연한건데, 아주 자연스럽게 놓쳐버렸다는 ..

골드 5밖에 안되는 구현문제인데 역시나 너무너무너무너무너무 어려웠고,, 그래도 재밌었다.
