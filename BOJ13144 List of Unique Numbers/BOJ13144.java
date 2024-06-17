import java.io.*;
import java.util.StringTokenizer;

public class BOJ13144 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        int[] cnt = new int[1000001];
        int sum = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += i + 1;
        }

        int left = 1, right = 1;
        long ans = 0;

        while(left <= N){
            while(right <= N && cnt[arr[right]] == 0){
                cnt[arr[right]]++;
                right++;
            }
            ans += (right - left);
            cnt[arr[left++]]--;
        }

        bw.write(ans + "\n");
        bw.flush();
        bw.close();

    }
}
