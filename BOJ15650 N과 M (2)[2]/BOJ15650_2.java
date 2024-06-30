import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15650_2 {
    static int N, M;
    static int[] numbers;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[M];

        dfs(0, 1);
    }

    static void dfs(int depth, int root){
        if(depth == M){
            for(int n : numbers){
                System.out.print(n + " ");
            }
            System.out.println();
            return;
        }

        for(int i = root; i <= N; i++){
                numbers[depth] = i;
                dfs(depth + 1, i + 1);

        }
    }
}
