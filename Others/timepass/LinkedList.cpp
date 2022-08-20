#include <bits/stdc++.h>
using namespace std;
class node{
public:
	int data;
	node *next;
	node();
	node(int val);
	~node();
};
node::node(){
	this->data = 0;
	next = NULL;
}
node::node(int data){
	this->data = data;
	next = NULL;
}
node::~node(){
	delete next;
	next = NULL;
}
class LinkedList{
public:
	node *head;
	node *tail;
	int size;

	LinkedList(){
		head = tail = NULL;
		size = 0;
	}
	void push_front(int val);
	void push_back(int val);
	void pop_front();
	void pop_back();
	// void size();
	bool empty();
	void clear();

};
void LinkedList::clear(){
	while(size != 0){
		pop_front();
	}
}
bool LinkedList::empty(){

	return size == 0;
}
void LinkedList::push_front(int val){
	node *n = new node(val);
	if(head == NULL && tail == NULL){
		head = tail = n;
	}else{
		n->next = head;
		head = n;
	}
	size++;
}
void LinkedList::push_back(int val){
	node *n = new node(val);
	if(head == NULL && tail == NULL){
		head = tail = n;
	}else{
		tail->next = n;
		tail = n;
	}
	size++;
}
void LinkedList::pop_front(){
	if(size == 0){
		return ;
	}else if(head == tail){
		node *n = head;
		head = tail = NULL;
		delete n;
		size--;
	}else{
		node *n = head;
		head = head->next;
		n->next = NULL;
		delete n;
		size--;
	}
}
void LinkedList::pop_back(){
	if(size == 0){
		return ;
	}else if(head == tail){
		node *n = head;
		head = tail = NULL;
		
		delete n;
		size--;
	}else{
		node *n = head;
		while(n->next !=tail){
			n = n->next;
		}
		node *replace = tail;
		tail = n;
		tail->next = NULL;
		n = NULL;
		delete replace;
		size--;
	}
}
ostream& operator<<(ostream& os,const LinkedList& ll){
	node *temp = ll.head;
	if(ll.size == 0)
		return os << "[]";
	os << "[ ";
	while(temp != NULL){
		os << temp->data << " ";
		temp = temp->next;
	}
	os << "]";
	return os;
}
int main(){ 
	#ifndef ONLINE_JUDGE
		freopen("input.txt","r",stdin);
		freopen("output.txt","w",stdout);
		freopen("error.txt","w",stderr);
	#endif
	LinkedList ll;
	ll.push_front(20);
	ll.push_back(30);
	ll.push_front(34);
	ll.push_front(45);
	ll.pop_front();
	ll.pop_back();
	cout << ll << endl;
	cout << &ll << "-->" << ll.size << endl;
	ll.clear();
	cout << &ll << "-->" << ll.size << endl;


	return 0;
}
