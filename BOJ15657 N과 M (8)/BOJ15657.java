import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15657 {
    static int N, M;
    static int[] inputArr, numbers;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        inputArr = new int[N];
        numbers = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            inputArr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(inputArr);

        dfs(0, 0);

        bw.flush();
        bw.close();
    }

    static void dfs(int depth, int root) throws IOException {
        if (depth == M) {
            for (int n : numbers) bw.write(n + " ");
            bw.write("\n");
            return;
        }

        for (int i = root; i < N; i++) {
            numbers[depth] = inputArr[i];
            dfs(depth + 1, i);
        }
    }
}
