# [2512] 예산

## 분류
> 이분 탐색
> 매개 변수 탐색

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2512 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] budget = new int[N];
        int low = 1, high = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            budget[i] = Integer.parseInt(st.nextToken());
            if(high < budget[i]) high = budget[i];
        }

        int M = Integer.parseInt(br.readLine());

        while(low <= high){
            int mid = (low + high) / 2;
            int sum = 0;

            for(int b : budget){
                if(b >= mid) sum += mid;
                else sum += b;
            }

            if(sum <= M) low = mid + 1;
            else high = mid - 1;
        }

        System.out.println(high);
    }
}
```

## 문제풀이

다른 이분탐색 문제와 다를게 없다. 이제 조금씩 익숙해지는 중! while 조건문에 부등호가 들어갈 때와 들어가지 않을 때 내부 if조건문 내부에서 코드가 달라지는데, 이부분도 이제야 이해를 한 듯하다.

여전히 이 문제가 이분탐색인 것을 한 번에 알아채기는 힘들긴 하지만.. 

스터디에서 좋은 방법을 얻었는데, 문제를 읽고 내가 사용할 수 있는 알고리즘들 중에 그 문제에서 쓸 수 없는 것들을 배제하다 보면 사용할 만한 알고리즘이 나온다고•• 
