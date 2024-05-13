import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ10994 {
    private static char[][] star;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int len = 1 + 4 *(N - 1);
        star = new char[len][len];

        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                star[i][j] = ' ';
            }
        }

        fillStar(0, len);

        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                System.out.print(star[i][j]);
            }
            System.out.println();
        }
    }

    private static void fillStar(int n, int len){
        if(len <= n) return;

        for(int i = n; i < len; i++){
            star[n][i] = '*'; // 상
            star[i][n] = '*'; // 좌
            star[len - 1][i] = '*'; // 하
            star[i][len - 1] = '*'; // 우
        }

        fillStar(n + 2, len - 2);
    }
}
