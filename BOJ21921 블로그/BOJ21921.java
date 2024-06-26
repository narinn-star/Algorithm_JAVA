import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ21921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        int ansCnt = 1, sum = 0;

        for(int i = 0; i < X; i++){
            sum += arr[i];
        }
        int max = sum;

        for(int i = X; i < N; i++){
            sum = sum - arr[i - X] + arr[i];

            if(max == sum){
                ansCnt++;
            }else if(max < sum){
                max = sum;
                ansCnt = 1;
            }
        }

        if (max == 0) System.out.println("SAD");
        else {
            System.out.println(max);
            System.out.println(ansCnt);
        }
    }
}
