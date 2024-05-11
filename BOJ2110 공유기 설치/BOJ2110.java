import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] home = new int[N];

        for(int i = 0; i < N; i++){
            home[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(home);

        int min = 1, max = home[N - 1] - home[0];
        int dist = 0;

        while(min <= max){
            int mid = (min + max) / 2;
            int wifi = 0;
            int cnt = 1 ;
            
            for(int i = 1; i < N; i++){
                if(home[i] - home[wifi] >= mid) {
                    cnt++;
                    wifi = i;
                }
            }

            if(cnt >= C) {
                dist = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        System.out.println(dist);
    }
}
