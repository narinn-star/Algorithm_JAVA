import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15651 {
    static int N, M;
    static int[] numbers;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[M];

        dfs(0);

        System.out.print(sb);
    }

    static void dfs(int depth){
        if(depth == M){
            for(int n : numbers) sb.append(n + " ");
            sb.append("\n");
            return;
        }

        for(int i = 1; i <= N; i++){
            numbers[depth] = i;
            dfs(depth + 1);
        }
    }
}
