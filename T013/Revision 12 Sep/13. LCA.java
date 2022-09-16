private static int LCA(Node node, int x, int y){
        List<Integer> pathx = NTRP(node, x);
        List<Integer> pathy = NTRP(node, y);


        int i = pathx.size()-1;
        int j = pathy.size()-1;

        while(i >= 0 && j >= 0){
            if(pathx.get(i) == pathy.get(j)){
                i--;
                j--;
            }else{
                break;
            }
        }

        // LCA would be present at i+1 index of pathx or j+1 index of pathy

        return pathx.get(i+1); // return pathy.get(j+1)
    }


    // Helper function NTRP
    private static List<Integer> NTRP(Node node, int val){
        if(node == null)
            return new ArrayList<>();

        if(node.data == val)
        {
            List<Integer> base = new ArrayList<>();
            base.add(val);
            return base;
        }

        // check for val in the left subtree
        List<Integer> leftAns = NTRP(node.left, val);
        if(leftAns.size() != 0)
        {
            leftAns.add(val);
            return leftAns;
        }

        // if it was not present in the left subtree then check it in the right subtree
        List<Integer> rightAns = NTRP(node.right, val);

        if(rightAns.size() != 0)
        {
            rightAns.add(val);
            return rightAns;
        }


        return new ArrayList<>();
    }






    // ROUGH WORK











