# [Leetcode 139] Word Break

## 분류
> Array
> 
> Hash Table
> 
> String
> 
> Dynamic Programming
> 
> Trie
> 
> Memoization

## 코드
```java
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Map<String,Boolean> map = new HashMap<>();
        
        return find(s, wordDict, map);
    }

    private static boolean find(String s, List<String> set, Map<String, Boolean> map) {
        if(s.length() == 0) return true; // wordDict에 다 들어있다

        if(map.containsKey(s)) return map.get(s); 

        for(int i = 0; i < s.length(); i++){
            String str = s.substring(0, i + 1);
            if(set.contains(str) && find(s.substring(i + 1), set, map)){
                map.put(s, true); // 있다
                return true;
            }
        }
        map.put(s, false); // 없다
        return false;
    }
}
```

## 문제풀이

HashMap value값에 Boolean을 넣을 생각을 하지 못했다. 이부분만 다른 코드를 참고했는데 나머지는 생각한 대로 구현이 잘 됐던 문제!

주어진 문자열이 wordDict 배열에 있는 단어들로 구성이 가능한지 확인하는 것이므로, 하나씩 다 확인해봐야 한다는 생각밖에 없었다. 처음에 substring로 자르고, 그 다음 문자열들도 재귀로 잘라서 확인해서 리턴해줬는데, timeout이 나왔다. 

timeout이 나온 테스트케이스는 다음과 같다.
s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"
wordDict = ["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]

아마 a가 반복이 많이 되는만큼 for루프를 불필요하게 돌아서 그런 것 같았다. 그럼 .. 어케함쇼 라는 생각에 찾은 것이 Map<String,Boolean>이었다. 미리 저장해두고 한 번 있다고 확인된 문자열이라면 for문을 돌기 전에 리턴해주면 되는 것이다. 그렇게하면 이미 들어있다고 판단된 것과 들어있지 않다고 판단된 것 모두 반복문 없이 바로 확인이 가능하다.🫢 

확인하려면 저장도 해야하니 각 리턴문 앞에 map에 값을 저장해주는 것!
