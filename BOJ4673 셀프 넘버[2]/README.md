# [4673] 셀프 넘버

## 분류
> 수학
>
> 구현
>
> 브루트포스 알고리즘

## 코드
```java
public class BOJ4673 {
    public static void main(String[] args) {

        boolean array[] = new boolean[10001];

        for(int i = 1; i <= 10000; i++){
            int n = divideNumber(i);

            if(n <= 10000){
                array[n] = true;
            }
        }

        for(int i = 1; i < array.length; i++){
            if(array[i] == false){
                System.out.println(i);
            }
        }
    }

    public static int divideNumber(int n){
        int sum = n;

        while(n != 0){
            sum = sum + (n % 10); // 첫째자리수 뽑기
            n = n / 10; // 버리기
        }
        return sum;
    }
}

```

## 문제풀이

입력은 필요 없이, 10000까지 반복문으로 필요한 값만 찾아내면 된다.

생성자가 있는 숫자인지, 없는 숫자인지를 판별하기 위해 배열을 만들었다.

다른 문제에서도 그렇지만 왜 항상 숫자를 한 자리씩 떼어내는 데 계산이 오래걸리는 지 모르겠다..
수학적 사고가 부족한 탓인가 싶음을 오늘도 느꼈다.

반복해서 실행되는 숫자 떼어내고 합하는 계산은 따로 함수로 작성했고, 
그렇게 만들어진 생성자가 있는 숫자는 함수 종료 후 true로 변경해주었다.

10000까지 반복 후에는 생성자가 있는 숫자와 없는 숫자가 표시된 배열이 완성되어 있기 때문에 그대로 출력만 해주면 된다.


