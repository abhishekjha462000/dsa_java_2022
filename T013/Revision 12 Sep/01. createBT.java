private static Node createBT(int[] nums){
    	Node root = new Node(nums[0]);
    	Stack<Pair> st = new Stack<>();

    	st.push(new Pair(root, 0));

    	int idx = 1;

    	while(idx < nums.length){
    		// See the state of the element at the top of the stack
    		Pair top = st.peek();

    		int state = top.state;

    		if(state == 2){
    			st.pop();
    			continue;
    		}

    		// state is not 2 so it must be 0 or 1

    		int val = nums[idx];
    		if(val == -1){
    			top.state++;
    			idx++;
    			continue;
    		}

    		// Now, we can make a new node with value as val
    		Node newNode = new Node(val);


    		if(state == 0){
    			// newNode would be connected on the left
    			top.node.left = newNode;
    		}else{
    			top.node.right = newNode;
    		}

    		top.state++;

    		st.push(new Pair(newNode, 0));
    		idx++;
    	}

    	return root;
    }



    // ROUGH WORK





    