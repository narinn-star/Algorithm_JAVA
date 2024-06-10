# [Leetcode 169] Majority Element

## 분류
> Array
> 
> Hash Table
> 
> Divide and Conquer
> 
> Sorting
> 
> Counting

## 코드
```java
class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hashmap = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            hashmap.put(nums[i], hashmap.getOrDefault(nums[i], 0) + 1);
        }

        int max = -1;
        int key = -1;

        for(int k : hashmap.keySet()){
            if(hashmap.get(k) > max){
                max = hashmap.get(k);
                key = k;
            }       
        }
        
        return key;

        // Arrays.sort(nums);

        // return nums[nums.length / 2];
    }
}

// O(1)로 어떻게 풀죠?
```

## 문제풀이

이런 문제가 나올 때 항상 생각해보는 건 배열을 만들어두고 카운팅을 한 값을 배열에 넣어주는 방법인데, 이 문제는 nums[i]의 범위가 int 최대이기때문에 적절하지 않다. 해시 테이블을 쓸 수 있지만, Follow-up의 O(1)로 푸는 방법을 유도해서 한 번에 찾을 수 있는 방법을 생각해내려 했다.
문제에서 Majority Element는 (n / 2)개 이상 나오는 수라고 되어있어 정렬해서 바로 n/2번째에 나오는 수가 Majority Element라는 것을 알 수 있었다. 

해시테이블로도 풀어봤는데, 릿코드 상에서는 해시맵은 12ms, Arrays.sort()는 4ms가 나왔다. 왜지 ㅇㅅㅇ

O(1)로는 어떻게 푸는 지 모르겠다.

