private static List<Integer> leafNodes(Node node){
        if(node == null)
            return new ArrayList<>();

        if(node.left == null && node.right == null){
            List<Integer> base = new ArrayList<>();
            base.add(node.data);
            return base;
        }

        // collect all the leaf nodes from the left subtree
        List<Integer> leftAns = leafNodes(node.left);

        // collect all the leaf nodes from the right subtree
        List<Integer> rightAns = leafNodes(node.right);

        // store all the leaf nodes in a single arrayList and then return
        List<Integer> ans = new ArrayList<>();

        for(int left : leftAns)
            ans.add(left);

        for(int right : rightAns)
            ans.add(right);


        return ans;
    }



    // ROUGH WORK






    