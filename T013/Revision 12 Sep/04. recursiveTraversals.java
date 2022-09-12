private static void preRec(Node node){
    	if(node == null)
    		return ;

    	// print the data
    	System.out.print(node.data + " ");

    	// call the left and right part
    	preRec(node.left);
    	preRec(node.right);
    }

    private static void postRec(Node node){
    	if(node == null)
    		return ;

    	// call left and right
    	postRec(node.left);
    	postRec(node.right);

    	// print your data
    	System.out.print(node.data + " ");
    }

    private static void inRec(Node node){
    	if(node == null)
    		return ;

    	// call left
    	inRec(node.left);

    	// print your data
    	System.out.print(node.data + " ");

    	// call right
    	inRec(node.right);
    }




    // ROUGH WORK








    