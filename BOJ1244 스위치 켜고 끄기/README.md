# [1244] 스위치 켜고 끄기

## 분류
> 구현
>
> 시뮬레이션

## 코드
```java
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
```

## 문제풀이

문제에서 주어진 조건에 맞게 스위치를 켜고 끄는 문제다.

확인해야할 조건은 학생의 성별과 해당 학생이 받은 자연수를 사용한 스위치다.

먼저 남학생은 자신이 받은 수와 그 수의 배수인 스위치를 바꿔주면 되고
여학생은 자신이 받은 수를 기준으로 양쪽이 대칭이면 양쪽 모두 스위치를 바꾼다.

남학생의 스위치는 for 반복문으로 스위치 배열을 돌며 i % num == 0일 때 스위치를 바꿨다.

여학생은 앞,뒤 스위치도 확인하면서 범위까지 확인해야한다. 먼저 받은 수에 해당하는 스위치는 먼저 바꿔주고 앞의 스위치와 뒤 스위치를 front = num - 1, back = num + 1로 초기화했다. 그 후에 front가 1 이상일 때와 back이 N 이하일 때 즉, 스위치가 존재할때 까지만 반복문을 실행해 스위치를 바꿔주었다. 다음 반복문이 시작되기 전에 front값은 -1, back값은 +1 해주면 자연수를 기준으로 대칭인 것을 확인할 수 있다.

마지막 출력은 한 줄에 최대 20개 출력이므로 21, 41, 61 ... 이될 때마다 다음줄에 출력되어야 한다.
그래서 i가 20보다 크면서 20으로 나누었을 때 나머지가 1일 때만 개행을 했다.

끗-
