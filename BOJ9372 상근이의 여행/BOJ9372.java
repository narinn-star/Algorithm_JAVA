import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ9372 {
    private static int N, M, res;
    private static boolean[] visited;
    private static int[][] plain;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            res = 0;

            plain = new int[N + 1][N + 1];
            visited = new boolean[N + 1];

            for(int i = 0; i < M; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                plain[a][b] = 1;
                plain[b][a] = 1;
            }

            bfs();
            System.out.println(res - 1);
        }
    }

    private static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;

        while(!queue.isEmpty()){
            res++;
            int value = queue.poll();

            for(int i = 1; i <= N; i++){
                if(plain[value][i] != 0 && !visited[i]){
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
