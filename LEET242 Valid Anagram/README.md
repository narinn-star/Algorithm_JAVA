# [Leetcode 242] Valid Anagram

## 분류
> Hash Table
> 
> String
> 
> Sorting


## 코드
```java
class Solution {
    public boolean isAnagram(String s, String t) {
        int[] alphaCnt = new int[26];

        for(int i = 0; i < s.length(); i++){
            int idx = s.charAt(i) - 97;
            alphaCnt[idx]++;
        }

        for(int i = 0; i < t.length(); i++){
            alphaCnt[t.charAt(i) - 97]--;
        }

        for(int i = 0; i < alphaCnt.length; i++){
            if(alphaCnt[i] != 0) return false;
        }

        return true;
    }
}
```

## 문제풀이

두 문자열이 같은 문자를 모두 포함하고 있는가를 확인하는 문제다.

알파벳 26자 배열을 만들어두고 ++, --를 사용했다. a는 아스키코드로 97이기 때문에 0부터 시작하는 배열에 맞추기 위해 97을 모두 빼준 인덱스값을 지정해줬다. 그리고 마지막에 카운팅 배열에 0이 아닌 숫자가 있다면 바로 false를 반환한다.
