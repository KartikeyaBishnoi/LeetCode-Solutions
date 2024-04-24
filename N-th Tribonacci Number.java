/*
The Tribonacci sequence Tn is defined as follows: 

T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.

Given n, return the value of Tn.

 

Example 1:

Input: n = 4
Output: 4
Explanation:
T_3 = 0 + 1 + 1 = 2
T_4 = 1 + 1 + 2 = 4
Example 2:

Input: n = 25
Output: 1389537
 

Constraints:

0 <= n <= 37
The answer is guaranteed to fit within a 32-bit integer, ie. answer <= 2^31 - 1.



Intuition
The problem is to calculate the n-th Tribonacci number.
The Tribonacci sequence is a sequence of numbers where each number is the sum of the three preceding ones, starting from 0, 1, and 1.

Approach
The problem is to calculate the n-th Tribonacci number.
The Tribonacci sequence is a sequence of numbers where each number is the sum of the three preceding ones, starting from 0, 1, and 1.

Complexity
Time complexity:
The time complexity of the function is O(n),
where n is the input to the function. This is because the function iterates from 3 to n to calculate the n-th Tribonacci number.
Space complexity:
The space complexity of the function is O(1),
as it uses a constant amount of space to store the last three Tribonacci numbers and the current Tribonacci number.
Code

*/
class Solution
{
    public int tribonacci(int n)
    {
        if(n == 1 || n == 2)
            return 1;
        if(n == 0)
            return 0;
        int t0 = 0;
        int t1 = 1;
        int t2 = 1;
        int tn = 0;
        for(int i=3; i<=n; ++i)
        {
            tn = t0+t1+t2;
            t0 = t1;
            t1 = t2;
            t2 = tn;           
        }
        return tn;
        
    }
}
