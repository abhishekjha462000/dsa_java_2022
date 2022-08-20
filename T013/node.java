class node{
	int data;
	node left;
	node right;

	node(){}
	node(int data)
	{
		this.data = data;
	}
	node(int data,node left,node right){
		this.data = data;
		this.left = left;
		this.right = right;
	}
}