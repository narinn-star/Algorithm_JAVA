import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] liquid = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            liquid[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = liquid.length - 1;

        long diff = Long.MAX_VALUE;

        while(left < right){
            long sum = liquid[left] + liquid[right];
            if(Math.abs(sum) < diff){
                diff = Math.abs(sum);
                sb.setLength(0);
                sb.append(liquid[left]).append(" ").append(liquid[right]);
            }
            if(sum >= 0) right--;
            else left++;
        }

        System.out.print(sb);
    }

}
