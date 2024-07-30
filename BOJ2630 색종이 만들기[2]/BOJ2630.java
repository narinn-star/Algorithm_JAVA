import java.io.*;
import java.util.StringTokenizer;

public class BOJ2630 {
    static int white = 0, blue = 0;
    static int[][] paper;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        paper = new int[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        newPaper(0, 0, N);

        bw.write(white + "\n" + blue);
        bw.flush();
        bw.close();
        br.close();
    }

    static void newPaper(int x, int y, int size){
        if(check(x, y, size)){
            if(paper[x][y] == 0){
                white++;
            }else{
                blue++;
            }
            return;
        }

        int newSize = size / 2;

        newPaper(x, y, newSize);
        newPaper(x, y + newSize, newSize);
        newPaper(x + newSize, y, newSize);
        newPaper(x + newSize, y + newSize, newSize);
    }

    static boolean check(int x, int y, int size){
        int color = paper[x][y];

        for(int i = x; i < x + size; i++){
            for(int j = y; j < y + size; j++){
                if(paper[i][j] != color) return false;
            }
        }

        return true;
    }
}
