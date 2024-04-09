import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2109 {
    static class Lecture {
        int pay;
        int deadline;

        Lecture(int pay, int deadline) {
            this.pay = pay;
            this.deadline = deadline;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] check = new int[10001];
        Lecture[] lectures = new Lecture[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int pay = Integer.parseInt(st.nextToken());
            int deadline = Integer.parseInt(st.nextToken());
            lectures[i] = new Lecture(pay, deadline);
        }

        Arrays.sort(lectures, (lec1, lec2) -> 
                lec1.pay == lec2.pay ? lec2.deadline - lec1.deadline : lec2.pay - lec1.pay);

        for(int i = 0; i < n; i++){
            for(int j = lectures[i].deadline; j >= 1; j--){
                if(check[j] == 0){
                    check[j] = lectures[i].pay;
                    break;
                }
            }
        }

        int sum = 0;

        for(int p : check){
            if(p != 0) sum += p;
        }

        System.out.println(sum);
    }
}
