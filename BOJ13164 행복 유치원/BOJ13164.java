import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ13164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] children = new int[N];
        Integer[] diff = new Integer[N - 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N; i++){
            children[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(children);

        for(int i = 0; i < N - 1; i++){
            diff[i] = Math.abs(children[i] - children[i + 1]);
        }

        Arrays.sort(diff);

        int cost = 0;
        for(int i = 0; i < diff.length - K + 1; i++){
            cost += diff[i];
        }
        System.out.println(cost);
    }
}
