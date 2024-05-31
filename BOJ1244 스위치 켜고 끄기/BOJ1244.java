import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1244 {
    private static int N;
    private static int[] switches;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); // 스위치 개수
        switches = new int[N + 1]; // 스위치 상태

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            switches[i] = Integer.parseInt(st.nextToken());
        }

        int student = Integer.parseInt(br.readLine()); // 학생 수


        for(int i = 0; i < student; i++){
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            confirm(gender, num);
        }

        for(int i = 1; i <= N; i++){
            if(i >= 20 && i % 20 == 1) System.out.println();
            System.out.print(switches[i] + " ");
        }
    }
    private static void confirm(int gender, int num){
        if(gender == 1) { // 남학생
            for(int i = 1; i <= N; i++){
                if(i % num == 0){
                    change(i);
                }
            }
        }else if(gender == 2){ // 여학생
            change(num);

            int front = num - 1, back = num + 1;

            while(front > 0 && back < N + 1){
                if(switches[front] == switches[back]){
                    change(front);
                    change(back);
                    front--;
                    back++;
                }else {
                    break;
                }
            }
        }
    }
    private static void change(int n){
        if(switches[n] == 1) switches[n] = 0;
        else switches[n] = 1;
    }
}
