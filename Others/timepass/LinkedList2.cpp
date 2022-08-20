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
	int& front();
	int& back();
	// void size();
	bool empty();
	void clear();
	void push(int index,int val);
	void pop(int index);
	int midValue1();
	node* midNode();

};
node* LinkedList::midNode(){
	if(size == 0){
		return NULL;
	}else{
		node *slow = head;
		node *fast = head;
		while(fast->next!=NULL && fast->next->next!=NULL){
			slow = slow->next;
			fast = fast->next->next;
		}
		return slow;

	}
}
int LinkedList::midValue1(){
	if(size == 0){
		cout << "List is empty..." << endl;
		return -1;
	}else{
		node *slow = head;
		node *fast = head;
		while(fast->next != NULL && fast->next->next != NULL){
			// cout << "hello" << endl;
			slow = slow->next;
			fast = fast->next->next;
			// cout << slow->data << " " << fast->data << endl;
		}
		return slow->data;
	}
}
void LinkedList::pop(int index){
	if(size == 0){
		return ;
	}else{
		// size is not zero
		if(index <0 || index >=size){
			return ;
		}else if(index == 0){
			pop_front();
		}else if(index == size-1){
			pop_back();
		}else{
			// index is in 1 to size-2 also size is atleast 3 as size-2>=1
			node *prev = NULL;
			node *curr = head;
			while(index--!=0){
				prev = curr;
				curr = curr->next;
			}
			prev->next = curr->next;
			curr->next = NULL;
			delete curr;
			curr = NULL;
			size--;
		}
	}
}
void LinkedList::push(int index,int val){
	if(index < 0 || index > size){
		return;
	}else if(index == 0){
		push_front(val);
	}else if(index == size){
		push_back(val);
	}else{
		node *prev = NULL;
		node *curr = head;
		while(index--!=0){
			prev = curr;
			curr = curr->next;
		}
		node *n = new node(val);
		prev->next = n;
		n->next = curr;
		size++;
	}
}
int& LinkedList::front(){
	return (head->data);
}
int& LinkedList::back(){
	return (tail->data);
}

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
	// cout << &ll << "-->" << ll.size << endl;
	// ll.clear();
	// cout << &ll << "-->" << ll.size << endl;
	ll.front() = 90;
	cout << ll << endl;
	ll.push(1,-89);
	cout << ll.size << endl;
	for(int i = 0;i<5;i++){
		ll.push_back(i+1);
	}

	cout << ll << endl;
	ll.pop(3);
	cout << ll << endl;
	// cout << ll.size << endl;
	// cout << ll.midValue1() << endl;
	// ll.pop(3);
	// cout << ll.midValue1() << endl;
	return 0;
}
