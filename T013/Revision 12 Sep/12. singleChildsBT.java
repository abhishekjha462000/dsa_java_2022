private static List<Integer> singleChild(Node node){
        if(node == null)
            return new ArrayList<>();

        // if "node" has only left child
        if(node.left == null && node.right != null){
            List<Integer> base = new ArrayList<>();
            base.add(node.right.data);
            return base;
        }

        // if "node" has only right child
        if(node.left != null && node.right == null){
            List<Integer> base = new ArrayList<>();
            base.add(node.left.data);
            return base;
        }

        // collect all the single childs from left subtree
        List<Integer> leftAns = singleChild(node.left);

        // collect all the single childs from right subtree
        List<Integer> rightAns = singleChild(node.right);

        // add all the single childs into the final answer to be returned
        List<Integer> ans = new ArrayList<>();

        for(int i : leftAns)
            ans.add(i);
        for(int i : rightAns)
            ans.add(i);

        return ans;
    }


    // ROUGH WORK







    