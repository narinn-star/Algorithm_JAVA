import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14888 {
    private static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    private static int N;
    private static int[] num, op;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        num = new int[N + 1];
        op = new int[4];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        calc(num[0], 1);
        System.out.println(max + "\n" + min);
    }

    private static void calc(int res, int cnt) {
        if(cnt == N){
            max = Math.max(max, res);
            min = Math.min(min, res);
            return;
        }

        for (int i = 0; i < op.length; i++) {

            if(op[i] > 0) {
                op[i]--;
                switch (i) {
                    case 0:
                        calc(res + num[cnt], cnt + 1);
                        break;
                    case 1:
                        calc(res - num[cnt], cnt + 1);
                        break;
                    case 2:
                        calc(res * num[cnt], cnt + 1);
                        break;
                    case 3:
                        calc(res / num[cnt], cnt + 1);
                        break;
                }
                op[i]++;
            }
        }
    }
}
