import java.io.*;
import java.util.StringTokenizer;

public class BOJ1987 {
    static int R, C, max = Integer.MIN_VALUE;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[][] alpha;
    static boolean[] alphaVisited = new boolean[26];
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        alpha = new char[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                alpha[i][j] = line.charAt(j);
            }
        }

        alphaVisited[alpha[0][0] - 65] = true;
        alpha[0][0] = 'a';
        dfs(0, 0, 1);
        bw.write(max + "\n");
        bw.flush();
        bw.close();
    }

    static void dfs(int x, int y, int depth) {

        for (int i = 0; i < 4; i++) {
            int tmpX = x + dx[i];
            int tmpY = y + dy[i];
            if (tmpX >= 0 && tmpY >= 0 && tmpX < R && tmpY < C) {
                char tmpChar = alpha[tmpX][tmpY];
                if (tmpChar != 'a' && !alphaVisited[tmpChar - 65] ) {
                    alphaVisited[tmpChar - 65] = true;
                    alpha[tmpX][tmpY] = 'a';
                    dfs(tmpX, tmpY, depth + 1);
                    alphaVisited[tmpChar - 65] = false;
                    alpha[tmpX][tmpY] = tmpChar;
                }
            }
        }
        max = Math.max(max, depth);
    }
}
