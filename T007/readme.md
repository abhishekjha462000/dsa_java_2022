Finally I got the error in targetSumSubsets problem which i submitted on 6th July. The main problem in that algorithm was ki it was taking too much time on nados due to which it was not getting submitted for 2 test cases(out of total 5 test cases).

The reason why it was taking too much time on those 2 test cases was that ki we were forced to know the choice of each element of the array. But we could just have simply returned when sum started exceeding target. This would have saved us from further calls.


And as soon as I added the below line in the code, my code got submitted in the first go. It was 2:26(midnight) on 7th August 2022.
  ```
  if(sum > target)
      return ;
  ```
  
  Abhishek Jha <br>
  2:40 (midnight) <br>
  7th August 2022
