# [Leetcode 199] Binary Tree Right Side View

## 분류
> Tree
> 
> Depth-First Search
> 
> Breadth-First Search
> 
> Binary Tree


## 코드
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int maxDepth = 0;
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightList = new ArrayList<>();

        searchRightNode(rightList, root, 1);

        return rightList;
    }

    private void searchRightNode(List<Integer> rightList, TreeNode root, int depth){
        if(root == null) return;

        if(maxDepth < depth) {
            rightList.add(root.val);
            maxDepth++;
        }

        searchRightNode(rightList, root.right, depth + 1);
        searchRightNode(rightList, root.left, depth + 1);
    }
}
```

## 문제풀이

처음엔 오른쪽 노드들만 모두 넣는 문제인 줄 알고, searchRightNode(rightList, root.right)만 실행했다. 미디움 문제인데 이렇게 쉽나 싶었는디 내가 문제 잘못 읽은거였다😅

트리를 오른쪽에서 바라봤을 때 보이는 노드들을 출력하는 것이다. 즉, 왼쪽에 있는 노드들이 오른쪽 노드로 인해 가려져 보이지 않는다면, 오른쪽 노드만 출력하는 것이고, 오른쪽에 가리는 노드가 없다면 왼쪽 노드를 출력하는 것이다.

그래서 depth를 확인해줄 변수 maxDepth와 depth를 쌓아 줄 매개변수 depth를 추가해줬다. 오른쪽에 노드가 있다면 그 노드를 넣어줘야 하기 때문에 오른쪽 먼저 탐색해줘야 한다. 그리고 만약 maxDepth가 depth보다 작을 때만 리스트에 추가해주는 것이다. 처음에 maxDepth를 0으로, depth는 1으로 시작했기 때문에 오른쪽 노드가 null이 아니라면 바로 오른쪽 노드가 추가되고, maxDepth는 1, depth는 2가 된다. 만약 그 다음 depth에 오른쪽 노드가 없고 왼쪽 노드만 있다면 root == null에서 오른쪽 탐색은 끝이 나고, 왼쪽을 탐색하게 된다. 이때도 역시 `maxDepth < depth`를 성립하기 때문에 왼쪽 노드가 리스트에 추가된다.
만약 [1, 2, 3, null, 5, null]으로 들어온다면 (예제에서 4만 없음) 정답은 [1, 3, 5]인데, 3에서 5로 넘어갈 때가 위의 설명대로 실행된다.
