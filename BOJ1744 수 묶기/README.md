# [1744] 수 묶기

## 분류
> 그리디 알고리즘
>
> 정렬
>
> 많은 조건 분기

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class BOJ1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Integer[] num = new Integer[N];

        int sum = 0;
        int minusCnt = 0;

        for(int i =0 ; i < N; i++){
            num[i] = Integer.parseInt(br.readLine());
            if(num[i] <= 0) minusCnt++;
        }
        Arrays.sort(num);

        // 마이너스 먼저 처리
        int idx = 0;
        while(minusCnt > 0){
            if(minusCnt == 1){
                sum += num[idx];
                idx++;
                break;
            }
            sum += (num[idx] * num[idx + 1]);

            idx += 2;
            minusCnt -= 2;
        }

        // 나머지는 다 묶어주면 됨
        while(idx < N){
            if((N - idx) % 2 == 1) sum += num[idx++]; // 남은개 홀수개
            else if(num[idx] == 1){
                sum += 1;
                idx++;
            }else {
                sum += (num[idx] * num[idx + 1]);
                idx+= 2;
            }
        }

        System.out.println(sum);
    }
}

```

## 문제풀이

그리디 알고리즘인가 구현인가.. 조건을 정말 하나씩 잘 따져줘야하는 문제다. 

일단 마이너스는 두개씩은 무조건 묶어주는 것이 값을 크게 만들 수 있는 유일한 방법이기 때문에 2개씩은 계속 곱해서 더해주고, 1개가 남았을 때는 개별로 더해줬다. 0을 여기에 포함해야하는데, 0이 음수가 아닌 양수쪽으로 넘어가면 양수의 값과 곱해지면서 0이 되기 떄문에 최댓값을 구할 수 없고, -1과 0이 있을 때 둘을 따로 더하는 것보다 곱하는 것이 더 크기 때문에 음수로 처리하는 것이 맞다고 판단했다.

그리고 양수는 짝수개와 홀수개 그리고 예외사항으로 값이 1일 때도 고려해줘야했다. 
남은 것이 홀수개라면 하나만 더하면 되고, 1일 때는 개별로 하나씩 다 더해주면 되고, 나머지는 두개씩 무조건 묶어주면 된다. 작은 수부터 곱해서 괜찮을까 싶었지만, 하나 남았을 때가 아니라 남은 갯수의 홀/짝을 미리 판단해주기 때문에 상관이 없다. 

나는 1일 때 개별로 하나씩 다 더해야한다는 것을 질문 게시판을 보고서야 알았는데, 아마 코테에서는 히든 테케로 들어가있을 거고.. 나는 예측을 못할거고.. 결국 틀리게 될 것이라는 것인데..
단순히 문제를 푸는 것만이 아니라 경계값을 예측해서 테스트케이스를 예상하는 능력도 필요하다는 걸 느꼈따..🫠
