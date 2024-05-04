/*
You are given an array people where people[i] is the weight of the ith person, and an infinite number of boats where each boat can carry a maximum weight of limit.
Each boat carries at most two people at the same time, provided the sum of the weight of those people is at most limit.

Return the minimum number of boats to carry every given person.

 

Example 1:

Input: people = [1,2], limit = 3
Output: 1
Explanation: 1 boat (1, 2)
Example 2:

Input: people = [3,2,2,1], limit = 3
Output: 3
Explanation: 3 boats (1, 2), (2) and (3)
Example 3:

Input: people = [3,5,3,4], limit = 5
Output: 4
Explanation: 4 boats (3), (3), (4), (5)


Intuition
The problem involves distributing people into boats such that each boat can carry at most two people. The goal is to minimize the number of boats used. Since the boat’s capacity is limited by the given weight limit, we should pair the heaviest person with the lightest person who can fit within the limit.

Approach
Sort the array of people in ascending order.
Initialize two pointers, i and j, pointing to the start and end of the array.
While i is less than or equal to j:
a. If the sum of weights of people at indices i and j is less than or equal to the limit, increment i.
b. Decrement j.
c. Increment the boat count.
Return the total number of boats used.
Complexity
Time complexity:
O(nlogn)
(due to sorting)
Space complexity:
O(1)
(no extra space used)
Code
*/

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int boats = 0;
        Arrays.sort(people);
        int i=0,j=people.length-1;
        while(i<=j){
            if((people[j]+people[i])<=limit){
                i++;
            }
            j--;
            boats++;
        }
        return boats;
    }
}
