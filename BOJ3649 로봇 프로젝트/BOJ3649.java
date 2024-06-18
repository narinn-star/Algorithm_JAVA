import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ3649 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = null;

        while((s = br.readLine()) != null) {
            int x = Integer.parseInt(s) * 10000000;
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];

            for(int i = 0; i < n; i++){
                arr[i] = Integer.parseInt(br.readLine());
            }

            int left = 0, right = arr.length - 1;
            boolean isTrue = false;

            Arrays.sort(arr);

            while (left < right) {
                int tmp = arr[left] + arr[right];
                if (tmp == x) {
                    System.out.println("yes " + arr[left] + " " + arr[right]);
                    isTrue = true;
                    break;
                } else if (tmp < x) left++;
                else right--;
            }

            if (!isTrue) System.out.println("danger");
        }
    }
}
