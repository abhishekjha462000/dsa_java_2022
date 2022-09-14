private static void removeLeafNodes(Node node){
        if(node == null)
            return;

        if(node.left != null){
            // check if it is a leaf node or not
            if(node.left.left == null && node.left.right == null)
                node.left = null;
        }

        if(node.right != null){
            // check if it is a leaf node or not
            if(node.right.left == null && node.right.right == null)
                node.right = null;
        }

        removeLeafNodes(node.left);
        removeLeafNodes(node.right);
    }


    // ROUGH WORK




    