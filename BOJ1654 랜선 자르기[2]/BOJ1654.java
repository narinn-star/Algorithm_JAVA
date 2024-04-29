import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] ys = new int[K];

        long low = 1, high = 0;

        for(int i = 0; i < K; i++){
            ys[i] = Integer.parseInt(br.readLine());
            if(high < ys[i]) high = ys[i];
        }

        high++;

        while(low < high){
            long mid = (low + high) / 2;
            long cnt = 0;

            for(int i = 0; i < K; i++){
                cnt += (ys[i] / mid);
            }

            if(cnt >= N) low = mid + 1;
            else high = mid;
        }

        System.out.println(low - 1);
    }
}
