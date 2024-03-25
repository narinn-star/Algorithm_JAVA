import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1012 {
    private static int T, M, N, K;
    private static int cabbage[][];
    private static boolean check[][];

    private static int x[] = {-1, 0, 1, 0}; // 상 우 하 좌
    private static int y[] = {0, 1, 0, -1}; // 상 우 하 좌

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        while (T-- != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int cnt = 0;

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            cabbage = new int[M + 1][N + 1];
            check = new boolean[M+1][N+1];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                cabbage[a][b] = 1;
            }

            for(int i = 0; i < M; i++){
                for(int j = 0; j < N; j++){
                    if(cabbage[i][j] == 1 && !check[i][j]){
                        bfs(i, j);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    private static void bfs(int a, int b){
        check[a][b] = true;

        for (int i = 0; i < 4; i++){
            int tempX = a + x[i];
            int tempY = b + y[i];

            if(tempX >= 0 && tempY >= 0 && tempX < M && tempY < N){
                if(cabbage[tempX][tempY] == 1 && !check[tempX][tempY]){
                    bfs(tempX, tempY);
                }
            }
        }

    }
}
