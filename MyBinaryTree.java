package BBB;

import java.util.*;

class TNode{
	int data;
	TNode left,right;
	TNode(int x)
	{
		data=x;
		left=right=null;
	}
	TNode(int x , TNode p,TNode q){
		data=x;
		left=p;
		right=q;
	}
	
}
class NodeReference {
    private Node node;
    private NodeReference(Node node) {
        this.node = node;
    }

    public int getElement() {
        return node.data;
    }
    
    public void setElement(int e) {
        node.data = e;
    }
}
public class MyBinaryTree {
	TNode root;
	Scanner sc = new Scanner(System.in);
	void taocayT() {
		TNode A = new TNode(7,new TNode(2),new TNode(6));
		TNode B = new TNode(5,null,new TNode(9));
		root = new TNode(2,A,B);
	}
	int sn(TNode T)
	{
		if(T==null) return 0;
		else
			return 1+sn(T.left) + sn(T.right);
	}
	int sn1() {
		return sn(root);
	}
	TNode chendd(int x, TNode T)
	{
		if(T==null) {
			T=new TNode(x);
		}
		else if (sn(T.left)> sn(T.right))
			T.right = chendd(x,T.right);
		else
			T.left = chendd(x,T.left);
		return T;
	}
	
	
	void nhapcay() {
		int x;
		root=null;
		while(true) {
			x=sc.nextInt();
			if(x==0) break;
			else {
				if(x!=0) {
				root=chendd(x,root);}
			}
			}
	}
	void duyet1(TNode T) {
		if(T!=null) {
			System.out.println(" " +T.data);
			duyet1(T.left);
			duyet1(T.right);
		}
	}
	void duyettientu1() {
		duyet1(root);
	}
	void duyet2(TNode T) {
		if(T != null) {
			duyet2(T.left);
			System.out.println(" "+T.data);
			duyet2(T.right);
		}
	}
	void duyettrungtu() {
		duyet2(root);
	}
	int tong(TNode T) {
		if(T ==null )return 0;
		else return T.data + tong(T.left)+ tong(T.right);
	}
	int tongnot() {
		return tong(root);
	}
	int sola(TNode T) {
		if(T ==null )return 0;
		else if (T.left == null && T.right == null) return 1;
			else
			return sola(T.left) + sola(T.right);
	}
	int sola() {
		return sola(root);
	}
	int lale(TNode T) {
		if(T ==null )return 0;
		else if (T.data %2 != 0) return T.data + lale(T.left) + lale(T.right);
		else
			return lale(T.left) + lale(T.right);
	}
	int lale() {
		return lale(root);
	}
	int chieucao(TNode T) {
		if(T ==null )return 0;
		else return 1+Math.max(chieucao(T.left),chieucao(T.right));
	}
	int chieucao() {
		return chieucao(root);
	}
	boolean cb(TNode T) {
		if(T == null )return true;
		else 
			if(Math.abs(chieucao(T.left) - chieucao(T.right))>1) return false;
			else
				return cb(T.left) && cb(T.right);
	}
	boolean cb(){
		return cb(root);
	}
	int cao(TNode T)
	{
		if(T ==null )return 0;
		else return 1 + Math.max(cao(T.left), cao(T.right));
	}
	int cao() {
		return cao(root);
	}
	int timx(int x,TNode T) {
		if(T ==null )return 0;
		else if(T.data == x) return 1;
		else if(timx(x,T.left) == 0) return 1;
		else return timx(x,T.right);
	}
	///tim mức của 1 nốt
	int muc1not(TNode T,int x) {
		if(T ==null )return 0;
		else if (T.data == x) return 1;
		else if(timx(x,T.left)==1) return 1+muc1not(T.left,x);
		else
			return 1+muc1not(T.right,x);
	}
	int muc1not(int x) {
		return muc1not(root,x);
	}
	///in tất cả các nốt ở mức thứ k
	/// tìm mức có nhiều nốt nhất
	/// cho biết mức có tổng các nốt lớn nhất
	/// tìm giá trị lớn nhất trong cây
	public int findMaxInTree(TNode root) {
        int max = Integer.MIN_VALUE;     //set a default max value
        if (root == null)
            return max;                 //if root is null
        else {
            int left_max = findMaxInTree(root.left);           //get left side max
            int right_max = findMaxInTree(root.right);         //get right side max
            if (left_max > right_max)                               //if left>right
                max = left_max;                                     //set max=left
            else
                max=right_max;                                      //else set max=right

            if (root.data > max)                           //if root is greater than max of left or right
                max = root.data;                              //set max=root

        }
        return max;                                                //return max
    }
	int max() {
		return findMaxInTree(root);
	}
	/// tìm giá trị nhỏ nhất trong cây
	public int FindMinInTree(TNode T) {
		int min = Integer.MAX_VALUE;
		if(T==null) 
			return 999;
		else {
			int min_left = FindMinInTree(T.left);
			int min_right = FindMinInTree(T.right);

					if(min_left < min_right)
						min = min_left;
					else
						min = min_right;

					
					if (T.data < min)                          
		                min = T.data;   
		}
		return min;
	}
	int min() {
		return FindMinInTree(root);
	}
	TNode tx(int x, TNode T) {
		if (T == null)
			System.out.println("Cay rong, khong xoa dc");
		else if (x < T.data)
			T.left = tx(x, T.left);
		else if (x > T.data)
			T.right = tx(x, T.right);
		else {

			if (T.left == null && T.right == null)
				T = null;
			else if (T.left == null)
				T = T.right;
			else if (T.right == null)
				T = T.left;
			else {
				TNode p = T.left;
				while (p.right != null)
					p = p.right;
				T.data = p.data;
				T.left = tx(p.data, T.left);
			}
		}
		return T;
	}
	TNode tx(int x) {
		return tx(x,root);
	}
	public static void main(String []args) {
		MyBinaryTree n = new MyBinaryTree();
		n.nhapcay();
		n.duyettrungtu();
	}
}
