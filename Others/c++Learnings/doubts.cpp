#include <iostream>
#include <vector>
#include <utility>
#include <stack>
#include <queue>
#include <algorithm>
#define all(x) x.begin(), x.end()
#define vi vector<int>
#define vvi vector<vi >
#define vii vector<pair<int,int> >

using namespace std;

class node{
	public:
		int data;
		node *left;
		node *right;

		node(){
			data = 0;
			left = right = nullptr;
		}

		node(int data){
			this->data = data;
			left = right = nullptr;
		}
};

class BT{
public:
	node *root;
public:
	BT(){
	}
	BT(const vi& v){
		// create a pair with initial state 0 and having root node in it
		stack<pair<node*,int> > st;
		root = new node(v[0]);
		pair<node*,int> p(root,0);
		st.push(p);

		int idx = 1;

		while(idx < v.size())
		{
			pair<node *,int> p = st.top();
			int state = p.second;
			int val = v[idx];

			if(state == 2)
			{
				st.pop();
				continue;
			}

			if(val == -1)
			{
				// will think for here
				// p.second++;
				st.top().second++;
				idx++;
				continue;
			}

			// Now the value is not -1 and state is not 2

			node *newNode = new node(val);

			if(state == 0)
			{
				st.top().first->left = newNode;
				// p.first->left = newNode;
			}else{
				st.top().first->right = newNode;
				// p.first->right = newNode;
			}

			st.top().second++;
			st.push(pair<node*,int>(newNode,0));
			idx++;

		}
	}

	friend ostream& operator<<(ostream& os,const BT& b){
		// node *root = b.root;
		BT().printHelper(b.root,os);
		return os;
	}

	void printHelper(node *root,ostream& os){
		if(root == nullptr)
			return;

		if(root->left != nullptr)
			os << (root->left)->data;
		os <<  " <- " << root->data << " -> ";

		if(root->right != nullptr)
			os << root->right->data;
		os << endl;
		printHelper(root->left,os);
		printHelper(root->right,os);
	}

	void preOrder(){
		preOrderHelper(root);
	}

	// DO NOT TOUCH THIS...
	void preOrderHelper(node *root){
		if(root == nullptr)
			return ;

		cout << root->data << " ";
		preOrderHelper(root->left);
		preOrderHelper(root->right);
	}

	void preOrderIterative(){
		stack<node*> st;
		st.push(root);

		while(!st.empty())
		{
			cout << "In me " << endl;
			node *removed = st.top();
			st.pop();

			cout << removed->data << " ";
			if(removed->right != nullptr)
				st.push(removed->right);
			if(removed->left != nullptr)
				st.push(removed->left);

		}
		// cout << "out of it " << endl;
	}
// 	~BT(){
// 		stack<node*> st;

// 		st.push(root);
// 		stack<node*> ms;


// 		while(!st.empty()){
// 			node *removed = st.top(); 
// 			ms.push(removed);
// 			st.pop();

// 			if(removed->left != nullptr)
// 				st.push(removed->left);
// 			if(root->right != nullptr)
// 				st.push(removed->right);
// 		}

// 		while(!ms.empty())
// 		{
// 			delete ms.top();
// 			ms.top() = nullptr;
// 			ms.pop();
// 		}
// 		cout << "Successfully deleted..." << endl;
// 	}
	// void destruct(node *root){
	// 	if(root == nullptr)
	// 		return ;

	// 	destruct(root->left);
	// 	root->left = nullptr;
	// 	destruct(root->right);
	// 	root->right = nullptr;
	// 	delete root;
	// }
	// ~BT(){
	// 	destruct(root);
	// }


};

void destruct(node *root){
		if(root == nullptr)
			return ;

		destruct(root->left);
		root->left = nullptr;
		destruct(root->right);
		root->right = nullptr;
		delete root;
		// root = nullptr;
}

int size(node *root){
	if(root == nullptr)
		return 0;

	int ans = 0;

	ans += size(root->left)+size(root->right)+1;
	return ans;
}
int main(){
	#ifndef ONLINE_JUDGE
		freopen("input.txt","r",stdin);
		freopen("output.txt","w",stdout);
		freopen("error.txt","w",stderr);
	#endif

	vi v = {50,25,12,-1,-1,37,30,-1,-1,-1,75,62,-1,70,-1,-1,87,-1,-1};
	BT b(v);

	// b.preOrder();
	// cout << endl;
	// b.preOrderIterative();

	cout << size(b.root) << endl;
	destruct(b.root);
	cout << "out 1 " << endl;
	delete b.root;
	b.root = nullptr;
	cout << "out "<< endl;
	// cout << b.root->data << endl;
	cout << size(b.root) << endl;

	return 0;
}
