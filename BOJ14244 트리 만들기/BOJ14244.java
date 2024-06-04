import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ14244 {
    private static int N, M;
    private static ArrayList<Integer> tree[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        tree = new ArrayList[N];
        for(int i = 0; i < N; i++){
            tree[i] = new ArrayList<>();
        }

        for(int i = 1; i <= M; i++){
            tree[0].add(i);
            System.out.println(0 + " " + i);
        }

        for(int i = M + 1; i < N; i++){
            tree[i - M].add(i);
            System.out.println(i - M + " " + i);
        }
    }
}
