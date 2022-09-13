private static void iterativeTraversals(Node node){
        String pre = "";
        String in = "";
        String post = "";

        Stack<Pair> st = new Stack<>();
        st.push(new Pair(node, 1));

        while(st.size() > 0){
            Pair top = st.peek();

            if(top.state == 1){
                pre += top.node.data + " ";
                top.state++;
                // if it has left then move to the left
                if(top.node.left != null){
                    // add this left node of "top.node" to the stack
                    st.push(new Pair(top.node.left, 1));

                }
            }else if(top.state == 2){
                in += top.node.data + " ";
                top.state++;

                if(top.node.right != null){
                    // add this right node of "top.node" to the stack
                    st.push(new Pair(top.node.right, 1));
                }
            }else{
                // add to post
                post += top.node.data + " ";

                st.pop();
            }
        }


        System.out.println(pre);
        System.out.println(in);
        System.out.println(post);


    }



    // ROUGH WORK







    