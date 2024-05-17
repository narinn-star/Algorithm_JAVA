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
