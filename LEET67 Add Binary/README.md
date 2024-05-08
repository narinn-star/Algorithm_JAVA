# [Leetcode 67] Add Binary

## 분류
> Math
> 
> String
> 
> Bit Manipulation
> 
> Simulation

## 코드
```java
class Solution {
    public String addBinary(String a, String b) {
        String res = "";
        int aLen = a.length() - 1;
        int bLen = b.length() - 1; 
        int carry = 0; 

        while(aLen >= 0 || bLen >= 0 || carry == 1){
            if(aLen >= 0) carry += a.charAt(aLen--) - '0'; 
            if(bLen >= 0) carry += b.charAt(bLen--) - '0'; 

            res = String.valueOf(carry % 2) + res;

            carry /= 2;
        }

        return res;
    }
}
```

## 문제풀이

carry를 어떻게 하느냐가 관건인 문제였다. 계속 쌓여간다는 것을 명심해야함!

올림수가 있다면 res에 0을 쌓고 나서 carry 값은 1이 되기 때문에 다음 반복문을 진행할 때 carry값을 이용해 또 다시 반복하게 된다. 

