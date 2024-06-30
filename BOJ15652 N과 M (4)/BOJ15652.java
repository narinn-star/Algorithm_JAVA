import java.io.*;
import java.util.StringTokenizer;

public class BOJ15652 {
    static int N, M;
    static int[] numbers;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[M];

        dfs(0, 1);

        bw.flush();
        bw.close();
    }

    static void dfs(int depth, int start) throws IOException {
        if(depth == M){
            for(int n : numbers) bw.write(n + " ");
            bw.write("\n");
            return;
        }

        for(int i = start; i <= N; i++){
                numbers[depth] = i;
                dfs(depth + 1, i);
        }
    }
}
