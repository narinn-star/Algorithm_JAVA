import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2309 {
    private static int[] arr;
    private static int sum = 0, a, b;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new int[9];

        for(int i = 0; i < 9; i++){
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        Arrays.sort(arr);

        search();
        for(int i = 0; i < 9; i++){
            if(i == a || i == b){
                continue;
            }else{
                sb.append(arr[i] + "\n");
            }
        }
        System.out.println(sb);
    }
    private static void search(){
        for(int i = 0; i < 9; i++){
            for(int j = 1; j < 9; j++){
                if(sum - (arr[i] + arr[j]) == 100) {
                    sum -= (arr[i] + arr[j]);
                    a = i; b = j;
                    return;
                }
            }
        }
    }
}
