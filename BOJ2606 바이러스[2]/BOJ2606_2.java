import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2606_2 {
    private static int computer, connectNum, cnt = 0;
    private static boolean connectArray[][];
    private static boolean visited[];
    private static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        computer = Integer.parseInt(br.readLine());
        connectNum = Integer.parseInt(br.readLine());

        connectArray = new boolean[computer + 1][computer + 1];
        visited = new boolean[computer + 1];

        for(int i = 1; i <= connectNum; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            connectArray[a][b] = true;
            connectArray[b][a] = true;
        }

        queue.add(1);
        visited[1] = true;

        bfs();

        System.out.println(cnt);
    }

    private static void bfs(){
        while(!queue.isEmpty()){
            int q = queue.poll();

            for(int i = 1; i <= computer; i++){
                if(!visited[i] && connectArray[q][i]){
                    visited[i] = true;
                    queue.add(i);
                    cnt++;
                }
            }
        }
    }

}
