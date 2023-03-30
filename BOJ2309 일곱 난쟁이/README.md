# [2309] 일곱 난쟁이

## 분류
> 브루트포스 알고리즘
>
> 정렬

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2309 {
    private static int[] arr;
    private static int sum = 0, a, b;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new int[9];

        for(int i = 0; i < 9; i++){
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        Arrays.sort(arr);

        search();
        for(int i = 0; i < 9; i++){
            if(i == a || i == b){
                continue;
            }else{
                sb.append(arr[i] + "\n");
            }
        }
        System.out.println(sb);
    }
    private static void search(){
        for(int i = 0; i < 9; i++){
            for(int j = 1; j < 9; j++){
                if(sum - (arr[i] + arr[j]) == 100) {
                    sum -= (arr[i] + arr[j]);
                    a = i; b = j;
                    return;
                }
            }
        }
    }
}

```

## 문제풀이

브루트포스 한 번씩 보려고 시작한 문제.
이것 역시 1년 전에 풀어봤던 문제인데, 아마도 그 때는 단번에 7개를 더해서 100을 찾는 것보다 (7번 반복ㅋㅋ) 9개를 더한 수에서 2개를 빼서 100을 만드는 것을 떠올리는 것이 어려웠던것이 어렵풋이 기억이 난다.
두번 반복해서, i, j 저장해두고 함수를 빠져나와 반복문을 한 번 더 돌렸는데, 아마 그냥 3중 for문으로 해도 .. 그게 그거일 것 같긴 하다.
아무튼 전체 탐색을 더 풀어볼 예정! 아주 수월하게 풀어서 기분은 좋다.. (브론즈이긴 하지만 ㅠㅠ)
