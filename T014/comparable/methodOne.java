  private static class pair implements Comparable<pair>{

        int ff;
        int ss;

        pair(int ff,int ss)
        {
            this.ff = ff;
            this.ss = ss;
        }

        @Override
        public int compareTo(pair o) // o stands for other
        {
            if(this.ff != o.ff)
                return this.ff-o.ff;
            return this.ss-o.ss;
        }

    }

    public static void main(String[] args) throws IOException{
        initializeIO();


        // comparable

        pair p1 = new pair(5,29);

        pair p2 = new pair(30,24);

        if(p1.compareTo(p2) > 0)
        {
            // p1 > p2
            System.out.println("p1 is greater than p2");
        }else{

            // p1 <= p2
            System.out.println("p1 is less than or equal to p2");
        }
    }
