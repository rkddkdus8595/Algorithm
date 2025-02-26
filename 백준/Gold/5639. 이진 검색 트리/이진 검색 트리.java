import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Node node = new Node(Integer.parseInt(br.readLine()));
		
		while(true) {
			String str = br.readLine();
			if(str == null || str.equals(" ")) break;
			int data = Integer.parseInt(str);
			node.insertNode(data);
		}
		postOrder(node);
    }
    static void postOrder(Node node) {
		if(node == null) return;
		postOrder(node.left);
		postOrder(node.right);
		System.out.println(node.data);
		
	}
}
class Node{
	int data;
	Node left;
	Node right;
	Node(int data){
		this.data = data;
	}
	public void insertNode(int data) {
		if(this.data > data) { // 현 노드보다 작다면 왼쪽
			if(this.left == null) {
				this.left = new Node(data);
			}else{
				this.left.insertNode(data);
			}
		}else {
			if(this.right == null) {
				this.right = new Node(data);
			}else{
				this.right.insertNode(data);
			}
		}
	}
}