import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ18511_2 {
    private static int N, K, res = 0;
    private static int[] num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        num = new int[K];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < K; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);

        findBig(0);
        System.out.println(res);
    }

    private static void findBig(int currentNum){
        if(currentNum > N) return;
        if(res < currentNum) res = currentNum;

        for(int i = 0; i < K; i++){
            findBig((currentNum * 10) + num[i]);
        }
    }
}
