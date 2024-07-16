import java.io.*;
import java.util.Arrays;

public class BOJ2448 {
    static char[][] stars;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        stars = new char[N][N * 2 - 1];
        for(int i = 0 ; i < N; i++){
            Arrays.fill(stars[i], ' ');
        }

        star(0, N - 1, N);

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N * 2 - 1; j++){
                bw.write(stars[i][j] + "");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
    static void star(int x, int y, int N){
        if(N == 3){
            stars[x][y] = '*';
            stars[x + 1][y - 1] = stars[x + 1][y + 1] = '*';
            stars[x + 2][y - 2] = stars[x + 2][y - 1] = stars[x + 2][y] = stars[x + 2][y + 1] = stars[x + 2][y + 2] = '*';
        }else {
            int newN = N / 2;
            star(x, y, newN);
            star(x + newN, y - newN, newN);
            star(x + newN, y + newN, newN);
        }
    }
}
