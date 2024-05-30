import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ5212 {
    private static int R, C;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static char[][] map, resMap;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int minR = R, minC = C, maxR = 0, maxC = 0;
        map = new char[R][C];
        resMap = new char[R][C];

        for(int i = 0; i < R; i++){
            String line = br.readLine();
            for(int j = 0; j < C; j++){
                map[i][j] = line.charAt(j);
            }
        }

        for(int i = 0; i < R; i++){
            Arrays.fill(resMap[i], '.');
        }

        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(map[i][j] == 'X'){
                    int islandCnt = 0;
                    for(int k = 0; k < 4; k++){
                        int X = i + dx[k];
                        int Y = j + dy[k];

                        if(X < R && Y < C && X >= 0 && Y >= 0 && map[X][Y] == 'X') islandCnt++;
                    }
                    if(islandCnt >= 2) resMap[i][j] = 'X';
                }
                if(resMap[i][j] == 'X'){
                    minR = Math.min(i, minR);
                    minC = Math.min(j, minC);
                    maxR = Math.max(i, maxR);
                    maxC = Math.max(j, maxC);
                }
            }
        }

        for(int i = minR; i <= maxR; i++){
            for(int j = minC; j <= maxC; j++){
                 System.out.print(resMap[i][j]);
            }
            System.out.println();
        }
    }
}
