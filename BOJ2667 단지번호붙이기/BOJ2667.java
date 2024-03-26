import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2667 {
    private static int N, apartNum = 0;
    private static int home[][];
    private static boolean visited[][];
    private static int dx[] = {-1, 0, 1, 0}; // 상 우 하 좌
    private static int dy[] = {0, 1, 0, -1}; // 상 우 하 좌
    private static ArrayList apart;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        home = new int[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];
        apart = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                home[i][j] = str.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (home[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j);
                    apartNum++; // 단지 수
                }
            }
        }

        Collections.sort(apart);
        System.out.println(apartNum);

        for(int i = 0; i < apart.size(); i++){
            System.out.println(apart.get(i));
        }

    }

    private static void bfs(int a, int b) {
        int cnt = 0;

        Queue<int[]> queue = new LinkedList<int[]>();
        queue.add(new int[]{a, b});
        visited[a][b] = true;

        while (!queue.isEmpty()) {
            int qX = queue.peek()[0];
            int qY = queue.peek()[1];
            queue.poll();

            cnt++;

            for (int i = 0; i < 4; i++) {
                int tempX = dx[i] + qX;
                int tempY = dy[i] + qY;

                if (tempX >= 0 && tempY >= 0 && tempX < N && tempY < N) {
                    if (home[tempX][tempY] == 1 && !visited[tempX][tempY]) {
                        queue.add(new int[]{tempX, tempY});
                        visited[tempX][tempY] = true;

                    }
                }
            }
        }
        apart.add(cnt);
    }
}
