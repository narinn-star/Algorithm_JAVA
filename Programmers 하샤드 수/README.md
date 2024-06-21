# [Programmers 하샤드 수]

## 분류
> 연습문제

## 코드
```java
public class Pro하샤드_수 {
    public boolean solution(int x) {
        boolean answer = true;

        int tmp = x;
        int sum = 0;
        while(tmp >= 10){
            sum += tmp % 10;
            tmp /= 10;
        }
        sum += tmp;

        if(x % sum == 0) answer = true;
        else answer = false;

        return answer;
    }
}
```

## 문제풀이

각 자릿수는 % 10을 하면서 나머지를 구해주고, 구해준 다음에는 tmp값을 10으로 나눈 몫만 남겨둔다. 10 이상일 때만 진행하고, 10 미만일 때는 1의 자리 숫자이므로 그냥 더해주면 된다.

x만 가지고 위를 수행하면 초기 x값이 없어지기 때문에 tmp에 담아서 x는 남겨두었다. sum으로 나누었을 때 나누어 떨어지면 true, 그렇지 않으면 false를 반환한다.
