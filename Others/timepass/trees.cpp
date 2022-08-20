#include <iostream>
#include <vector>
#include <stack>
#include <queue>
#include <deque>
#include <algorithm>
#include <utility>
#include <climits>
#define null nullptr
#define vi vector<int>
#define vii vector<pair<int,int> >
#define pb push_back
#define ppb pop_back

#define vvi vector<vi >
#define jump(x) x->next
#define tc int test_cases; cin >> test_cases; while(test_cases-- != 0)
using namespace std;

class treenode{
public:
	int data;
	vector<treenode*> children;

	treenode(){
		data = 0;
	}

	treenode(int _data){
		data = _data;
	}
};

treenode* constructGT(const vector<int>& v){
	stack<treenode*> st;
	treenode *root = new treenode(v[0]);

	st.push(root);

	int idx = 1;
	while(idx < v.size()){
		int val = v[idx];
		if(val == -1){
			st.pop();
		}else{
			treenode *remove = st.top();
			treenode *newNode = new treenode(val);
			st.top()->children.push_back(newNode);
			// st.pop();
			st.push(newNode);
		}
		idx++;
	}
	return root;
}
class node{
public:
	int data;
	node *next;

	node(){
		data = 0;
		next = nullptr;
	}
 	node(int _data){
		data = _data;
		next = nullptr;
	}
};

class linkedlist{
public:
	node *head;
	node *tail;
	int size;

	linkedlist(){
		head = tail = nullptr;
		size = 0;
	}

	void push_back(int val){
		node *n = new node(val);
		if(size == 0){
			head = tail = n;
			n = nullptr;
		}else{
			tail->next = n;
			tail = n;
			n = nullptr;
		}
		size++;
	}
	void push_front(int val){
		node *n = new node(val);
		if(size == 0){
			head = tail = n;
			n = nullptr;
		}else{
			n->next = head;
			head = n;
			n = nullptr;
		}
		size++;
	}

	void pop_back(){
		if(size == 0){
			cout << "List is empty..." << endl;
			return ;
		}

		// you are here means size is not empty
		if(size == 1){
			delete head;
			head = tail = nullptr;
			size--;
			return ;
		}

		// size is >= 2
		node *temp = head;
		while(temp->next != tail){
			temp = temp->next;
		}
		temp->next = nullptr;
		delete tail;
		tail = temp;
		temp = nullptr;
		size--;

	}

	void pop_front(){
		if(size == 0){
			cout << "List is empty..." << endl;
			return;
		}

		// size is > 0

		if(size == 1){
			delete head;
			head = tail = nullptr;
			size--;
			return;
		}

		// size is > 1

		node *curr = head;
		head = head->next;
		curr->next = nullptr;
		delete curr;
		curr = null;
		size--;
	}

	// node& front(){
	// 	if(size == 0){
	// 		cout << "List is empty..." << endl;
	// 		node *n = new node();
	// 		return *n;
	// 	}

	// 	return *head;
	// }

	int midOne(){
		if(size == 0){
			cout << "List is empty" << endl;
			return -1;
		}

		node *slow = head;
		node *fast = head;

		while(fast->next != null && fast->next->next !=null)
		{
			slow = slow->next;
			fast = fast->next->next;
		}

		return slow->data;
	}

	int midTwo(){
		if(size == 0){
			cout << "List is empty..." << endl;
			return -1;
 		}

 		node *slow = head;
 		node *fast = head;

 		while(fast != null && fast->next != null){
 			slow = slow->next;
 			fast = fast->next->next;
 		}

 		return slow->data;
	}

	node* getFirst(){
		if(size == 0)
		{
			cout << "List is empty..." << endl;
			return null;
		}
		return head;
	}

	node* getTail(){
		if(size == 0)
		{
			cout << "List is empty..." << endl;
			return null;
		}
		return tail;
	}

	node* getNodeAt(int index){
		if(index < 0 || index >= size){
			cout << "Invalid arguments..." << endl;
			return null;
		}

		if(index == 0){
			return head;
		}

		if(index == size-1)
			return tail;

		node *temp = head;

		while(index-- != 0){
			temp = temp->next;
		}
		return temp;
	}

	bool hasCycle(){
		if(size == 0){
			cout << "List is empty..." << endl;
			return false;
		}

		node *slow = head;
		node *fast = head;

		while(fast->next != null && fast->next->next != null){
			slow = slow->next;
			fast = fast->next->next;

			if(slow == fast)
			{
				return true;
			}
		}
		return false;
	}
	int headOfCycle(){
		if(hasCycle() == false)
		{
			cout << "List has no cycle"<< endl;
			return -1;
		}

		node *slow = head;
		node *fast = head;

		while(fast->next != null && fast->next->next != null){
			slow = slow->next;
			fast = fast->next->next;
			if(slow == fast)
				break;
		}

		slow = head;

		while(slow != fast){
			slow = slow->next;
			fast = fast->next;
		}
		return slow->data;
	}

	int length(){
		if(hasCycle()== false)
		{
			cout << "List is empty..." << endl;
			return -1;
		}

		node *slow = head;
		node *fast = head;

		while(fast->next != null && fast->next->next != null){
			slow = slow->next;
			fast = fast->next->next;

			if(slow == fast)
			{
				// cout << "..." << endl;
				break;
			}
		}

		slow = head;
		while(slow != fast){
			slow = slow->next;
			fast = fast->next;
		}
		// cout << "came here" << endl;

		int count = 1;
	
		// cout << " im here " << endl;
		// cout << slow->data << " " << fast->data << endl;

		while(slow->next != fast){
			slow = slow->next;
			++count;
		}

		return count;
	}

	void breakTheCycle(){
		if(hasCycle() == false)
			return ;
		node *slow = head;
		node *fast = head;

		while(fast->next != null && fast->next->next != null){
			slow = slow->next;
			fast = fast->next->next;

			if(slow == fast)
			{
				break;
			}
		}

		slow = head;

		while(slow != fast){
			slow = slow->next;
			fast = fast->next;
		}

		while(slow->next != fast){
			slow = slow->next;
		}

		slow->next = null;
		slow = null;
		fast = null;
	}
};

ostream& operator<<(ostream& os,const linkedlist& l){
	int size = l.size;
	if(size == 0)
		return os << "[]";

	node *head = l.head;
	os <<"[ ";
	while(head != nullptr){
		os << head->data << " ";
		head = head->next;
	}
	return os << "]";
}
void display(const treenode *root){
	cout << root->data << " -> ";
	for(treenode *child : root->children){
		cout << child->data << ". ";
	}
	cout << "\n";

	for(treenode *child : root->children)
	{
		display(child);
	}
}

int size(const treenode *root){

	if(root->children.size() == 0)
		return 1;
	int ans = 0;

	for(treenode *child : root->children)
	{
		ans += size(child);
	}

	return ans + 1;
}

int maxi(const treenode *root){
	if(root->children.size() == 0)
		return root->data;

	int m = INT_MIN;

	for(treenode *child : root->children)
	{
		m = max(m,maxi(child));
	}
	return max(m,root->data);
}

int sum(const treenode *root)
{
	// if(root->children.size() == 0)
	// 	return root->data;

	int s = 0;
	for(treenode *child : root->children)
		s += sum(child);
	return s + (root->data);
}

void levelOrder(treenode *root){
	queue<treenode*> mq;
	queue<treenode*> hq;

	mq.push(root);

	while(!mq.empty()){
		treenode *removed = mq.front();
		cout << removed->data << " ";

		for(treenode *child : removed->children)
			hq.push(child);

		mq.pop();

		if(mq.empty())
		{
			swap(mq,hq);

		}
	}
}

void levelOrderLineWise(treenode *root){
	queue<treenode *> mq;
	queue<treenode *> hq;

	mq.push(root);

	while(!mq.empty()){
		treenode *removed = mq.front();

		cout << removed->data << " ";
	
		for(treenode *child : removed->children)
			hq.push(child);

		mq.pop();

		if(mq.empty())
		{
			cout << "\n";
			swap(mq,hq);
		}
	}	
}

void levelOrderZigZag(treenode *root){
	stack<treenode *> ms;
	stack<treenode*> hs;

	ms.push(root);
	int level = 1;
	while(!ms.empty()){
		treenode *removed = ms.top();
		cout << removed->data << " ";

		ms.pop();

		if(level % 2 == 0){
			// push the childrens in the reverse order
			for(int i=removed->children.size()-1;i>=0;i--){
				hs.push(removed->children[i]);
			}
		}else{
			// push the childrens in the correct order
			for(treenode *child : removed->children)
				hs.push(child);
		}

		if(ms.empty())
		{
			ms.swap(hs);
			cout << endl;
			level++;
		}
	}
}

bool find(treenode *root,int x){
	if(root->data == x)
	{
		return true;
	}

	for(treenode *child : root->children){
		bool ans = find(child,x);
		if(ans == true)
			return true;
	}
	return false;
}

vi nodeToRootPath(treenode *root,int x){
	if(root->data == x)
	{
		vi v;
		v.pb(x);
		return v;
	}

	for(treenode *child : root->children)
	{
		vi v = nodeToRootPath(child,x);
		if(v.size() != 0)
		{
			v.pb(root->data);
			return v;
		}
	}
	return vector<int>();
}

int LCA(treenode *root,int x,int y){
	vi v = nodeToRootPath(root,x);
	vi w = nodeToRootPath(root,y);

	int i = v.size()-1;
	int j = w.size()-1;

	while(i >=0 && j >= 0){
		if(v[i] == w[j])
		{
			i--;
			j--;
		}else{
			break;
		}
	}
	i++;
	j++;

	return v[i];// w[j] for that matter...
}

int distance(treenode *root,int x,int y){
	vi v = nodeToRootPath(root,x);
	vi w = nodeToRootPath(root,y);

	int i = v.size()-1;
	int j = w.size()-1;

	while(i >= 0 && j >= 0){
		if(v[i] == w[j])
		{
			i--;
			j--;
		}else{
			break;
		}
	}

	i++;
	j++;
	return i+j;
}

void linearize(treenode *root){

	for(treenode *child : root->children)
	{
		linearize(child);
	}

	int lc = root->children.size()-1;
	int slc = root->children.size()-2;

	while(slc >= 0){
		treenode *lastChild = root->children[lc];
		treenode *slastchild = root->children[slc];

		while(slastchild->children.size() != 0)
		{
			slastchild = slastchild->children[0];
		}

		slastchild->children.pb(lastChild);;
		root->children.ppb();

		slc--;
		lc--;


	}

}

ostream& operator<<(ostream& os,const pair<int,int>& p){
	return os << "<" << p.first << ", " << p.second << ">";
}

void boundsHelper(treenode *root,int x,pair<int,int>& p){

	int val = root->data;
	if(val < x){
		if(val > p.first)
		{
			p.first = val;
		}
	}
	if(val > x){
		if(val < p.second)
		{
			p.second = val;
		}
	}

	for(treenode *child : root->children)
	{
		boundsHelper(child,x,p);
	}

}

pair<int,int> bounds(treenode *root,int x){
	pair<int,int> p;
	p.first = INT_MIN;
	p.second = INT_MAX;
	boundsHelper(root,x,p);// in p.first we have floor -- maximum amongst the smaller
	//in p.second we have ceil -- minimum amongst the greater than x
	return p;
}

int KTHLargest(treenode *root,int k){
	pair<int,int> p;

	int x = INT_MAX;

	// find the floor of x in root
	for(int i=0;i<k;i++){
		p = bounds(root,x);
		// cout << p << endl;
		x = p.first;
	}
	return p.first;
}



ostream& operator<<(ostream& os,const vector<int>& v){
	if(v.size()==0)
		return os <<"[]";

	os << "[ ";

	for(const auto &x: v)
		os << x <<" ";
	return os <<"]";
}

int main(){
	#ifndef ONLINE_JUDGE
		freopen("input.txt","r",stdin);
		freopen("output.txt","w",stdout);
		freopen("error.txt","w",stderr);
	#endif

	vector<int> v = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
	treenode *root = constructGT(v);


	tc{
		int k;
		cin >> k;
		cout << KTHLargest(root,k) << endl;


	}	
	// linearize(root);
	// levelOrderLineWise(root);



	// display(root);
	// cout << size(root) << endl;
	// cout << maxi(root) << endl;
	// cout << sum(root) << endl;

	// const treenode *temp = root;
	// levelOrder(root);
	// levelOrderLineWise(root);
	// levelOrderZigZag(root);
	// temp->data = 90;// not allowed

	// for(treenode *child : temp->children)
	// 	child = null;

	return 0;
}
