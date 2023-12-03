#include <bits/stdc++.h>
using namespace std;

struct TNode{
	int data;
	TNode *left,*right;
	TNode (int x){ data=x;left=right=NULL;}
	TNode (int x , TNode *ll,TNode *rr){
		data=x;
		left=ll;
		right=rr;
	}
};
class Tree{
	TNode *root;
	public :
	void taocay(){
		TNode *a = new TNode(10, new TNode(8), new TNode(12));
		TNode *b = new TNode(20, new TNode(16), new TNode(25));
		root= new TNode (15, a, b);
	}
	void taocayT2()
	{
		TNode *a = new TNode(6, new TNode(5), new TNode(11));
		TNode *b = new TNode(7, new TNode(2),a);
		TNode *c = new TNode(5, NULL, new TNode(9, new TNode(4), NULL));
		root = new TNode(2, b, c);
	}
	void duyet1(TNode *T) {
		if(T!= NULL) 
		{
		cout<<" "<<T->data; 
		duyet1(T->left); 
		duyet1(T->right);
		}
	}
	void d1(TNode *T){
		if(T!=NULL){
			cout<< T->data << " ";
			d1(T->left);
			d1 (T->right);
		}
	}
	void d2(TNode *T){
		if(T!=NULL){
			d1(T->left);
			cout<< T->data << " ";
			d1 (T->right);
		}
	}
	void d3(TNode *T){
		if(T!=NULL){
			d1(T->left);
			d1 (T->right);
			cout<< T->data << " ";
		}
	}
	
	int getmax(){
		if(root != NULL) return 0;
		else{
			TNode *p=root;
			while(p->right != NULL) p=p->right;
			return p->data;
		}
	}
//	bool timx(TNode *T,int x){
//		if(T == NULL) return false;
//		else if (T->data==x)
//			return true;
//		else if(T->data<x) 
//			return timx(T->right);
//		else return timx(T->left);
//	}
	TNode chenx(TNode *T,int x){
		if (T == NULL) return false;
		else if (T->data = x) return false ;
		else if (T->data < x) return T->left;
		else return T->right;
	}
};
class MyBST
{
	TNode *root;
	TNode *chenbst(TNode *&T,int x)
	{
		
	}
	void taocayBST(){
		
	}
	void chieurong(){
		
	}
};
int main() {
	Tree *T= new Tree();
	T->taocay();
	T->getmax();
	}
