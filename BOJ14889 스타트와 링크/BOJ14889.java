import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ14889 {
    static int N, min = Integer.MAX_VALUE;
    static int[][] ability;
    static boolean[] visited;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N];
        ability = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                ability[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        bw.write(min + "\n");
        bw.flush();
        bw.close();
    }

    static void dfs(int depth, int start) throws IOException{
        if (depth == (N / 2)) {
            int st = 0;
            int li = 0;

            for(int i = 0; i < N; i++){
                for(int j = i + 1; j < N; j++){
                    if(visited[i] && visited[j]){
                        st += ability[i][j];
                        st += ability[j][i];
                    }else if(!visited[i] && !visited[j]){
                        li += ability[i][j];
                        li += ability[j][i];
                    }
                }
            }

            int diff = Math.abs(st - li);

            if(diff == 0){
                bw.write(diff + "\n");
                bw.flush();
                bw.close();

                System.exit(0);
            }

            min = Math.min(min, diff);
            return;
        }

        for (int i = start; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }
}
