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
import java.util.StringTokenizer;

public class BOJ2606 {
    static int N, num, cnt = 0;
    static boolean[] check;
    static boolean[][] connect;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        num = Integer.parseInt(br.readLine());
        connect = new boolean[N + 1][N + 1];
        check = new boolean[N + 1];

        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            connect[a][b] = true;
            connect[b][a] = true;
        }

        check[1] = true;
        dfs(1);

        for(int i = 2; i <= N; i++){
            if(check[i]){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
    private static void dfs(int virus){
        for(int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (connect[i][j] && i == virus) {
                    //check[i] = true;
                    check[j] = true;
                    connect[i][j] = false;
                    connect[j][i] = false;
                    dfs(j);
                }
            }
        }
    }
}
```

## 문제풀이

일단 배열로 visited 체크(여기서는 연결 되어있음을 체크) 해주기 위해 이차원 배열로 만들어줬다. 
감염된 컴퓨터 갯수를 체크해줄 check 배열도 만들었다.

입력이 3 4 라면 어차피 두 개가 이어져있는 것이고, 그래프로 생각하면 무방향이기 때문에 3 4, 4 3 둘 다 연결되어 있음을 true로 바꿨다.
1번 컴퓨터는 무조건 감염되어 있으니까 true로 미리 바꿔두고 dfs함수를 호출해야한다.
지금 보니 dfs 함수 내에 check[i] = true 는 없어도 될듯하다. 어차피 앞에 있는 컴퓨터가 뒤 컴퓨터를 감염시키는 것이기 때문에, 새로 감염된 컴퓨터는 j가 되기 때문!

분명히 실버2는 엄청 어려워서 포기하고 이걸 먼저 푼 것인데.. 왠지 이제 실버2도 풀 수 있을 것 같은 느낌!!!!!!!!
