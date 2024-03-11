import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14888_2 {
    private static int N;
    private static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    private static int[] number, op;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        number = new int[N];
        op = new int[4];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        calculate(number[0], 1);
        System.out.println(max + "\n" + min);
    }

    private static void calculate(int sum, int idx) {
        if (idx == N) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (op[i] > 0) {
                op[i]--;
                switch (i) {
                    case 0:
                        calculate(sum + number[idx], idx + 1);
                        break;
                    case 1:
                        calculate(sum - number[idx], idx + 1);
                        break;
                    case 2:
                        calculate(sum * number[idx], idx + 1);
                        break;
                    case 3:
                        calculate(sum / number[idx], idx + 1);
                        break;
                }
                op[i]++;
            }
        }
    }
}
