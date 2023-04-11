import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2606 {
    static int N, num, cnt = 0;
    static boolean[] check;
    static boolean[][] connect;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        num = Integer.parseInt(br.readLine());
        connect = new boolean[N + 1][N + 1];
        check = new boolean[N + 1];

        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            connect[a][b] = true;
            connect[b][a] = true;
        }

        check[1] = true;
        dfs(1);

        for(int i = 2; i <= N; i++){
            if(check[i]){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
    private static void dfs(int virus){
        for(int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (connect[i][j] && i == virus) {
                    //check[i] = true;
                    check[j] = true;
                    connect[i][j] = false;
                    connect[j][i] = false;
                    dfs(j);
                }
            }
        }
    }
}
