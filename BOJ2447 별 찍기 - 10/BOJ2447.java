import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2447 {
    private static int N;
    private static String[][] star;
    private static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        star = new String[N][N];
        sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            Arrays.fill(star[i], " ");
        }

        printStar(0,0, N);

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                sb.append(star[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void printStar(int x, int y, int size){
        if (size == 1) {
            star[x][y] = "*";
            return;
        }
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(i == 1 && j == 1) continue;
                printStar(x + i * (size / 3), y + j  * (size / 3), size / 3);
            }
        }
    }
}
