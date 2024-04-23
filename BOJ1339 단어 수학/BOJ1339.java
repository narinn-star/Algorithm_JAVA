import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class BOJ1339 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N + 1];
        int[] alpha = new int[26];

        for(int i = 0; i < N; i++){
            words[i] = br.readLine();
        }

        for(int i = 0; i < N; i++){
            int order = (int)Math.pow(10, words[i].length() - 1);
            for(int j = 0; j < words[i].length(); j++){
                int idx = words[i].charAt(j) - 65;
                alpha[idx] += order;
                order /= 10;
            }
        }

        Arrays.sort(alpha);
        int max = 9;
        int sum = 0;
        for(int i = alpha.length - 1; i >= 0; i--){
            if(alpha[i] == 0) break;
            sum += alpha[i] * max;
            max--;
        }

        System.out.println(sum);
    }
}
