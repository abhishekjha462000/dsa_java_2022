#include <iostream>
#include <vector>
#include <utility>
#include <queue>
#include <stack>
#include <deque>
#include <climits>
#include <list>
#include <algorithm>

using namespace std;
class node{
public:
	int data;
	node *left{nullptr};
	node *right{nullptr};

	node() = default;

	node(int data)
	{
		this->data = data;
	}
};

ostream& operator<<(ostream& os,const vector<int>& v)
{
	if(v.empty())
		return os << "[]";

	os << "[ ";

	for(const auto& x : v)
	{
		os << x << " ";
	}

	return os << "]";
}

class BT{
public:
	node *root{nullptr};
	int ceil_storer{INT_MAX};
	int floor_storer{INT_MIN};

	BT(const std::vector<int>& v)
	{
		stack<pair<node *,int> > st;
		

		// initialize the root
		root = new node(v[0]);

		pair<node *,int> p(root,0);

		st.push(p);

		int idx = 1;

		while(idx < v.size())
		{
			if(st.top().second == 2)
			{
				st.pop();
				continue;
			}

			if(v[idx] == -1)
			{
				st.top().second++;
				idx++;
				continue;
			}

			// Now state != 2 and v[idx] != -1
			node *child = new node(v[idx]);
			if(st.top().second == 0)
			{
				st.top().first->left = child;
			}else{
				st.top().first->right = child;
			}

			st.top().second++;
			st.push(pair<node *,int>(child,0));
			idx++;

		}
	}

	friend ostream& operator<<(ostream& os,BT& b)
	{
		b.print(b.root,os);
		return os;
	}

	void print(node *root,ostream& os)
	{
		if(root->left != nullptr)
			os << root->left->data;
		os << "<-" << root->data << "->";
		if(root->right != nullptr)
			os << root->right->data;
		os << "\n";


		if(root->left != nullptr)
			print(root->left,os);
		if(root->right != nullptr)
			print(root->right,os);
	}

	void pre_order_traverse_print()
	{
		pre_order_traverse_print_helper(root);
	}

	void pre_order_traverse_print_helper(node *root)
	{
		if(root == nullptr)
			return;

		cout << root->data << " ";
		pre_order_traverse_print_helper(root->left);
		pre_order_traverse_print_helper(root->right);
	}

	void post_order_traverse_print()
	{
		post_order_traverse_print_helper(root);
	}

	void post_order_traverse_print_helper(node *root)
	{
		if(root == nullptr)
			return;

		post_order_traverse_print_helper(root->left);
		post_order_traverse_print_helper(root->right);
		cout << root->data << " ";
	}

	void in_order_traverse_print()
	{
		in_order_traverse_print_helper(root);
	}

	void in_order_traverse_print_helper(node *root)
	{
		if(root ==  nullptr)
			return;

		in_order_traverse_print_helper(root->left);
		cout << root->data << " ";
		in_order_traverse_print_helper(root->right);
	}

	void pre_order_iterative()
	{
		stack<node *> st;

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

	void post_order_iterative()
	{
		stack<node *> ms;
		stack<node *> hs;

		ms.push(root);
		while(!ms.empty())
		{
			node *removed = ms.top();
			ms.pop();
			hs.push(removed);

			if(removed->left != nullptr)
				ms.push(removed->left);
			if(removed->right != nullptr)
				ms.push(removed->right);
		}

		while(!hs.empty())
		{
			node *removed = hs.top();
			hs.pop();
			cout << removed->data << " ";		
		}	
	}

	void in_order_iterative()
	{
		 stack<node *> ms;
		 ms.push(root);

		 while(ms.top()->left != nullptr)
		 {
		 	ms.push(ms.top()->left);
		 }

		 while(!ms.empty())
		 { 

		 	while(ms.top()->right == nullptr)
		 	{
		 		node *removed = ms.top();
		 		ms.pop();

		 		cout << removed->data << " ";

		 		if(ms.empty())
		 			break;
		 	}
		 	if(!ms.empty())
		 	{
		 		node *top = ms.top();
			 	ms.pop();
			 	
			 	cout << top->data << " ";
			 	if(top->right != nullptr)
			 		ms.push(top->right);
			 	if(!ms.empty()){
				 	while(ms.top()->left != nullptr)
				 	{
				 		ms.push(ms.top()->left);
				 	}
				 }
		 	}

		 }

	}

	void level_order_traverse_print()
	{
		queue<node *> mq;
		queue<node *> hq;

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
				swap(mq,hq);
			}
		}
	}

	void level_order_line_wise_traverse_print()
	{
		queue<node *> mq;
		queue<node *> hq;

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
				cout << "\n";
				swap(mq,hq);
			}
		}
	}

	void level_order_zig_zag_traverse_print()
	{
		stack<node *> ms;
		stack<node *> hs;

		ms.push(root);

		int level = 0;

		while(!ms.empty())
		{
			node *removed = ms.top();

			cout << removed->data << " ";

			ms.pop();

			if(level % 2 == 0)
			{
				if(removed->right != nullptr)
					hs.push(removed->right);
				if(removed->left != nullptr)
					hs.push(removed->left);
			}else{
				if(removed->left != nullptr)
					hs.push(removed->left);
				if(removed->right != nullptr)
					hs.push(removed->right);
			}

			if(ms.empty())
			{
				cout << "\n";
				ms.swap(hs);
				++level;
			}
		}
	}

	int size()
	{
		return size_helper(root);
	}

	int size_helper(node *root)
	{
		if(root == nullptr) return 0;
		return size_helper(root->left)+size_helper(root->right)+1;
	}

	int max()
	{
		return max_helper(root);
	}

	int max_helper(node *root)
	{
		if(root == nullptr)
			return INT_MIN;

		int op1 = max_helper(root->left);
		int op2 = max_helper(root->right);

		vector<int> v;
		v.push_back(op1);
		v.push_back(op2);
		v.push_back(root->data);

		sort(v.begin(),v.end());
		return v[2];
	}

	int sum()
	{
		return sum_helper(root);
	}

	int sum_helper(node *root)
	{
		if(root == nullptr)
			return 0;
		return sum_helper(root->left)+sum_helper(root->right)+root->data;
	}

	int height()
	{
		return height_helper(root);
	}

	int height_helper(node *root)
	{
		if(root == nullptr)
			return -1;

		int op1 = height_helper(root->left);
		int op2 = height_helper(root->right);

		return std::max(op1,op2)+1;
	}

	bool find(int x)
	{
		return find_helper(root,x);
	}

	bool find_helper(node *root,int x)
	{
		if(root->data == x)
			return true;

		if(root->left != nullptr)
		{
			if(find_helper(root->left,x))
				return true;
		}

		if(root->right != nullptr)
		{
			if(find_helper(root->right,x))
				return true;
		}

		return false;
	}

	vector<int> node_to_root_path(int x)
	{
		return node_to_root_path_helper(root,x);
	}

	vector<int> node_to_root_path_helper(node *root,int x)
	{
		if(root->data == x)
		{
			vector<int> base;
			base.push_back(x);
			return base;
		}

		if(root->left != nullptr)
		{
			vector<int> rres = node_to_root_path_helper(root->left,x);
			if(rres.size() > 0)
			{
				rres.push_back(root->data);
				return rres;
			}
		}

		if(root->right != nullptr)
		{
			vector<int> rres = node_to_root_path_helper(root->right,x);
			if(rres.size() > 0)
			{
				rres.push_back(root->data);
				return rres;
			}
		}

		return vector<int>();
	}

	int LCA(int x,int y)
	{
		vector<int> xPath = node_to_root_path(x);
		vector<int> yPath = node_to_root_path(y);

		if(xPath.empty() || yPath.empty())
		{
			cout << "NO LCA" << endl;
			return -1;
		}

		int i = xPath.size()-1;
		int j = yPath.size()-1;

		while(i >= 0 && j >= 0)
		{
			if(xPath[i] == yPath[j])
			{
				i--;
				j--;
			}
			else{
				break;
			}
		}

		return xPath[i+1]; // or yPath[j+1];
	}

	int distance(int x,int y)
	{
		vector<int> xPath = node_to_root_path(x);
		vector<int> yPath = node_to_root_path(y);

		if(xPath.empty() || yPath.empty())
		{
			cout << "Distance not defined" << endl;
			return -1;
		}

		int i = xPath.size()-1;
		int j = yPath.size()-1;

		while(i >= 0 && j >= 0)
		{
			if(xPath[i] == yPath[j])
			{
				i--;
				j--;
			}else{
				break;
			}
		}

		++i;
		++j;

		return i+j;
	}

	void linearize()
	{
		linearize_helper(root);
	}

	void linearize_helper(node *root)
	{
		if(root == nullptr)
		{
			return ;
		}
  
		linearize_helper(root->left);
		linearize_helper(root->right);

		if(root->left == nullptr)
			return;
		if(root->right == nullptr)
			return;

		node *left_child = root->left;
		node *right_child = root->right;

		while(left_child->left != nullptr || left_child->right != nullptr)
		{
			// move 
			if(left_child->left != nullptr)
				left_child = left_child->left;
			if(left_child->right != nullptr)
				left_child = left_child->right;
		}
 
		root->right = nullptr;

		left_child->left = right_child;
	}

	void remove_leaves()
	{
		remove_leaves_helper(root);
	}

	void remove_leaves_helper(node *root)
	{
		if(root == nullptr)
			return ;
		if(root->left != nullptr && root->right == nullptr)
		{
			// remove root->left as it a single child
			delete root->left;
			root->left = nullptr;
		}

		if(root->left == nullptr && root->right != nullptr)
		{
			delete root->right;
			root->right = nullptr;
		}

		remove_leaves_helper(root->left);
		remove_leaves_helper(root->right);
	}

	void reset_bounds()
	{
		floor_storer = INT_MIN;
		ceil_storer = INT_MAX;
	}

	int floor(int x)
	{
		floor_helper(root,x);
		int ans = floor_storer;
		reset_bounds();
		return ans;
	}

	void floor_helper(node *root,int x)
	{
		if(root->data < x)
		{
			if(floor_storer < root->data)
				floor_storer = root->data;
		}

		if(root->left != nullptr)
			floor_helper(root->left,x);
		if(root->right != nullptr)
			floor_helper(root->right,x);
	}

	int ceil(int x)
	{
		ceil_helper(root,x);
		int ans = ceil_storer;
		reset_bounds();
		return ans;

	}

	// Gives the next greater element than x in tree
	void ceil_helper(node *root,int x)
	{
		if(root->data > x)
		{
			if(root->data < ceil_storer)
			{
				ceil_storer = root->data;
			}
		}

		if(root->left != nullptr)
			ceil_helper(root->left,x);
		if(root->right != nullptr)
			ceil_helper(root->right,x);
	}

	int klargest(int k)
	{
		int ans = INT_MAX;
		for(int i=0;i<k;i++)
		{
			ans = floor(ans);
		}
		return ans;
	}

	int ksmallest(int k)
	{
		int ans = INT_MIN;

		for(int i=0;i<k;i++)
		{
			ans = ceil(ans);
		}
		return ans;
	}

	vector<int> leaves()
	{
		vector<int> v;

		leaves_helper(root,v);

		return v;
	}

	void leaves_helper(node *root,vector<int>& v)
	{
		if(root == nullptr)
			return;

		if(root->left == nullptr && root->right == nullptr)
		{
			v.push_back(root->data);
			return;
		}
		leaves_helper(root->left,v);
		leaves_helper(root->right,v);
	}

	void boundary_traversal()
	{
		stack<node *> hs;
		hs.push(root);
		vector<int> boundary;

		while(hs.top()->left != nullptr || hs.top()->right != nullptr)
		{
			if(hs.top()->left != nullptr)
			{
				hs.push(hs.top()->left);
			}else{
				hs.push(hs.top()->right);
			}
		}

		hs.pop();
		while(!hs.empty())
		{
			boundary.push_back(hs.top()->data);
			hs.pop();
		}

		reverse(boundary.begin(),boundary.end());
		for(auto& x : leaves())
		{
			boundary.push_back(x);
		}

		if(root->right != nullptr)
		{
			vector<node *> helper_vector;
			helper_vector.push_back(root->right);

			while(helper_vector.back()->left != nullptr && helper_vector.back()->right != nullptr)
			{
				helper_vector.push_back(helper_vector.back()->right);
			}

			helper_vector.pop_back();

			for(int i=helper_vector.size()-1;i >= 0;i--)
			{
				boundary.push_back(helper_vector[i]->data);
			}

		}

		for(auto &x : boundary)
		{
			cout << x << " ";
		}
	}

	vector<int> k_levels_down(int k)
	{
		vector<int> v;

		k_levels_down_helper(root,k,v);
		return v;
	}

	void k_levels_down_helper(node *root,int k,vector<int>& v)
	{
		if(root == nullptr)
			return ;
		if(k == 0)
		{
			v.push_back(root->data);
			return ;
		}

		k_levels_down_helper(root->left,k-1,v);
		k_levels_down_helper(root->right,k-1,v);
	}

	~BT()
	{
		destruct(root);
		root = nullptr;
		// cout << "deleted successfully" << endl;
	}

	void destruct(node *root)
	{
		if(root == nullptr)
			return;

		destruct(root->left);
		destruct(root->right);
		delete root;
	}
};

int main()
{
	#ifndef ONLINE_JUDGE
			freopen("input.txt","r",stdin);
			freopen("output.txt","w",stdout);
			freopen("error.txt","w",stderr);
	#endif

	int n;

	cin >> n;

	vector<int> v(n);

	for(int i=0;i<n;i++){
		cin >> v[i];
	}

	BT b(v);

	// cout << b;
	// b.pre_order_traverse_print();
	// b.level_order_traverse_print();
	// b.level_order_line_wise_traverse_print();
	// b.level_order_zig_zag_traverse_print();
	// cout << b.size() << " " << b.max() << endl;
	// cout << b.sum() << endl;
	// cout << b.height() << endl;

	// int x;
	// cin >> x;

	// cout << b.find(x) << endl;

	// int x;
	// cin >> x;

	// cerr << b.node_to_root_path(x) << endl;
	// int x;
	// int y;
	// cin >> x>> y;

	// cout << b.LCA(x,y) << endl;

	// b.linearize();

	// cout << b;
	
	// b.remove_leaves();

	// cout << b.size() << endl;

	// int x;
	// cin >> x;

	// cout << b.ceil(x)  << " " << b.floor(x) << endl;

	// int k;

	// cin >> k;

	// cout << b.ksmallest(k) << endl;

	// b.pre_order_traverse_print();
	// cout << endl;
	// b.post_order_traverse_print();
	// cout << endl;
	// b.in_order_traverse_print();
	// cout << endl;

	// cout << "Iterative ones" << endl;
	// b.pre_order_iterative();
	// cout << endl;
	// b.post_order_iterative();
	// cout << endl;
	// b.in_order_iterative();

	// vector<int> w = b.leaves();
	// b.boundary();
	// for(const auto& x : w)
	// {
	// 	cout << x << " ";
	// }
	// b.boundary_traversal();
	cout << "[ ";

	for(const auto &x : b.k_levels_down(2))
	{
		cout << x << " ";
	}

	cout << "]";

	return 0;
}
