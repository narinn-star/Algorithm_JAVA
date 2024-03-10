import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1010 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int array[][] = new int[30][30];

        for (int i = 0; i < 30; i++) {
                array[i][i] = 1;
                array[i][0] = 1;
        }

        for (int i = 2; i < 30; i++) {
            for(int j = 1; j < 30; j++){
                array[i][j] = array[i - 1][j - 1] + array[i-1][j];
            }
        }

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            System.out.println(array[M][N]);
        }
    }
}
