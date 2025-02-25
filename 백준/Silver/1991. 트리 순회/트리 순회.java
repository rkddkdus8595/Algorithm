import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Tree t = new Tree();
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char data = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			t.createNode(data, left, right);
		}
		
		t.preOrder(t.root);
		System.out.println();
		t.inOrder(t.root);
		System.out.println();
		t.PostOrder(t.root);
		System.out.println();
    }
}
class Tree{
	public Node root;
	
	public void createNode(char data, char left, char right) {
		if(root == null) {
			root = new Node(data);
			
			if(left != '.') {
				root.left = new Node(left);
			}
			
			if(right != '.') {
				root.right = new Node(right);
			}
		}else {
			searchNode(root, data, left, right);
		}
	}
	public void searchNode(Node node, char data, char left, char right) {
		if(node == null) { // 찾을 노드 없음
			return;
		}else if(node.data == data) {
			if(left != '.') {
				node.left = new Node(left);
			}
			if(right != '.') {
				node.right = new Node(right);
			}
		}else {
			searchNode(node.left, data, left, right);
			searchNode(node.right, data, left, right);
		}
	}
	// 전위순회
	public void preOrder(Node node) {
		if(node != null) {
			System.out.print(node.data);
			if(node.left != null) {
				preOrder(node.left);
			}
			if(node.right != null) {
				preOrder(node.right);
			}
		}
	}
	// 중위순회
	public void inOrder(Node node) {
		if(node != null) {
			if(node.left != null) {
				inOrder(node.left);
			}
			System.out.print(node.data);
			if(node.right != null) {
				inOrder(node.right);
			}
			
		}
	}
	// 후위순회
	public void PostOrder(Node node) {
		if(node != null) {
			if(node.left != null) {
				PostOrder(node.left);
			}
			if(node.right != null) {
				PostOrder(node.right);
			}
			System.out.print(node.data);
		}
	}
}
class Node{
	char data;
	Node left;
	Node right;
	
	Node(char data){
		this.data = data;
	}
}
