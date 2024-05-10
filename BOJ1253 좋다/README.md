# [1253] 좋다

## 분류
> 자료 구조
>
> 정렬
> 
> 이분 탐색
> 
> 두 포인터

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int cnt = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for(int i = 0; i < N; i++){
            int left = 0, right = N - 1;
            while(true){
                if(i == left) left++;
                else if(i == right) right--;

                if(left >= right) break;
                if(arr[left] + arr[right] == arr[i]){
                    cnt++;
                    break;
                }else if(arr[left] + arr[right] > arr[i]){
                    right--;
                }else left++;
            }
        }

        System.out.println(cnt);
    }
}

```

## 문제풀이

투 포인터로 풀었다. 0과 N - 1로 각각 시작해서  left >= right일 때 while 반복문을 탈출한다. 처음엔 while문에 조건문으로 넣었는데, 그렇게 하면 left, right가 자기자신일 때 left++, right--해주고 나서 종료해야하지만 종료가되지 않아 while(true)로 해두고 내부에서 종료문을 작성해두었다.

푸는 방법만 알면사실 골드 4도 아닌.. 그런 문제였다! 
