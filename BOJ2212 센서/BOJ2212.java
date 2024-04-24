import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int[] sensor = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            sensor[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sensor);

        int[] dist = new int[N - 1];
        for(int i = 0; i < N - 1; i++){
            dist[i] = Math.abs(sensor[i] - sensor[i + 1]);
        }
        Arrays.sort(dist);

        int sum = 0;
        for(int i = 0; i < dist.length - K + 1; i++){
            sum += dist[i];
        }

        System.out.println(sum);
    }
}
