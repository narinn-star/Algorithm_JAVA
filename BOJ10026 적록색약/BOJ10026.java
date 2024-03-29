import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ10026 {
    private static int N;
    private static int generalCnt, disabledCnt;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static char[][] grid;
    private static boolean[][] visited;
    private static Queue<int[]> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        grid = new char[N + 1][N + 1];
        visited = new boolean[N+1][N+1];
        generalCnt = disabledCnt = 0;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                grid[i][j] = line.charAt(j);
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j]){
                    bfs(i, j, grid[i][j]);
                    generalCnt++;
                }
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(grid[i][j] == 'R') grid[i][j] = 'G';
            }
        }

        visited = new boolean[N+1][N+1];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j]){
                    bfs(i, j, grid[i][j]);
                    disabledCnt++;
                }
            }
        }

        System.out.println(generalCnt + " " + disabledCnt);
    }

    private static void bfs(int x, int y, char c) {
        queue = new LinkedList<>();
        visited[x][y] = true;
        queue.add(new int[]{x, y});

        while(!queue.isEmpty()){
            int X = queue.peek()[0];
            int Y = queue.peek()[1];
            queue.poll();

            for(int i = 0; i < 4; i++){
                int tempX = dx[i] + X;
                int tempY = dy[i] + Y;

                if(tempX >= 0 && tempY >= 0 && tempX < N && tempY < N){
                    if(grid[tempX][tempY] == c && !visited[tempX][tempY]){
                        visited[tempX][tempY] = true;
                        queue.add(new int[]{tempX, tempY});
                        bfs(tempX ,tempY, c);
                    }
                }
            }
        }
    }
}
