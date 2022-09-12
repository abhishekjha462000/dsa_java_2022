private static void display(Node node){
    	if(node == null)
    		return;

        // create the basic string
    	String temp = " <- " + node.data + " -> ";

        // add the data for the right
    	temp += (node.right != null) ? (node.right.data) : (".");

        // add the data for the left
    	temp = ((node.left != null) ? (""+node.left.data) : (".")) + temp;
    	
    	// You do the work for node
    	System.out.println(temp);

    	// Let the recursion do the work for both of 'em.
    	display(node.left);
    	display(node.right);
    }


// logic 2
private static void display(Node node){
        if(node == null)
            return;
        String temp = " <- " + node.data + " -> ";

        if(node.left == null){
            temp = "." + temp;
        }else{
            temp = node.left.data + temp;
        }

        // add the data for the right node of "node"

        if(node.right == null){
            temp = temp + ".";
        }else{
            temp = temp + node.right.data;
        }

        
        System.out.println(temp);


        // Let the recursion do the work for left and right part
        display(node.left);
        display(node.right);

    }