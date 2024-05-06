# [2343] 기타 레슨

## 분류
> 이분 탐색
>
> 매개 변수 탐색

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2343 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] lec = new int[N];

        int start = 0, end = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            lec[i] = Integer.parseInt(st.nextToken());
            if(start < lec[i]) start = lec[i];
            end += lec[i];
        }

        while(start <= end){
            int mid = (start + end) / 2;
            int cnt = 0;
            int sum = 0;
            for(int i = 0; i < N; i++){
                if(sum + lec[i] > mid){
                    cnt++;
                    sum = 0;
                }
                sum += lec[i];
            }

            if(sum != 0) cnt++;
            if(cnt > M) start = mid + 1;
            else end = mid - 1;
        }
        System.out.println(start);
    }
}
```

## 문제풀이

이게 어째서 이분탐색인지 정말 이해하기 어려웠다.. 
이분 탐색을 단순히 mid값을 지정해서 찾아가는 것으로만 생각해서 그런가, 문제에 적용할때마다 계속 어려웠는데 이 문제가 그중에서도 제일 어려웠다.

start와 end값을 지정하는 것은 다른 코드를 참고해서 풀었다. 이 두개만 잡으면 카운팅을 해주는 것은 크게 어렵지 않았고, 내부 이분 탐색 로직도 달라지는 건 없다.

 어려웍
