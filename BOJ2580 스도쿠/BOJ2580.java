import java.io.*;
import java.util.StringTokenizer;

public class BOJ2580 {
    static int[][] sudoku;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        sudoku = new int[9][9];

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);


    }

    static void dfs(int x, int y) throws IOException {
        if(y == 9){
            dfs(x + 1, 0);
            return;
        }

        if(x == 9){
            for(int i = 0; i < 9; i++){
                for(int j = 0; j < 9; j++){
                    bw.write(sudoku[i][j] + " ");
                }
                bw.write("\n");
            }
            bw.flush();
            bw.close();
            System.exit(0);
        }

        if(sudoku[x][y] == 0){
            for(int i = 1; i <= 9; i++){
                if(check(x, y, i)){
                    sudoku[x][y] = i;
                    dfs(x, y + 1);
                }
            }
            sudoku[x][y] = 0; // 아니면 빼버리기
            return;
        }

        dfs(x, y + 1); // 채워져 있스면 다음거

    }

    static boolean check(int x, int y, int val) {
        for (int i = 0; i < 9; i++) {
            if (sudoku[x][i] == val) {
                return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (sudoku[i][y] == val) {
                return false;
            }
        }

        int tmp_x = (x / 3) * 3; // 0, 3, 6
        int tmp_y = (y / 3) * 3; // 0, 3, 6

        for (int i = tmp_x; i < tmp_x + 3; i++) {
            for (int j = tmp_y; j < tmp_y + 3; j++) {
                if (sudoku[i][j] == val) {
                    return false;
                }
            }
        }

        return true;
    }
}
