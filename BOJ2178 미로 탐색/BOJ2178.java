import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2178 {
    private static int N, M;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int[][] map;
    private static boolean[][] visited;
    private static Queue<int[]> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];

        for(int i = 0; i < N; i++){
            String line = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = line.charAt(j) - '0';
            }
        }

        visited[0][0] = true;
        bfs(0,0);

        System.out.println(map[N-1][M-1]);
    }

    private static void bfs(int x, int y){
        queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        while(!queue.isEmpty()){
            int qX = queue.peek()[0];
            int qY = queue.peek()[1];
            queue.poll();

            for(int i = 0; i < 4; i++){
                int X = qX + dx[i];
                int Y = qY + dy[i];

                if(X >= 0 && Y >= 0 && X < N && Y < M){
                    if(map[X][Y] == 1 && !visited[X][Y]){
                        queue.add(new int[]{X, Y});
                        map[X][Y] = map[qX][qY] + 1;
                        visited[X][Y] = true;
                    }
                }
            }
        }


    }
}
