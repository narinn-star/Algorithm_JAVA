# [Leetcode 191] Number of 1 Bits

## 분류
> Divide and Conquer
> 
> Bit Manipulation


## 코드
```java
class Solution {
    public int hammingWeight(int n) {
        
        String binaryString = Integer.toBinaryString(n);
        int cnt = 0;
        
        for(int i = 0; i < binaryString.length(); i++){
            if(binaryString.charAt(i) == '1') cnt++;
        }

        return cnt;
    }
}
```

## 문제풀이

toBinaryString() 메소드로 10진수를 2진수로 바꾼 후 1이 있을 때마다 카운팅을 해줬다.

*10진수 -> 8진수 : toOctalString()*
*10진수 -> 16진수 : toHexaString()*
