package BBB;



class Node{
	Node next;
	int data;
	Node(int x) {data = x; next = null;}
	Node(int x , Node t) {data = x;next = t;}
	public String toString () {return data + " --> ";}
	
}
public class MySLL{
	Node head;
	MySLL(){head=null;}
	void add(int x) {
		head = new Node(x,head);
	}
	void in() {
		System.out.println("Danh sach du lieu luu tru: ");
		Node p = head;
		while(p!=null) {
			System.out.print(p);p=p.next;
		}
		System.out.println(" null ");
	}
	public static void main (String[]args) {
		MySLL a = new MySLL();
		a.add(3);a.add(4);a.add(5);
		a.in();
	}
}
