import java.io.*;
import java.util.StringTokenizer;

public class BOJ6603 {
    static int k;
    static int[] lotto, result;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st = new StringTokenizer(br.readLine());

            k = Integer.parseInt(st.nextToken());

            if (k == 0) break;

            lotto = new int[k];
            result = new int[6];

            for (int i = 0; i < k; i++) {
                lotto[i] = Integer.parseInt(st.nextToken());
            }
            dfs(0, 0);

            bw.write("\n");
            bw.flush();
        }
        bw.close();
    }

    static void dfs(int depth, int start) throws IOException {
        if (depth == 6) {
            for (int r : result) bw.write(r + " ");
            bw.write("\n");
            return;
        }

        for (int i = start; i < lotto.length; i++) {
            result[depth] = lotto[i];
            dfs(depth + 1, i + 1);
        }
    }
}
