import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ21736 {
    static int N, M, cnt = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[][] campus;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        campus = new char[N][M];
        visited = new boolean[N][M];

        int startX = 0, startY = 0;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                campus[i][j] = str.charAt(j);
                if (campus[i][j] == 'I') {
                    startX = i;
                    startY = j;
                }
            }
        }

        bfs(startX, startY);

        if (cnt == 0) {
            bw.write("TT");
        } else {
            bw.write(cnt + "");
        }
        bw.flush();
        bw.close();
    }

    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int qX = queue.peek()[0];
            int qY = queue.peek()[1];
            queue.poll();

            for (int i = 0; i < 4; i++) {
                int tmpX = qX + dx[i];
                int tmpY = qY + dy[i];

                if (tmpX < 0 || tmpY < 0 || tmpX >= N || tmpY >= M || visited[tmpX][tmpY] || campus[tmpX][tmpY] == 'X')
                    continue;

                if (campus[tmpX][tmpY] == 'P') {
                    cnt++;
                }
                queue.add(new int[]{tmpX, tmpY});
                visited[tmpX][tmpY] = true;
            }
        }
    }
}
