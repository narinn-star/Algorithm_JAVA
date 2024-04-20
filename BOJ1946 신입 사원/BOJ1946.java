import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[][] rank = new int[N][2];
            int cnt = 1;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                rank[i][0] = Integer.parseInt(st.nextToken());
                rank[i][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(rank, (o1, o2) -> o1[0] - o2[0]); // 오름차순

            int tmp = rank[0][1];

            for (int i = 1; i < N; i++) {
                if (tmp > rank[i][1]) { // [i][1]의 등수가 [j][1]의 등수보다 낮을 때
                    tmp = rank[i][1];
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
}
