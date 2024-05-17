# [1991] 트리 순회

## 분류
> 트리
>
> 재귀

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
    char val;
    Node left, right;
    Node(char val, Node left, Node right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class BOJ1991 {
    private static int N;
    private static Node node;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        node = new Node('A', null, null);

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            char val = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            setNode(node, val, left, right);
        }

        preOrder(node);
        System.out.println();
        inOrder(node);
        System.out.println();
        postOrder(node);
    }
    private static void setNode(Node n, char val, char left ,char right){
        if(n.val == val) {
            if(left == '.') n.left = null;
            else n.left = new Node(left, null, null);
            if(right == '.') n.right = null;
            else n.right = new Node(right ,null, null);
        } else {
            if(n.left != null) setNode(n.left, val, left ,right);
            if(n.right != null) setNode(n.right, val, left ,right);
        }
    }

    private static void preOrder(Node n){
        if(n == null) return;
        System.out.print(n.val);
        preOrder(n.left);
        preOrder(n.right);
    }
    private static void inOrder(Node n){
        if(n == null) return;
        inOrder(n.left);
        System.out.print(n.val);
        inOrder(n.right);
    }
    private static void postOrder(Node n){
        if(n == null) return;
        postOrder(n.left);
        postOrder(n.right);
        System.out.print(n.val);
    }
}
```

## 문제풀이

자바로 클래스를 구현해야하는 문제를 맞닥뜨리면 항상 얼어버린다.🥶 그래도 학교 다닐 때 했던걸 열심히 더듬어서 구현을 해보려 아주 크게 노력하곤 함.. 

이 문제를 풀 때 가장 오래 시간을 쓴 곳이 setNode 함수다. 일단 Node객체를 트리처럼 이어줘야 하는데, 입력만 받고 어떻게 이어줘야할 지 감이 오지 않아서 생성자도 제대로 작성 못했다. 조금 도움이 됐던 것은 몇 주 전부터 릿코드로 트리 문제를 풀어봤던 것인데, 릿코드에서 제공하는 definition이 떠올라서 기억을 더듬어 작성했다.😂
전위,중위,후위 탐색 함수들은 크게 어려운 부분이 없었다. 재귀를 호출해주는 (트리를 붙여주는) 것과 노드 값을 출력해주는 것의 순서만 잘 맞게 작성하면 알아서 챡챡 돌아간다.
