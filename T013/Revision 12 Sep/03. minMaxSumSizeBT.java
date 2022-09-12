    private static int size(Node node){
    	if(node == null)
    		return 0;

    	// 1 for the node itself
    	return size(node.left) + size(node.right) + 1;
    }

    private static int sum(Node node){
    	if(node == null)
    		return 0;

    	// find the sum of the left subtree and the right subtree and add your value to it
    	return sum(node.left) + sum(node.right) + node.data;
    }

    private static int max(Node node){
    	if(node == null)
    		return Integer.MIN_VALUE;

    	// find the max in the left subtree
    	int leftMax = max(node.left);

    	// find the max in the right subtree
    	int rightMax = max(node.right);

    	// find the maximum among the leftMax and rightMax and the data of the node itself
    	return Math.max(leftMax, Math.max(rightMax, node.data));
    }

    private static int min(Node node){
    	if(node == null)
    		return Integer.MAX_VALUE;

    	// find the minimum from the left subtree
    	int leftMin = min(node.left);

    	// find the minimum from the right subtree
    	int rightMin = min(node.right);

    	// find the minimum among leftMin and rightMin and the data of the node itself.
    	return Math.min(leftMin, Math.min(rightMin, node.data));

    }





    // ROUGH WORK



    
