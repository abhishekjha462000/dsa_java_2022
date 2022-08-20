    public static void main(String[] args) throws IOException{
        initializeIO();

        /**
         * PriorityQueue is a DS used to store the elements on the basis of their priority
         * 
         * Insertion and deletion works in O(log n) and peek operation works in O(1)
         **/


        /**
         * If we create a PriorityQueue of integers then by default the minimum element is given the highest priority
         **/


        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(50);
        pq.add(40);
        pq.add(30);


        System.out.println(pq); // [30,40,50]


        System.out.println(pq.peek()); // shows the element with max priority


        pq.remove(); // removes the element with maximum priority

        System.out.println(pq); // [40,50]

        /**
            System.out.println(pq.size()); // 2

            pq.clear(); // clears the PriorityQueue


            System.out.println(pq); // []
        **/

        

        /**
         * For giving max priority to the maximum element, we use Collections.reverseOrder()
         **/


        PriorityQueue<Integer> max = new  PriorityQueue<>(Collections.reverseOrder());


        max.add(10);
        max.add(20);
        max.add(30);
        max.add(40);


        System.out.println(max); // [40,30,20,10]

        System.out.println(max.peek()); // 40


        max.remove(); // 40 removed as it was the element of highest Priority


        System.out.println(max.peek()); // 30 since this is the element with max priority as it is maximum

    }
