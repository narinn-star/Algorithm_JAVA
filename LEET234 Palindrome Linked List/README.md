# [Leetcode 234] Palindrome Linked List

## 분류
> Linked List
> 
> Two Pointers
> 
> Stack
> 
> Recursion

## 코드
```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        
        List<Integer> list = new ArrayList<>();

        ListNode node = head;

        while(node != null){
            list.add(node.val);
            node = node.next;
        }

        int len = list.size();

        for(int i = 0; i < len/2; i++){
            if(list.get(i) != list.get(len-i-1)) return false;
        }
        return true;
    }
}
```

## 문제풀이

새로운 Definition에 또 버벅거리길 한참이었다.. 

그래도 문제가 간단해서 그냥 리스트에 넣고 나눠서 비교했다.
리스트 사이즈 4를 반으로 나누면 2가 나오기 떄문에 0, 1까지만 반복문이 실행되고 0은 (4-0-1)과 비교, 1은 (4-1-1)과 비교하게 되고, 만약 같지 않다면 바로 false를 반환하며 종료한다.

어떻게 더 빠르게 할 수 있지..?
