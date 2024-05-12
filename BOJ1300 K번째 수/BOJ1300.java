import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int min = 0, max = k;
        int res = 0;

        while(min <= max) {
            int mid = (min + max) / 2;
            int cnt = 0;

            for(int i = 1; i <= N; i++){
                cnt += Math.min(N, mid / i);
            }

            if(cnt < k) {
                min = mid + 1;
            }else {
                max = mid - 1;
                res = mid;
            }
        }
        System.out.println(res);

    }
}
