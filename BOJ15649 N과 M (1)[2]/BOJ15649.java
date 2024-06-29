import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15649 {
    static int N, M;
    static int[] numbers;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[M];
        visited = new boolean[N + 1];

        dfs(0);
    }

    static void dfs(int n){
        if(n == M) {
            for(int i : numbers) System.out.print(i + " ");
            System.out.println();
            return;
        }

        for(int i = 1; i <= N; i++){
            if(!visited[i]) {
                numbers[n] = i;
                visited[i] = true;
                dfs(n + 1);
                visited[i] = false;
            }
        }
    }
}
