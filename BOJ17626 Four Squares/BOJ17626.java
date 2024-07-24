import java.io.*;

public class BOJ17626 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];
        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i <= N; i++){
            int min = Integer.MAX_VALUE;
            for(int j = 1; j * j <= i; j++){
                int tmp = i - j * j;
                min = Math.min(min, dp[tmp]);
            }
            dp[i] = min + 1;
        }

        bw.write(dp[N] + "");
        bw.flush();
        bw.close();
        br.close();
    }
}

//        dp[1] = 1;  // 1
//        dp[2] = dp[1 * 1] + 1; // 2
//        dp[2] = dp[1 * 1] + dp[2 - 1 * 1];
//        dp[3] = dp[1 * 1] + dp[3 - 1 * 1]; // 3
//        dp[4] = dp[2 * 2] + dp[4 - 2 * 2]; // 1
//        dp[5] = dp[2 * 2] + dp[5 - 2 * 2]; // 2
//        dp[6] = dp[2 * 2] + dp[6 - 2 * 2]; // 3
//        dp[7] = dp[2 * 2] + dp[7 - 2 * 2]; // 4
//dp[8] = dp[2 * 2] + dp[8 - 2 * 2]; // 2
//        dp[9] = dp[3 * 3]; // 1
//        dp[10] = dp[3 * 3] + dp[10 - 3 * 3]; // 2
//dp[11] = dp[3 * 3] + dp[11 - 3 * 3]; // 3
//        dp[12] = dp[3 * 3] + dp[12 - 3 * 3]; // 4
//예외
//dp[12] = dp[2 * 2] + dp[2 * 2] + dp[2 * 2];
//dp[12] = dp[2 * 2] + dp[12 - 2 * 2];
//dp[12] = dp[2 * 2] + dp[8];
//dp[23] = dp[4 * 4] + dp[23 - 4 * 4]; // 5;
//예외
//dp[23] = dp[3 * 3] + dp[3 * 3] + dp[2 * 2] + dp[1 * 1]; // 4