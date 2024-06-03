# [Leetcode 217] Contains Duplicate

## 분류
> Array
> 
> Hash Table
> 
> Sorting


## 코드
```java
class Solution {
    public boolean containsDuplicate(int[] nums) {
        // HashSet
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++){
            int n = nums[i];
            if(set.contains(n)) return true;
            else set.add(n);
        }

        return false;

        // HashMap
        
        // Map<Integer, Integer> map = new HashMap<>();

        // for(int i = 0; i < nums.length; i++){
        //     map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        // }

        // for(int k : map.keySet()){
        //     int value = map.get(k);
        //     if(value >= 2) return true;
        // }

        // return false;
    }
}
```

## 문제풀이

1. HashMap

배열 내의 숫자와 카운팅을 저장할 맵을 만들어서 value(카운팅 값)가 2가 넘으면 true, 그렇지 않으면 마지막에 false를 반환하도록 했다. 
그 결과 너무 느리게 나와서, 다른 방안을 생각한게 다음 Set이다.

2. HashSet

Set에는 값 자체 하나만 저장해서 그런가, 시간이 더 빠르기도 했고 애초에 for 반복문을 한 번에 돌면서 해결할 수 있어서 더 빨랐다. contains로 존재 여부를 파악한 후에 바로 true를 리턴했고, 그렇지 않으면 값을 넣어줬다. 여기도 마찬가지로 for 반복문이 끝날 때까지 리턴되지 않았다면 false를 리턴하면 된다.

