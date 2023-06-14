package BBB;
import java.util.*;
public class MySLL2{
	Node head;
	Scanner sc = new Scanner(System.in);
	MySLL2()
	{
		head = null;
	}
	void inputList()
	{
		System.out.print("Nhap list: ");
		int x;
		while(true)
		{
			x=sc.nextInt();
			if(x==0)
				break;
			if(head == null)
				this.head=new Node(x);
			else 
				this.head=new Node(x, this.head);
		}
	}
	
	void outputList()
	{
		System.out.println("\nNoi dung danh sach. ");
		Node p = head;
		while(p!=null)
			{
				System.out.print(p);
				p=p.next;
			}
		System.out.print("Null"+"\n");
		
	}
	static int CountDeQuy(Node t)
	{
		if(t==null)	return 0;
		else 
			return 1+CountDeQuy(t.next);
	}
	int CountNodeDeQuy()
	{
		return CountDeQuy(head);
	}
	
	static int TongNodeDS(Node t)
	{
		if(t==null)
		{
			return 0;
		}else return t.data + TongNodeDS(t.next);
	}
	int TongNode()
	{
		return TongNodeDS(head);
	}
	static int TongNodeDSLe(Node t)
	{
		if(t==null)
			return 0;
		else
		{
			if(t.data %2 !=0)
				return 1+TongNodeDSLe(t.next);
			else
				return TongNodeDSLe(t.next);
		}
	}
	int TongNodeLe()
	{
		return TongNodeDSLe(head);
	}
	static void outputLast(Node t)
	{
		if(t == null)
			System.out.println("Ds = null");
		else if( t.next == null)
			System.out.println(t.data);
		else outputLast(t.next);
	}
	void LastOutput()
	{
		outputLast(head);
	}
	
	
	void inNodeK(Node t, int k)
	{
		if(t== null)
		{
			System.out.println("Ds rong");
		}else if (k == 1)
		{
			System.out.println(t.data);
		}else inNodeK(t.next, k-1);
	}
	void inK_ds(int k)
	 {
		 inNodeK(head,k);
	 }
	Node chenk(Node t, int x, int k)//Node head
	{
		if(k==1)
		{
//			Node newNode = new Node(x);
//			newNode.next= head;
//			return newNode;
			t = new Node(x,t);
		}else if(t == null && k <1 ){
//			head.next= chenk(head.next, x, k-1);
//			return head.next;
			System.out.println("Ds ko chen dc. ");
			
		}else t.next= chenk(t.next, x, k-1);
		return t;
		
	}
	void chenk_dq(int x, int k)
	{
		head = chenk(head, x, k);
	}
	
	Node xoak(Node t, int k)
	{
		if(t==null)
		{
			System.out.println("Vi tri xoa ko hop le. ");
		}else if(k==1) t=t.next;
				else t.next = xoak(t.next, k-1); 
	return t;
	}
	int f(TNode T) { 
		if(T==null) return 0; 
		else return 1+ ( f(T.left) + f(T.right)); 
		}
	void xoak_dq(int k)
	{
		head = xoak(head, k);
	}
public static void main(String[] args) {
		MySLL2 m = new MySLL2();
		m.inputList();
		m.outputList();
		System.out.println("Trong list co tong : "+m.CountNodeDeQuy());
		System.out.println(m.TongNode());
		System.out.println(m.TongNodeLe());
//		m.LastOutput();
		//m.inK_ds(0);
//		m.chenk_dq(500, 1);
		
	}
}

