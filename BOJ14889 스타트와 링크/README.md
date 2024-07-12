# [14889] 스타트와 링크

## 분류
> 브루트포스 알고리즘
>
> 백트래킹

## 코드
```java
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ14889 {
    static int N, min = Integer.MAX_VALUE;
    static int[][] ability;
    static boolean[] visited;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N];
        ability = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                ability[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        bw.write(min + "\n");
        bw.flush();
        bw.close();
    }

    static void dfs(int depth, int start) throws IOException{
        if (depth == (N / 2)) {
            int st = 0;
            int li = 0;

            for(int i = 0; i < N; i++){
                for(int j = i + 1; j < N; j++){
                    if(visited[i] && visited[j]){
                        st += ability[i][j];
                        st += ability[j][i];
                    }else if(!visited[i] && !visited[j]){
                        li += ability[i][j];
                        li += ability[j][i];
                    }
                }
            }

            int diff = Math.abs(st - li);

            if(diff == 0){
                bw.write(diff + "\n");
                bw.flush();
                bw.close();

                System.exit(0);
            }

            min = Math.min(min, diff);
            return;
        }

        for (int i = start; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }
}
```

## 문제풀이

N이 4일 때, 팀이 될 수 있는 경우의 수는 다음과 같다.  
1, 2 / 3, 4  
1, 3 / 2, 4  
1, 4 / 2, 3  

한 팀에 값이 N / 2개 들어가면 그 때 S[i][j], S[j][i]를 팀에 더해주면 된다. 그럼 자신과 다르면서 자신보다 큰 값이 다음에 오면 된다. 시작값을 달리 해주기 위해 start라는 파라미터를 추가해주었다. visited에 true로 표시한다는 것은, 한 팀에 true로 표시된 인덱스의 팀원이 들어간다는 것이다. 그래서 depth가 N / 2와 같아질 때 이중 포문에서 각 팀에 [i][j]와 [j][i]를 더해주었다.  
두 팀의 차이가 0일 때는 바로 최솟값이므로 종료해주고, 아닐때는 계속해서 최솟값을 구하도록 했다.

