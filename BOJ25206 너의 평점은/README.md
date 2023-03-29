# [25206] 너의 평점은

## 분류
> 수학
> 
> 구현
> 
> 문자열

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.StringTokenizer;

public class BOJ25206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        double sum = 0.0;
        double gSum = 0.0;

        for(int i = 0; i < 20; i++){
            String[] str = br.readLine().split(" ");
            gSum += Double.parseDouble(str[1]);
            double grade = 0.0;
            switch(str[2]){
                case "A+":
                    grade = 4.5;
                    break;
                case "A0":
                    grade = 4.0;
                    break;
                case "B+" :
                    grade = 3.5;
                    break;
                case "B0" :
                    grade = 3.0;
                    break;
                case "C+":
                    grade = 2.5;
                    break;
                case "C0":
                    grade = 2.0;
                    break;
                case "D+":
                    grade = 1.5;
                    break;
                case "D0":
                    grade = 1.0;
                    break;
                case "F" :
                    grade = 0.0;
                    break;
                case "P":
                    grade = 0.0;
                    gSum -= Double.parseDouble(str[1]);
                default:
                    grade = 0.0;
            }
            sum += Double.parseDouble(str[1]) * grade;
        }
        System.out.printf("%.6f", (sum / gSum));
    }
}

```

## 문제풀이

자바에서는 소수점을 출력할 때 printf()함수를 사용하면 원하는 소수점길이만큼 출력할 수 있다.
가령 3번째자리까지 출력하려면 printf("%.3f", result); 라고 작성하면 되겠다.
