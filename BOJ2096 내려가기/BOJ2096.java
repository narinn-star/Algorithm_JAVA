import java.io.*;
import java.util.StringTokenizer;

public class BOJ2096 {
    static int N;
//    static int min = Integer.MAX_VALUE;
//    static int max = Integer.MIN_VALUE;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        board = new int[N + 1][3];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] max = new int[N + 1][3];
        int[][] min = new int[N + 1][3];

        for(int i = 1; i <= N; i++){
            max[i][0] += Math.max(max[i - 1][0], max[i - 1][1]) + board[i][0];
            max[i][1] += Math.max(Math.max(max[i - 1][0], max[i - 1][1]), max[i - 1][2]) + board[i][1];
            max[i][2] += Math.max(max[i - 1][1], max[i - 1][2]) + board[i][2];

            min[i][0] += Math.min(min[i - 1][0], min[i - 1][1]) + board[i][0];
            min[i][1] += Math.min(Math.min(min[i - 1][0], min[i - 1][1]), min[i - 1][2]) + board[i][1];
            min[i][2] += Math.min(min[i - 1][1], min[i - 1][2]) + board[i][2];
        }

//        for(int i = 0; i < 3; i++){
//            dfs(0, i, board[0][i]);
//        }
        int resMin = Integer.MAX_VALUE;
        int resMax = Integer.MIN_VALUE;

        for(int i = 0; i < 3; i++){
            resMin = Math.min(resMin, min[N][i]);
            resMax = Math.max(resMax, max[N][i]);
        }

        bw.write(resMax + " " + resMin);
        bw.flush();
        bw.close();
        br.close();
    }
//    static void dfs(int depth, int y, int sum) {
//        if (depth == N - 1) {
//            min = Math.min(min, sum);
//            max = Math.max(max, sum);
//            return;
//        }
//
//        if (y == 0) {
//            //아래, 오른쪽 아래
//            dfs(depth + 1, y, sum + board[depth + 1][y]);
//            dfs(depth + 1, y + 1, sum + board[depth + 1][y + 1]);
//        } else if (y == 1) {
//            //왼쪽 아래, 아래, 오른쪽 아래
//            dfs(depth + 1, y - 1, sum + board[depth + 1][y - 1]);
//            dfs(depth + 1, y, sum + board[depth + 1][y]);
//            dfs(depth + 1, y + 1, sum + board[depth + 1][y + 1]);
//        } else if (y == 2){
//            //왼쪽 아래, 아래
//            dfs(depth + 1, y - 1, sum + board[depth + 1][y - 1]);
//            dfs(depth + 1, y, sum + board[depth + 1][y]);
//        }
//    }
}
