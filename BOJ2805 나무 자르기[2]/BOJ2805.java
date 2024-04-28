import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] tree = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            tree[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(tree);

        int low = 0, high = tree[N-1];

        while(low < high){
            long sum = 0;
            int mid = (low + high) / 2;

            for(int i = 0; i < N; i++){
                if(tree[i] - mid > 0) sum += (tree[i] - mid);
            }

            if(sum >= M){
                low = mid + 1;
            }else {
                high = mid;
            }
        }
        System.out.println(low - 1);
    }
}
