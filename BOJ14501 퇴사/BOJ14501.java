import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14501 {
    public static int N;
    public static int T[];
    public static int P[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        T = new int[N];
        P = new int[N];
        int dp[] = new int[N+1]; // N일의 최대 수익

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken()); // 기간
            P[i] = Integer.parseInt(st.nextToken()); // 금액
        }

        for(int i = 0; i < N; i++){
                if(i + T[i] <= N){  // 날짜가 N을 넘지 않으면
                    dp[i + T[i]] = Math.max(dp[i + T[i]], dp[i] + P[i]);
                }
                dp[i+1] = Math.max(dp[i + 1], dp[i]);
        }
        System.out.println(dp[N]);
    }
}
