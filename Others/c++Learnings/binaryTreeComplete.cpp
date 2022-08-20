#include <bits/stdc++.h>
#define all(x) x.begin(), x.end()
#define vi vector<int>
#define vvi vector<vi >
#define vii vector<pair<int,int> >

using namespace std;

ostream& operator<<(ostream& os, const vi& v){
	if(v.empty())
		return os << "[]";

	os << "[ ";

	for(const auto& x : v)
	{
		os << x << " ";
	}

	return os << "]";
}

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

void print(stack<node*> st){
	if(st.size() == 0)
	{
		cout << "[]" << endl;
		return;
	}

	cout << "[ ";

	vector<int> v;
	while(!st.empty())
	{
		node *removed = st.top();
		v.push_back(removed->data);
		st.pop();
	}
	int i=0;
	int j = v.size()-1;

	while(i<=j){
		swap(v[i],v[j]);
		i++;
		j--;
	}

	for(const auto& x : v)
	{
		cout << x << " ";
	}

	cout << "]";
}

class BT{
	node *root{nullptr};
public:
	BT(){
		root = nullptr;
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

	friend ostream& operator<<(ostream& os,BT& b){
		// node *root = b.root;
		// BT().printHelper(b.root,os);
		b.printHelper(b.root,os);
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

	vi nodeToRootPath(int x)
	{
		return nodeToRootPathHelper(root,x);
	}

	vi nodeToRootPathHelper(node *root,int x){
		if(root->data == x)
		{
			vi v;
			v.push_back(x);
			return v;
		}

		// vi finalAns;

		if(root->left != nullptr)
		{
			vi v = nodeToRootPathHelper(root->left,x);

			if(!v.empty())
			{
				v.push_back(root->data);
				return v;
			}
		}

		if(root->right != nullptr)
		{
			vi v = nodeToRootPathHelper(root->right,x);

			if(!v.empty())
			{
				v.push_back(root->data);
				return v;
			}
		}

		return vector<int>();

	}

	vi klevelsDown(int k)
	{
		vector<int> v;

		klevelsDownHelper(root,k,v);

		return v;
	}

	void klevelsDownHelper(node *root,int k,vector<int>& v){
		if(root == nullptr)
		{
			return ;
		}

		// or this is better
		// if(k == 0)
		// {
		// 	v.push_back(root->data);
		// 	return;
		// }

		if(k < 0)
			return;
		if(k == 0)
			v.push_back(root->data);

		klevelsDownHelper(root->left,k-1,v); // do not write k-- here
		klevelsDownHelper(root->right,k-1,v); // do not write k-- here
	}

	vi printSingleChild(){
		vi v;

		printSingleChildHelper(root,v);

		return v;
	}

	void printSingleChildHelper(node *root,vi& v){
		if(root == nullptr)
			return;

		if(root->left == nullptr && root->right != nullptr)
		{
			v.push_back(root->right->data);
			// return; // this would be a mistake
		}

		if(root->left != nullptr && root->right == nullptr)
		{
			v.push_back(root->left->data);
			// return; // this would be a mistake
		}

		printSingleChildHelper(root->left,v);
		printSingleChildHelper(root->right,v);
	}

	~BT(){
		if(root != nullptr)
		{
			stack<node*> hs;
			stack<node*> ms;

			hs.push(root);

			while(!hs.empty()){
				node *removed = hs.top();
				hs.pop();
				ms.push(removed);

				if(removed->left != nullptr)
					hs.push(removed->left);
				if(removed->right != nullptr)
					hs.push(removed->right);

			}

			// cout << ms << endl;
			// print(ms);

			while(!ms.empty())
			{
				delete ms.top();
				ms.top() = nullptr;
				ms.pop();
			}

			// cout << "Successfully deleted" << endl;
		}
	}

};

int main(){
	#ifndef ONLINE_JUDGE
		freopen("input.txt","r",stdin);
		freopen("output.txt","w",stdout);
		freopen("error.txt","w",stderr);
	#endif
	/*
		Tree diagram
			50
		   /  \
		  25   75
		 / \   / \
		12 37 62  87
			/  \
		   30  70

	*/

	// vi v = {50,25,12,-1,-1,37,30,-1,-1,-1,75,62,-1,70,-1,-1,87,-1,-1};
	vi v;

	int n;
	cin >> n;

	for(int i=0;i<n;i++)
	{
		int x;
		cin >> x;
		v.push_back(x);
	}
	BT b(v);
	
	// int x;

	// cin >> x;

	// vi w = b.nodeToRootPath(x);

	//  klevelsdown

	// int k;

	// cin >> k;

	// vi w = b.klevelsDown(k);

	// cout << w << endl;

	// cout << b << endl;

	vi w = b.printSingleChild();

	cout << w << endl;

	return 0;
}
