# [2417] 정수 제곱근

## 분류
> 수학
> 
> 이분 탐색

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2417 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());

        long min = 0, max = Long.MAX_VALUE, res = 0;

        while(min <= max){
            long mid = (min + max) / 2;

            if(n > Math.pow(mid, 2)){
                min = mid + 1;
            }else {
                res = mid;
                max = mid - 1;
            }
        }
        System.out.println(res);
    }
}

```

## 문제풀이

왜 mid * mid는 안되는지 모르겠다.. 디버깅 해보니 범위를 벗어난다고 표시가 되어서 Math.pow() 함수를 사용해서 풀었다.

q^2 >= n인 가장 작은 음이 아닌 정수 q이기 때문에 `n <= Math.pow(mid, 2)`일 때 res 값을 mid로 바꿔주면서 반복문을 진행했다.
