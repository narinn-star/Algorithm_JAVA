# [2839] 설탕 배달

## 분류
> 수학
>
> 다이나믹 프로그래밍
>
> 그리디 알고리즘

## 코드
```java
import java.io.IOException;
import java.util.Scanner;

public class BOJ2839_2 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int sugar[] = new int[5001];

        sugar[3] = sugar[5] = 1;

        for(int i = 6; i < sugar.length; i++){
            if(i % 5 == 0){
                sugar[i] = sugar[i - 5] + 1;
            }
            else if(i % 3 == 0){
                sugar[i] = sugar[i - 3] + 1;
            } else {
                if(sugar[i - 3] != 0 && sugar[i - 5] != 0)
                    sugar[i] = Math.min(sugar[i - 3], sugar[i - 5]) + 1;
            }
        }

        if(sugar[N] == 0){
            System.out.println("-1");
        }else {
            System.out.println(sugar[N]);
        }

    }
}
```

## 문제풀이

5와 3만으로 설탕을 옮겨담으려면 5와 3으로 나누어 떨어지는가를 봐야한다.
dp문제인걸 알고 풀어서 쌓아가려고 3, 5일때 1이라 바로 넣어두고 규칙을 찾았다.

15까지만 적어봐도 5로 나누어떨어지거나 3으로 나누어떨어질 때는 그 이전의 수 (현재 수보다 작은, 가장 큰 약수)에 +1한 값과 같다는 것을 알 수 있었다. 나누어떨어지지 않을 때는 3, 5를 뺐을 때의 수를 비교해 작은 수에서 +1을 해주면 된다.

처음엔 sugar[12] = sugar[6] + sugar[6] = sugar[3] + sugar[3] + sugar[3] + sugar[3]
이렇게 풀어가려고 했는데, 생각보다 코드로 구현이 잘 안돼서 그냥 밑에서부터 쌓아 갔다.
