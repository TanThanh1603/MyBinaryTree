package BBB;

import java.util.*;

public class Queue {
	Node tail,head;
	Scanner sc = new Scanner(System.in);
	Queue(){
		head=tail = null;
	}
	void AddQ(int x) {
		Node t = new Node(x);
		if(head==null) head=tail=t;
		else {
			tail.next = t;
			tail = t;
		}
	}
	int RemoveQ()
	{	int x=0;
		if(head==null )System.out.print("\nHang doi rong");
		else 
		{	
			x=head.data;
			if(head.next==null) head=tail=null;
			else head=head.next;
		}
		return x;
	}
}
