# [Leetcode 876] Middle of the Linked List

## 분류
> Linked List
> 
> Two Pointers

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
    public ListNode middleNode(ListNode head) {
        ListNode next = head;
        int cnt = 0;

        while(next != null){
            next = next.next;
            cnt++;
        }

        int mid = cnt / 2;
        ListNode res = head;

        for(int i = 0; i < mid; i++){
            res = res.next;
        }
        return res;
    }
}
```

## 문제풀이

중간값을 찾기 위해 총 길이를 먼저 구해줬다. 다른 방법이 있을 것 같긴 한데.. 모르겠단 말이지😅
아무튼 총 길이를 구해서 반으로 나눠주고, head 위치를 mid -1까지 옮겨주고 리턴해주었다.
