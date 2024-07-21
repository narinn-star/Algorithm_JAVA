import java.io.*;
import java.util.*;

public class BOJ16928 {
    static int res;
    static int[] board;
    static int[] boardCnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        board = new int[101];
        boardCnt = new int[101];

        for(int i = 1; i <= 100; i++){
            board[i] = i;
        }

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            board[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            board[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        bfs(1);

        bw.write(boardCnt[100] + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        boardCnt[start] = 0;

        while(true){
            int number = queue.poll();

            for(int dice = 1; dice <= 6; dice++){
                int move = number + dice;

                if(move > 100) continue;

                if(boardCnt[board[move]] == 0) {
                    queue.add(board[move]);
                    boardCnt[board[move]] = boardCnt[number] + 1;
                }

                if(board[move] == 100) {
                    return;
                }
            }
        }
    }
}
