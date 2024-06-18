# [3649] 로봇 프로젝트

## 분류
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

public class BOJ3649 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = null;

        while((s = br.readLine()) != null) {
            int x = Integer.parseInt(s) * 10000000;
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];

            for(int i = 0; i < n; i++){
                arr[i] = Integer.parseInt(br.readLine());
            }

            int left = 0, right = arr.length - 1;
            boolean isTrue = false;

            Arrays.sort(arr);

            while (left < right) {
                int tmp = arr[left] + arr[right];
                if (tmp == x) {
                    System.out.println("yes " + arr[left] + " " + arr[right]);
                    isTrue = true;
                    break;
                } else if (tmp < x) left++;
                else right--;
            }

            if (!isTrue) System.out.println("danger");
        }
    }
}
```

## 문제풀이

두 개를 더한 값을 x와 비교했을 때의 결과에 따라 left, right를 증감시켜준다. 문제에서는 정답이 여러 개일 때 l1 - l2의 절댓값이 가장 큰 것을 출력하라 했지만 어차피 정렬되어 있는 값이고, 가장 먼저 선택되는 두 값의 차가 가장 크기 때문에 굳이 max를 저장해둘 필요는 없다. 그래서 isTrue라는 불린값을 두었고 false로 그대로 남아있을 때 danger를 출력했다.

계속해서 테스트케이스를 입력받을 수 있어야 하기 때문에 while문으로 계속 입력받을 수 있게 했다. 
