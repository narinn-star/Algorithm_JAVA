import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ17611 {
    static int[] sumX = new int[1000001];
    static int[] sumY = new int[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken()) + 500000;
        int y = Integer.parseInt(st.nextToken()) + 500000;

        int startX = x;
        int startY = y;

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int curX = Integer.parseInt(st.nextToken()) + 500000;
            int curY = Integer.parseInt(st.nextToken()) + 500000;

            if(x == curX){
                calcY(y, curY);
            }else if(y == curY){
                calcX(x, curX);
            }

            x = curX;
            y = curY;
        }

        if(x == startX)
            calcY(y, startY);
        else
            calcX(x, startX);

        int max = 0;

        for(int i = 0; i < 1000001; i++){
            max = Math.max(max, Math.max(sumX[i], sumY[i]));
        }

        bw.write(max + "");
        bw.flush();
        bw.close();
    }

    static void calcX(int x, int curX){
        if(x > curX){
            for(int i = curX; i < x; i++){
                sumX[i]++;
            }
        }else {
            for(int i = x; i < curX; i++){
                sumX[i]++;
            }
        }
    }
    static void calcY(int y, int curY){
        if(y > curY){
            for(int i = curY; i < y; i++){
                sumY[i]++;
            }
        }else {
            for(int i = y; i < curY; i++){
                sumY[i]++;
            }
        }
    }

}
