    private static char mostFrequentCharacter(String str)
    {
        HashMap<Character,Integer> cmap = new HashMap<>();

        for(int i = 0; i < str.length();i++)
        {
            char ch = str.charAt(i);
            cmap.put(ch,cmap.getOrDefault(ch,0)+1);
        }

        // System.out.println(cmap);

        char ans = str.charAt(0);
        int freq = Integer.MIN_VALUE;

        for(Character ch : cmap.keySet())
        {
            if(cmap.get(ch) > freq)
            {
                freq = cmap.get(ch);
                ans = ch;
            }
        }

        return ans;
    }
