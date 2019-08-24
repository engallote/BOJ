import java.util.*;

public class Main {
	static int N;
	static Tree[] tree;
	static boolean[] visit = new boolean[26];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		tree = new Tree[N];
		
		for(int i = 0; i < N; i++)
		{
			String root = sc.next();
			String left = sc.next();
			String right = sc.next();
			tree[i] = new Tree(root, left, right);
		}
		preorder("A");
		System.out.println();
		inorder("A");
		System.out.println();
		lastorder("A");
		
	}
	private static void preorder(String root) {
		System.out.print(root);
		for(int i = 0; i < N; i++)
			if(tree[i].root.equals(root))
			{
				if(!tree[i].left.equals("."))
					preorder(tree[i].left);
				if(!tree[i].right.equals("."))
					preorder(tree[i].right);
			}
	}
	private static void inorder(String root) {
		for(int i = 0; i < N; i++)
			if(tree[i].root.equals(root))
			{
				if(!tree[i].left.equals("."))
					inorder(tree[i].left);
				System.out.print(root);
				if(!tree[i].right.equals("."))
					inorder(tree[i].right);
			}
	}
	private static void lastorder(String root) {
		for(int i = 0; i < N; i++)
			if(tree[i].root.equals(root))
			{
				if(!tree[i].left.equals("."))
					lastorder(tree[i].left);
				if(!tree[i].right.equals("."))
					lastorder(tree[i].right);
				System.out.print(root);
			}
	}
}
class Tree{
	String root, left, right;
	Tree(String root, String left, String right){
		this.root = root;
		this.left = left;
		this.right = right;
	}
}