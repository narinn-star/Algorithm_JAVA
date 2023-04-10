import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Pro최댓값과_최솟값 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        solution(str);

    }
    private static String solution(String s){
        String answer = "";
        StringTokenizer st = new StringTokenizer(s, " ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        while(st.hasMoreElements()){
            int num = Integer.parseInt(st.nextToken());
            if(num > max){
                max = num;
            }
            if(num < min){
                min = num;
            }
        }
        answer = min + " " + max;
        return answer;
    }

}
