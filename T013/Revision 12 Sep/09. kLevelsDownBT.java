// We assume that the root is at 0th level
    private static List<Integer> kLevelsDown(Node node, int k){
        
        if(node == null)
            return new ArrayList<>();
        
        if(k == 0){
            List<Integer> base = new ArrayList<>();
            base.add(node.data);
            return base;
        }

        // stores the final ans
        List<Integer> ans = new ArrayList<>();

        // go to the left of the node and collect all the nodes that are k-1 levels down
        List<Integer> leftAns = kLevelsDown(node.left,k-1);

        // go to the right of the node and collect all the nodes that are k-1 levels down
        List<Integer> rightAns = kLevelsDown(node.right, k-1);


        // store the nodes that are in left and right (which are k-1 levels down) in the final answer to be returned
        for(int left : leftAns)
            ans.add(left);
        for(int right : rightAns){
            ans.add(right);
        }

        return ans;

    }