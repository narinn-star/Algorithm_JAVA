import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2512 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] budget = new int[N];
        int low = 1, high = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            budget[i] = Integer.parseInt(st.nextToken());
            if(high < budget[i]) high = budget[i];
        }

        int M = Integer.parseInt(br.readLine());

        while(low <= high){
            int mid = (low + high) / 2;
            int sum = 0;

            for(int b : budget){
                if(b >= mid) sum += mid;
                else sum += b;
            }

            if(sum <= M) low = mid + 1;
            else high = mid - 1;
        }

        System.out.println(high);
    }
}
