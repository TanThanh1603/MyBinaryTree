package BBB;

import java.util.Scanner;

public class MyStack {
	Scanner doc = new Scanner(System.in);
	Node top;
	MyStack(){
		top=null;
	}
	void CreateS() {
		top=null;
	}
	boolean Empty() {
		return top==null;
	}
	void Push(int x) {
		top=new Node(x,top);
	}
	int Pop() {
		int x=0;
		if(top == null) System.out.println("\n Ngan xep rong");
		else {
			x=top.data;
			top=top.next;
		}
		return x;
	}
	void nhap() {
		int x;
		do {
			x=doc.nextInt();
			Push(x);
			if(x==0) break;
		}while(x!=0);
	}
	
	void in() {
		MyStack t = new MyStack();
		System.out.println("\nNoi dung ngan xep: ");
		while(!Empty()) {
			int x = Pop();
			System.out.print(x+ " ");
			t.Push(x);
		}
		while(t.Empty()) {
			int x = t.Pop();
			Push(x);
		}
		
	}
	int tonggiatri() {
		MyStack t = new MyStack();
		int x; int k=0;
		while(!Empty())
		{
			x=Pop();
			k+=x;
			t.Push(x);
		}
		while(t.Empty()) {
			x=t.Pop();
			Push(x);
		}
		return k;
		
	}
	public static void main(String[]args) {
		MyStack S = new MyStack();
		S.in();
		S.nhap();
	}
}
