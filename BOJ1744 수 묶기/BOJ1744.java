import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class BOJ1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Integer[] num = new Integer[N];

        int sum = 0;
        int minusCnt = 0;

        for(int i =0 ; i < N; i++){
            num[i] = Integer.parseInt(br.readLine());
            if(num[i] <= 0) minusCnt++;
        }
        Arrays.sort(num);

        // 마이너스 먼저 처리
        int idx = 0;
        while(minusCnt > 0){
            if(minusCnt == 1){
                sum += num[idx];
                idx++;
                break;
            }
            sum += (num[idx] * num[idx + 1]);

            idx += 2;
            minusCnt -= 2;
        }

        // 나머지는 다 묶어주면 됨
        while(idx < N){
            if((N - idx) % 2 == 1) sum += num[idx++]; // 남은개 홀수개
            else if(num[idx] == 1){
                sum += 1;
                idx++;
            }else {
                sum += (num[idx] * num[idx + 1]);
                idx+= 2;
            }
        }

        System.out.println(sum);
    }
}
