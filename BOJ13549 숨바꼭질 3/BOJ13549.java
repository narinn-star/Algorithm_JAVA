import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ13549 {
    static int N, K;
    static int[] visitTime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if(N == K){
            bw.write(0 + "");
            bw.flush();
            bw.close();
            return;
        }

        visitTime = new int[100001];

        bfs();

        bw.write(visitTime[K] - 1 + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        visitTime[N] = 1;
        queue.add(N);

        while(!queue.isEmpty()){
            int q = queue.poll();

            if (visitTime[K] != 0) break;

            if (q * 2 < visitTime.length && visitTime[q * 2] == 0) {
                visitTime[q * 2] = visitTime[q];
                queue.add(q * 2);
            }
            if (q - 1 >= 0 && visitTime[q - 1] == 0) {
                visitTime[q - 1] = visitTime[q] + 1;
                queue.add(q - 1);
            }
            if (q + 1 < visitTime.length && visitTime[q + 1] == 0) {
                visitTime[q + 1] = visitTime[q] + 1;
                queue.add(q + 1);
            }
        }
    }
}
