    public static void main(String[] args) throws IOException{
        initializeIO();

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        List<List<Integer>> lists = new ArrayList<>();


        for(int i=0;i<n;i++)
        {
            lists.add(new ArrayList<>());
        }

        for(int i = 0;i < n;i++)
        {
            int size = scn.nextInt();;

            for(int j = 0;j <size;j++)
            {
                lists.get(i).add(scn.nextInt());
            }
        }

        System.out.println(mergeKLists(lists));

    }


    private static List<Integer> mergeKLists(List<List<Integer>> lists)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i < lists.size();i++)
        {
            List<Integer> list = lists.get(i);

            for(int j = 0; j < list.size();j++)
            {
                pq.add(list.get(j));
            }
        }

        while(pq.size() != 0)
        {
            ans.add(pq.remove());
        }

        return ans;

    }
