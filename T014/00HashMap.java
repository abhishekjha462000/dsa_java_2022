    public static void main(String[] args) throws IOException{
        initializeIO();
  
        /**
         * insertion,deletion,updation,lookup -- all are O(1) on average (very very important point)
         **/
        HashMap<String,Integer> pmap = new HashMap<>();
        pmap.put("India",130);
        pmap.put("China",200);
        pmap.put("Aus",23);


        System.out.println(pmap); // {China=200, Aus=23, India=130}


        /**
         * Updation of the value is also done through put function
         **/

        pmap.put("Aus",50);

        System.out.println(pmap); // {China=200, Aus=50, India=130}


        /**
         * Retreiving values from HashMap
         **/

        int populationIndia = pmap.get("India"); // bad practice -- Use Integer Wrapper Class

        System.out.println(populationIndia);

        /**
         * If we pass an invalid key in get function, it returns null. So it is always better to use Integer in case of getting values from HashMap
         **/

        // int unitedStatesPopulation = pmap.get("US"); // This would give null pointer exception


        Integer unitedStatesPopulation = pmap.get("US");


        System.out.println(unitedStatesPopulation); // null


        /**
         * While using get function, it is always better that we use containsKey method
         **/

        System.out.println(pmap.containsKey("US")); // false

        System.out.println(pmap.containsKey("India")); // true



        /**
         * We can get all the keys of HashMap using keySet method
         **/

        Set<String> keys = pmap.keySet(); 

        System.out.println(keys); // [China, Aus, India]


        for(String key : keys)
        {
            System.out.print(key+"-->"+pmap.get(key)+"  ");
        }
        
        /**
         * Removing a key from HashMap
         **/

        pmap.remove("China");
        System.out.println(pmap); // {Aus=50, India=130}


        System.out.println(pmap.size()); // 2

        /**
            pmap.clear(); // empties the HashMap

            System.out.println(pmap); // {}
        **/
        
        /**
         * We can get all the keys of HashMap using keySet method
         **/

        Set<String> keys = pmap.keySet(); 

        System.out.println(keys); // [China, Aus, India]


        for(String key : keys)
        {
            System.out.print(key+"-->"+pmap.get(key)+"  ");
        }


        /**
         * Iterating over a HashMap
         **/

        Set<Map.Entry<String,Integer>> sst = pmap.entrySet();
        System.out.println(sst);

        for(Map.Entry<String,Integer> e : pmap.entrySet())
            System.out.println(e.getKey()+" @@ "+ e.getValue());


        /**
         * To get values in a HashMap we use values method, this method returns Collections 
         **/

        Collection<Integer> values = pmap.values();
        System.out.println(values);

    }
