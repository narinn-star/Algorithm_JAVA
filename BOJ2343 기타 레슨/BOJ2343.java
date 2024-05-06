import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2343 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] lec = new int[N];

        int start = 0, end = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            lec[i] = Integer.parseInt(st.nextToken());
            if(start < lec[i]) start = lec[i];
            end += lec[i];
        }

        while(start <= end){
            int mid = (start + end) / 2;
            int cnt = 0;
            int sum = 0;
            for(int i = 0; i < N; i++){
                if(sum + lec[i] > mid){
                    cnt++;
                    sum = 0;
                }
                sum += lec[i];
            }

            if(sum != 0) cnt++;
            if(cnt > M) start = mid + 1;
            else end = mid - 1;
        }
        System.out.println(start);
    }
}
