import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int x = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int left = 0, right = arr.length - 1, cnt = 0;

        while(left < right){
            if(arr[left] + arr[right] < x) {
                left++;
            }else if(arr[left] + arr[right] > x){
                right--;
            }else{
                cnt++;
                left++;
                right--;
            }
        }

        bw.write(cnt +"\n");
        bw.flush();
        bw.close();
    }
}
