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

int max(int a,int b,int c)
{
	vector<int> v;
	v.push_back(a);
	v.push_back(b);
	v.push_back(c);

	sort(all(v));
	return v[2];
}
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

	int size(){
		return sizeHelper(root);
	}

	int sizeHelper(node *root){
		if(root == nullptr)
			return 0;

		int size = 0;

		if(root->left != nullptr)
			size += sizeHelper(root->left);
		if(root->right != nullptr)
			size += sizeHelper(root->right);
		return size+1;
	}

	int max(){
		return maxHelper(root);
	}

	int maxHelper(node *root){
		if(root == nullptr)
			return INT_MIN;

		return ::max(maxHelper(root->left),maxHelper(root->right),root->data);
	}

	int sum(){
		return sumHelper(root);
	}

	int sumHelper(node *root){
		if(root == nullptr)
			return 0;
		return sumHelper(root->left)+sumHelper(root->right)+root->data;
	}

	int avg(){
		return sum()/size();
	}

	void levelOrder(){
		queue<node*> mq;
		queue<node*> hq;

		mq.push(root);

		while(!mq.empty())
		{
			node *removed = mq.front();

			cout << removed->data << " ";

			mq.pop();

			if(removed->left != nullptr)
				hq.push(removed->left);
			if(removed->right != nullptr)
				hq.push(removed->right);

			if(mq.empty())
			{
				mq.swap(hq);

			}
		}
	}

	void levelOrderLineWise(){
		queue<node*> mq;
		queue<node*> hq;

		mq.push(root);

		while(!mq.empty())
		{
			node *removed = mq.front();

			cout << removed->data << " ";

			mq.pop();

			if(removed->left != nullptr)
				hq.push(removed->left);
			if(removed->right != nullptr)
				hq.push(removed->right);

			if(mq.empty())
			{
				cout << endl;
				mq.swap(hq);
			}
		}
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
			node *removed = st.top();
			st.pop();

			cout << removed->data << " ";
			if(removed->right != nullptr)
				st.push(removed->right);
			if(removed->left != nullptr)
				st.push(removed->left);

		}
	}

};

int main(){
	#ifndef ONLINE_JUDGE
		freopen("input.txt","r",stdin);
		freopen("output.txt","w",stdout);
		freopen("error.txt","w",stderr);
	#endif

	vi v = {50,25,12,-1,-1,37,30,-1,-1,-1,75,62,-1,70,-1,-1,87,-1,-1};
	BT b(v);
	// cout << b;
	// cout << b.size() << endl;
	// cout << b.max() << endl;
	// cout << b.sum() << endl;
	// cout << b.avg() << endl;
	// b.levelOrder();
	// cout << endl;
	// b.levelOrderLineWise();

	b.preOrder();
	cout << endl;
	b.preOrderIterative();

	return 0;
}
