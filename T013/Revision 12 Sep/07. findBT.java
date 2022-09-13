private static boolean find(Node node, int x){
        if(node == null)
            return false;

        if(node.data == x)
            return true;

        // find x in the left subtree
        boolean leftAns = find(node.left, x);

        // if you find in the left subtree then return true else move to the right subtree
        if(leftAns == true)
            return leftAns;

        /**
         * If we are here then that means final answer would be decided by the right subtree.
         */

        // find x in the right subtree
        boolean rightAns = find(node.right, x);

        return rightAns;
    }



    // ROUGH WORK



    