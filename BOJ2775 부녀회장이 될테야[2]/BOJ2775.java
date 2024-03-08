import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2775 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int array[][] = new int[15][15];

        for (int i = 0; i < 15; i++) {
            array[0][i] = i; // 0층 i호
            array[i][1] = 1; // i층 1호
        }

        for (int i = 1; i < 15; i++) {
            for (int j = 2; j < 15; j++) {
                array[i][j] = array[i][j - 1] + array[i - 1][j];
            }
        }

        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            System.out.println(array[k][n]);
        }
    }
}
