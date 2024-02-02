/*
An integer has sequential digits if and only if each digit in the number is one more than the previous digit.

Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.

 

Example 1:

Input: low = 100, high = 300
Output: [123,234]
Example 2:

Input: low = 1000, high = 13000
Output: [1234,2345,3456,4567,5678,6789,12345]
*/

import java.util.*;
class Solution
{
    List <Integer> list = new ArrayList<>();
    public List<Integer> sequentialDigits(int low, int high)
    {
        
        for(int i=1; i<=9; ++i)
        {
            solve(i,i,low,high);
        }
        Collections.sort(list);
        return list;        
    }

    public void solve(int num, int digit, int low, int high)
    {
        if(num>=low && num<=high)
        {
            list.add(num);
        }
        if(num>high || digit>=9)
        {
            return;
        }
        solve(num*10+(digit+1), digit+1, low, high);
    }
}
