import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14503 {
    static int N, M, r, c, d, cnt = 1;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        clean(r, c, d);
        System.out.println(cnt);
    }

    private static void clean(int x, int y, int direction){
        map[x][y] = -1;

        for(int i = 0; i < 4; i++){
            direction = (direction + 3) % 4; // 방향 전환
            int X = x + dx[direction];
            int Y = y + dy[direction];

            if(X >= 0 && Y >= 0 && X < N && Y < M){
                if(map[X][Y] == 0){
                    cnt++;
                    clean(X, Y, direction);

                    return;
                }
            }
        }

        int backDir = (direction + 2) % 4; // 후진 방향
        int backX = x + dx[backDir];
        int backY = y + dy[backDir];

        if(backX >= 0 && backY >= 0 && backX < N && backY < M){
            if(map[backX][backY] != 1){
                clean(backX, backY, direction);
            }
        }
    }

}
