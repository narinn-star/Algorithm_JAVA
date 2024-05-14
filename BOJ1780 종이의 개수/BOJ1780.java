import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1780 {
    private static int N;
    private static int oneCnt, minusCnt, zeroCnt;
    private static int[][] paper;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        oneCnt = 0;
        minusCnt = 0;
        zeroCnt = 0;
        paper = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        countPaper(0, 0, N);
        System.out.println(minusCnt);
        System.out.println(zeroCnt);
        System.out.println(oneCnt);
    }

    private static void countPaper(int x, int y, int size) {
        if (checkPaper(x, y, size)) {
            if (paper[x][y] == 0) zeroCnt++;
            else if (paper[x][y] == -1) minusCnt++;
            else if (paper[x][y] == 1) oneCnt++;
            return;
        }

        int newSize = size / 3;
        for(int i = x; i < x + size; i += newSize){
            for(int j = y; j < y + size; j += newSize){
                countPaper(i, j, newSize);
            }
        }
    }

    private static boolean checkPaper(int x, int y, int size){
        for (int i = x; i < x + size; i ++) {
            for (int j = y; j < y + size; j ++) {
                if (paper[i][j] != paper[x][y]) {
                    return false;
                }
            }
        }
        return true;
    }
}
