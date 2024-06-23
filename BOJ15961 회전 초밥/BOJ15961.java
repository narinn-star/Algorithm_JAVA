import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2531 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] plate = new int[N + k];
        int[] sushi = new int[d + 1];

        for (int i = 0; i < N; i++) {
            plate[i] = Integer.parseInt(br.readLine());
        }

        // 원형으로 만들어주기
        for (int i = 0; i < k; i++) {
            plate[N + i] = plate[i];
        }

        int cnt = 0;

        // 처음 k개 먼저 계산
        for (int i = 0; i < k; i++) {
            if (sushi[plate[i]] == 0) {
                cnt++;
            }
            sushi[plate[i]]++;
        }

        if (sushi[c]++ == 0) cnt++;

        int max = cnt;

        for (int i = k; i < plate.length; i++) {
            sushi[plate[i - k]]--;
            if (sushi[plate[i - k]] == 0) cnt--;

            if (sushi[plate[i]]++ == 0) {
                cnt++;
            }

            max = Math.max(max, cnt);
        }

        System.out.println(max);
    }
}
