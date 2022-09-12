private static void levelOrder(Node node){

    	// Two Queue Method
    	Queue<Node> mainQ = new ArrayDeque<>();
    	Queue<Node> helperQ = new ArrayDeque<>();

    	// add the root of the tree inside the main queue
    	mainQ.add(node);

    	while(!mainQ.isEmpty()){

    		// remove the Node at the front
    		Node removed = mainQ.remove();

    		System.out.print(removed.data + " ");

    		if(removed.left != null)
    			helperQ.add(removed.left);

    		if(removed.right != null)
    			helperQ.add(removed.right);


    		if(mainQ.isEmpty()){
    			// swap the references of mainQ and helperQ
    			Queue<Node> temp = mainQ;
    			mainQ = helperQ;
    			helperQ = temp;

    			// give a line break
    			System.out.println();
    		}
    	}

    }




    // ROUGH WORK






    