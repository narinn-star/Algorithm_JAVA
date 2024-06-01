import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2578 {
    private static int[][] bingo, input;
    private static int bingoCnt, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        bingo = new int[5][5];
        input = new int[5][5];
        cnt = 0;
        bingoCnt = 0;

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                bingo[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                input[i][j] = Integer.parseInt(st.nextToken());

                check(input[i][j]);

                if (bingoCnt >= 3) {
                    System.out.println(cnt);
                    return;
                }
            }
        }
    }

    private static void check(int num) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (num == bingo[i][j]) {
                    bingo[i][j] = -1;
                    cnt++;
                }
            }
        }

        bingoCnt = 0;
        horizontalCheck();
        verticalCheck();
        diagonalLeftCheck();
        diagonalRightCheck();
    }

    private static void horizontalCheck() {
        for (int i = 0; i < 5; i++) {
            int tmpCnt = 0;
            for (int j = 0; j < 5; j++) {
                if (bingo[i][j] == -1) tmpCnt++;
            }
            if (tmpCnt == 5) bingoCnt++;
        }
    }

    private static void verticalCheck() {
        for (int i = 0; i < 5; i++) {
            int tmpCnt = 0;
            for (int j = 0; j < 5; j++) {
                if (bingo[j][i] == -1) tmpCnt++;
            }
            if (tmpCnt == 5) bingoCnt++;
        }
    }

    private static void diagonalLeftCheck() {
        int tmpCnt = 0;
        for (int i = 0; i < 5; i++) {
            if (bingo[i][i] == -1) tmpCnt++;
        }
        if (tmpCnt == 5) bingoCnt++;
    }

    private static void diagonalRightCheck() {
        int tmpCnt = 0;
        for (int i = 0; i < 5; i++) {
            if (bingo[i][4 - i] == -1) tmpCnt++;
        }
        if (tmpCnt == 5) bingoCnt++;
    }
}
