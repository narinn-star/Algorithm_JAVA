import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1072 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long X = Long.parseLong(st.nextToken());
        long Y = Long.parseLong(st.nextToken());

        long Z = 100 * Y / X;

        if(Z==100 || Z == 99){
            System.out.println(-1);
            return;
        }

        int low = 0, high = (int)1e9;

        while(low < high){
            int mid = (low + high) / 2;
            long newZ = 100 * (Y + mid) / (X + mid);

            if(Z < newZ){
                high = mid;
            }else {
                low = mid + 1;
            }
        }
        System.out.println(high);
    }
}
