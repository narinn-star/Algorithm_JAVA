import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14940 {
    static int n, m;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        int startX = 0, startY = 0;

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) {
                    map[i][j] = 0;
                    startX = i;
                    startY = j;
                }
            }
        }

        bfs(startX, startY);

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] == 1 && !visited[i][j])
                    map[i][j] = -1;
                bw.write(map[i][j] + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();

    }
    static void bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        visited[x][y] = true;

        while(!queue.isEmpty()){
            int qX = queue.peek()[0];
            int qY = queue.peek()[1];
            queue.poll();

            for(int i = 0; i < 4; i++){
                int tmpX = qX + dx[i];
                int tmpY = qY + dy[i];

                if(tmpX >= 0 && tmpY >= 0 && tmpX < n && tmpY < m){
                    if(!visited[tmpX][tmpY] && map[tmpX][tmpY] != 0){
                        map[tmpX][tmpY] = map[qX][qY] + 1;
                        queue.add(new int[] {tmpX, tmpY});
                        visited[tmpX][tmpY] = true;
                    }
                }
            }
        }
    }
}
