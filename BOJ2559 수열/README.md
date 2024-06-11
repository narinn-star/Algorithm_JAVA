# [2559] 수열

## 분류
> 누적 합
>
> 두 포인터
>
> 슬라이딩 윈도우

## 코드
```java
import java.io.*;
import java.util.StringTokenizer;

public class BOJ2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int max = Integer.MIN_VALUE;
        int sum = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < arr.length; i++){
            sum += arr[i];

            if(i == K - 1){
                max = sum;
            }

            if(i >= K){
                sum -= arr[i - K];
                max = Math.max(max, sum);
            }
        }

        bw.write(max + "\n");
        bw.flush();
        bw.close();
    }
}

```

## 문제풀이

항상 슬라이딩 윈도우는 겁내면서 넘겨왔는데 진짜 아무것도 아닌 문제였다.. 

여러 블로그들을 찾아보니 투 포인터와 슬라이딩 윈도우의 차이점을 한 번에 정리해주었다. 투 포인터는 범위에 변화가 있을 때, 슬라이딩 윈도우는 범위가 고정되어 있을 때 사용한다. 이 문제는 K개로 범위가 정해져있기 때문에 슬라이딩 윈도우로 풀면 된다.

배열을 쭉 나열해서 작성해두고 K개씩 앞에서부터 묶어보면 N번째 묶이는 수들과 N + 1번째 묶이는 수들에서 차이점이 맨 앞의 숫자가 빠지고 숫자 하나가 더해지는 것을 알  수 있다. 이게 창문을 미는 것 같다 해서 슬라이딩 윈도우,, 라고 한다. 결국, 처음 값을 가진 채로 뒤로 한칸씩 가면서 앞의 값은 빼주고 뒤에 하나씩 더해주면서 max값을 찾아주면 된다.

arr 길이만큼 반복하면서 sum에 하나씩 더해준다. 더한 직후에는 (최초)K개가 더해졌다면 max를 갱신해주고, 그 다음 부터는 맨 앞 숫자는 뺀 채로 max값을 갱신하면 된다.

생각보다 직관적인 풀이법이라, 겁냈던 것이 어이가 없었..다😅
