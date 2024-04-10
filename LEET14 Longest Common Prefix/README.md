# [Leetcode 14] Longest Common Prefix

## 분류
> String
> 
> Trie

## 코드
```java
class Solution {
    public String longestCommonPrefix(String[] strs) {
        String res = "";

        Arrays.sort(strs, (s1, s2) -> s1.length() - s2.length());

        StringBuilder sb = new StringBuilder(strs[0]); // flow

        for(int i = sb.length() - 1; i >= 0; i--){
            boolean flag = true;
            for(int j = 1; j < strs.length; j++){
                String string = strs[j].substring(0, sb.length());

                if(!string.equals(sb.toString())){
                    flag = false;
                    break;
                }
            }
            if(flag){
                res = sb.toString();
                break;
            }
            sb = sb.deleteCharAt(i);
        }

        return res;
    }
}
```

## 문제풀이

StringBuilder를 공부하는 시간이었다..
내가 아는 주요 메소드는 append밖에 없었는데, deleteCharAt()이라는 너무너무너무 유용한 메소드가 있어서 사용해봤다.

아, 문자열 길이 오름차순 정렬도 처음 알았음.. ㅠㅠ

무튼 가장 짧은 단어의 전체부터 뒤에서 하나씩 줄여가며 기준 단어를 만들고, 하나씩 모두 비교해주었다. 만약 단어 하나라도 접두사가 일치하지 않으면 바로 기준단어를 고치고 다시 반복문을 돌게끔 했다.

릿코드는 자동완성 기능이 없어서.. 내 실력이 바닥이란 걸 알게 해준 문제.. 문제 자체는 어렵지 않았다.
