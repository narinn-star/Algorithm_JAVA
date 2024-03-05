import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1018 {
    public static char board[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int count = 0;
        int max = 64;

        board = new char[N][M];

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < M; j++){
                board[i][j] = str.charAt(j);
            }
        }

        for(int i = 0; i < N-7; i++){
            for(int j = 0; j < M-7; j++){
                count = paint(i, j);
                if(max > count) max = count;
            }
        }
        System.out.println(max);
    }
    public static int paint(int a, int b) {
        String boardSample1[] = {"WBWBWBWB", "BWBWBWBW", "WBWBWBWB", "BWBWBWBW","WBWBWBWB", "BWBWBWBW","WBWBWBWB", "BWBWBWBW"};
        String boardSample2[] = {"BWBWBWBW", "WBWBWBWB", "BWBWBWBW", "WBWBWBWB","BWBWBWBW", "WBWBWBWB","BWBWBWBW", "WBWBWBWB"};
        int cnt1 = 0;
        int cnt2 = 0;

        for(int i = a; i <= a + 7; i++){
            for(int j = b; j <= b + 7; j++){
                if(boardSample1[i-a].charAt(j-b) != board[i][j]) {
                    cnt1++;
                }
                if(boardSample2[i-a].charAt(j-b) != board[i][j]) {
                    cnt2++;
                }
            }
        }
        return Math.min(cnt1, cnt2);
    }
}
