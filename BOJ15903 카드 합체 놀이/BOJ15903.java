import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ15903 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        long res = 0;

        PriorityQueue<Long> pQueue = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            pQueue.add(Long.parseLong(st.nextToken()));
        }

        for(int i = 0; i < m; i++){
            long a = pQueue.poll();
            long b = pQueue.poll();
            pQueue.add(a + b);
            pQueue.add(a + b);
        }

        while(!pQueue.isEmpty()){
            res += pQueue.poll();
        }

        System.out.println(res);
    }
}
