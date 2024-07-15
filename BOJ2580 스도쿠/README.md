# [2580] 스도쿠

## 분류
> 백트래킹

## 코드
```java
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

```

## 문제풀이

0으로 채워져 있는 칸을 적절하게 1 ~ 9의 사이의 값으로 채워넣는, 스도쿠 문제다.  
 
체크해야할 것은 같은 줄 (가로, 세로)과 같은 칸에 1~9가 중복되지 않도록 하는 것이다.  
같은 줄에 있는지 확인하는 것은 크게 어렵지 않고, 같은 칸을 확인하려면 해당 칸의 (0, 0)자리를 찾아줘야하는데 그러려면 3으로 나눈 후에     `* 3`을 해주면 된다. 그럼 각각 0, 3, 6 세가지가 나오므로 칸 탐색도 어렵지 않다.  

가장 중요한 것은 다음 칸으로 옮겨주는 것, 다음 줄로 옮겨주는 것, 그리고 맞지 않은 수가 들어갔을 때 빼는 것이다. 각 col과 row가 9가 됐을 때 다음 줄, 출력을 해주고 check가 끝나면 값을 넣거나, 0으로 바꿔주거나, 다음 칸으로 옮기면 된다.  

백트래킹에서 문제를 고른거라 백트래킹인 걸 알고 접근했지만,, 모르고 풀었다면 문제를 한참 풀다가 깨달았을 것 같은 느낌..
