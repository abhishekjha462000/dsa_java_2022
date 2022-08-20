// stack.top() might be null so make a check of that.... 
#include <iostream>
#include <stack>

#define nline "\n"
using namespace std;
class node{
  public:
  int data{0};
  node *left{nullptr};
  node *right{nullptr};
  
  node(int data)
  {
    this->data = data;
  }
  node(int data,node *left,node *right)
  {
      this->data = data;
      this->left = left;
      this->right = right;
  }
};

void helper(node *root,string& answer){
    
    if(root == nullptr)
    {
        return ;
    }
    
    string ans = "";
    
    ans = "<-" + to_string(root->data) + "->";
    
    if(root->left != nullptr)
    {
        ans = to_string(root->left->data) + ans;
    }
    
    if(root->right != nullptr)
    {
        ans = ans + to_string(root->right->data);
    }
    ans = ans + nline;
    
    answer += ans;
    
    helper(root->left,answer);
    helper(root->right,answer);
}
ostream& operator<<(ostream& cout,node *root){
    
    string ans = "";
    
    helper(root,ans);
    
    
    return cout << ans;
}

node *constructBT(){
    int data;
    cin >> data;
    
    if(data == -1)
    {
        return nullptr;
    }
    
    node *root = new node(data);
    
    root->left = constructBT();
    root->right = constructBT();
    
    return root;
    
}

void pre_order(node *root)
{
    if(root == nullptr)
        return ;
    
    cout << root->data << " ";
    
    pre_order(root->left);
    pre_order(root->right);
}

void post_order(node *root)
{
    if(root == nullptr)
    {
        return ;
    }
    
    
    post_order(root->left);
    post_order(root->right);
    
    cout << root->data << " ";

}

void in_order(node *root)
{
    if(root == nullptr)
    {
        return ;
    }
    
    in_order(root->left);
    
    cout << root->data << " ";
    
    in_order(root->right);
    
}

void pre_order_iterative(node *root)
{
    stack<node *> st;
    
    st.push(root);
    
    while(!st.empty())
    {
        node *removed = st.top();
        
        
        cout << removed->data << " ";
        st.pop();
        
        if(removed->right != nullptr)
            st.push(removed->right);
            
        if(removed->left != nullptr)
            st.push(removed->left);
    }
}

void post_order_iterative(node *root)
{
    // mainStack -- 8 4 
    // helperStack -- 10 9 5
    stack<node *> mainStack;
    stack<node *> helperStack;
    
    mainStack.push(root);
    
    while(!mainStack.empty())
    {
        node *removed = mainStack.top();
        mainStack.pop();
        
        helperStack.push(removed);
        
        if(removed->left != nullptr)
        {
            mainStack.push(removed->left);
        }
        
        if(removed->right != nullptr)
        {
            mainStack.push(removed->right);
        }
    }
    
    while(!helperStack.empty())
    {
        cout << helperStack.top()->data<< " ";
        helperStack.pop();
    }
}

void in_order_iterative(node *root)
{
    stack<node *> st;
    st.push(root);
    while((st.top())->left != nullptr)
    {
        st.push(st.top()->left);
    }
    
    while(!st.empty())
    {
        while(st.top()->right == nullptr)
        {
            node *removed = st.top();
            st.pop();
            
            cout << removed->data << " ";
            
            if(st.empty() == true)
                break;
        }
        
        if(!st.empty())
        {
            node *removed = st.top();
            st.pop();
            
            cout << removed->data << " ";
            
            st.push(removed->right);
            
            while((st.top())->left != nullptr)
            {
                st.push(st.top()->left);
            }
        }
    }
}

int32_t main()
{
    // node *root{nullptr};
    
    node *root = constructBT();
    
    in_order_iterative(root);
    cout << endl;
    in_order(root);
    
    return 0;
}
