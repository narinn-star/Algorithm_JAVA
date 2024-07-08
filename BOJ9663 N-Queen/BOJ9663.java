import java.io.*;

public class BOJ9663 {
    static int N, sum;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            visited = new boolean[N][N];
            visited[0][i] = true;
            dfs(1);
        }

        bw.write(sum + "\n");
        bw.flush();
        bw.close();
    }

    static void dfs(int depth) {
        if (depth == N) {
            sum++;
            return;
        }

        for (int j = 0; j < N; j++) {
            if (checkQueens(j, depth)) {
                visited[depth][j] = true;
                dfs(depth + 1);
                visited[depth][j] = false;
            }
        }
    }

    static boolean checkQueens(int x, int depth) {
        for (int i = 0; i < depth; i++) {
            if (visited[i][x]) return false;
        }

        int tmpX = x - 1;
        int tmpY = depth - 1;

        while (tmpX >= 0 && tmpY >= 0) {
            if (visited[tmpY--][tmpX--]) return false;
        }

        tmpX = x + 1;
        tmpY = depth - 1;
        while (tmpX < N && tmpY >= 0) {
            if (visited[tmpY--][tmpX++]) return false;
        }

        return true;
    }
}
