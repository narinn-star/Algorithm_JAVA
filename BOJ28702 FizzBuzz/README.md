# [28702] FizzBuzz

## 분류
> 두 포인터

## 코드
```java
import java.io.*;

public class BOJ28702 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String first = br.readLine();
        String second = br.readLine();
        String third = br.readLine();

        int num = 0;
        if(isInteger(first)){
            num = Integer.parseInt(first);
            fizzBuzz(num + 3);
        }else if(isInteger(second)){
            num = Integer.parseInt(second);
            fizzBuzz(num + 2);
        }else if(isInteger(third)){
            num = Integer.parseInt(third);
            fizzBuzz(num + 1);
        }
    }
    static boolean isInteger(String str) {
        try{
            Integer.parseInt(str);
            return true;
        }catch (NumberFormatException ex){
            return false;
        }
    }
    static void fizzBuzz(int num){
        if(num % 3 == 0){
            if(num % 5 == 0){
                System.out.println("FizzBuzz");
            }else {
                System.out.println("Fizz");
            }
        }else {
            if(num % 5 == 0){
                System.out.println("Buzz");
            }else {
                System.out.println(num);
            }
        }
    }
}
```

## 문제풀이

오랜만에 머리 식히려 브론즈를 샥- 풀어줬다.  
브론즈를 풀면 좋은 점도 있음.. 잘 사용해보지 않았던 것들을 건들여볼 수 있는 기회라고나 할까.  
이 문제에서도 다른 문제에서는 굳이 사용하지 않는 try-catch를 사용해서 정수임을 확인하는 함수도 작성해볼 수 있었다. (이제 js로 갈아타긴 할거지만 ,,) 다다익선 ~ 아는게 많아지면 좋지 뭐,,
