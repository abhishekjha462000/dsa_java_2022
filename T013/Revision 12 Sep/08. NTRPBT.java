private static List<Integer> NTRP(Node node, int x){
        if(node == null){
            return new ArrayList<>();
        }
        
        if(node.data == x)
        {
            List<Integer> base = new ArrayList<>();
            base.add(x);
            return base;
        }

        List<Integer> leftAns = NTRP(node.left, x);

        if(leftAns.size() != 0)
        {
            leftAns.add(node.data);
            return leftAns;
        }

        List<Integer> rightAns = NTRP(node.right, x);

        if(rightAns.size() != 0){
            rightAns.add(node.data);
            return rightAns;
        }

        return new ArrayList<>();
    }


    // ROUGH WORK





    