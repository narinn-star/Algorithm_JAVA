import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15650 {
    static int N, M;
    static int[] res;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        res = new int[M + 1];

        func(1, 0);

        System.out.println(sb);
    }

    private static void func(int start, int num) {
        if(num == M){
            for(int i = 0; i < M; i++){
                sb.append(res[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i = start; i <= N; i++){
            res[num] = i;
            func(i + 1, num + 1);
        }
    }
}

