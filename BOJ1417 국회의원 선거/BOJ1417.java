import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ1417 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int firstCan = Integer.parseInt(br.readLine());
        int cnt = 0;

        PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < N - 1; i++) {
            pQueue.add(Integer.parseInt(br.readLine()));
        }

        while (!pQueue.isEmpty() && pQueue.peek() >= firstCan) {
            cnt++;
            firstCan++;
            pQueue.add(pQueue.poll() - 1);
        }

        System.out.println(cnt);
    }
}
