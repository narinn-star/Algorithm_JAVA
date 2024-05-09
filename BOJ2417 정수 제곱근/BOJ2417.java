import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2417 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());

        long min = 0, max = Long.MAX_VALUE, res = 0;

        while(min <= max){
            long mid = (min + max) / 2;

            if(n > Math.pow(mid, 2)){
                min = mid + 1;
            }else {
                res = mid;
                max = mid - 1;
            }
        }
        System.out.println(res);
    }
}
