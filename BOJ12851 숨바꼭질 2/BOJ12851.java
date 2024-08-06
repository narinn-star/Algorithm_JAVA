
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ12851 {
    static int N, K;
    static int min = Integer.MAX_VALUE;
    static int cnt = 0;
    static int[] visitTime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if(N == K){
            bw.write(0 + "\n" + 1);
            bw.flush();
            bw.close();
            return;
        }

        visitTime = new int[100001];

        bfs();

        bw.write(min + "\n" + cnt + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        visitTime[N] = 1;
        queue.add(N);

        while(!queue.isEmpty()){
            int q = queue.poll();

            if(min < visitTime[q]) return;

            for(int i = 0; i < 3; i++){
                int dest = 0;

                if(i == 0) dest = q + 1;
                else if(i == 1) dest = q - 1;
                else dest = q * 2;

                if(dest < 0 || dest > 100000) continue;

                if(dest == K) { // 도착
                    min = visitTime[q];
                    cnt++;
                }

                if(visitTime[dest] == 0 || visitTime[dest] == visitTime[q] + 1) {
                    visitTime[dest] = visitTime[q] + 1;
                    queue.add(dest);
                }
            }

        }
    }
}
