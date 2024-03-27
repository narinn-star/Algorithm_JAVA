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
    ;

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
