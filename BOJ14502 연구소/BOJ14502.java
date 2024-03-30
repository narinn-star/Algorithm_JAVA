import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14502 {
    private static int N, M, res = 0;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int[][] region, wallRegion, virus;
    private static Queue<int[]> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        region = new int[N][M];
        wallRegion = new int[N][M];
        virus = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                wallRegion[i][j] = Integer.parseInt(st.nextToken());
                region[i][j] = wallRegion[i][j];
            }
        }

        wall(0);

        System.out.println(res);

    }

    private static void wall(int cnt) {
        int regionCount = 0;

        if(cnt == 3){
            bfs();

            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(virus[i][j] == 0){
                        regionCount++;
                    }
                }
            }
            res = Math.max(res, regionCount);

            return;
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(wallRegion[i][j] == 0){
                    wallRegion[i][j] = 1;
                    wall(cnt + 1);
                    wallRegion[i][j] = 0;
                }
            }
        }
    }

    private static void bfs(){
        queue = new LinkedList<>();

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                virus[i][j] = wallRegion[i][j];
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(virus[i][j] == 2){
                    queue.add(new int[]{i, j});
                }
            }
        }

        while(!queue.isEmpty()){
            int qX = queue.peek()[0];
            int qY = queue.peek()[1];
            queue.poll();

            for(int i = 0; i < 4; i++){
                int X = qX + dx[i];
                int Y = qY + dy[i];

                if(X >= 0 && Y >= 0 && X < N && Y < M){
                    if(virus[X][Y] == 0){
                        virus[X][Y] = 2;
                        queue.add(new int[]{X,Y});
                    }
                }
            }
        }
    }
}
