/*
Given an integer n, return true if it is a power of four. Otherwise, return false.

An integer n is a power of four, if there exists an integer x such that n == 4x.

 

Example 1:

Input: n = 16
Output: true
Example 2:

Input: n = 5
Output: false
Example 3:

Input: n = 1
Output: true
 
*/

//Solution 1:
class Solution
{
    public boolean isPowerOfFour(int n)
    {
        if(n == 2147483647)
            return false;
        for(int i=0; i<101; ++i)
        {
            if((int)Math.pow(4,i) == n)
                return true;
            if((int)Math.pow(4,i) > n)
                return false;
        }
        return false;
        
    }
}


//Solution 2:
class Solution
{
    public boolean isPowerOfFour(int n) 
    {
        double res = Math.log(n)/Math.log(4);
        if((int)(res) == res)
        {
            return true;
        }       
        return false;
    }
}

//Solution 3:
class Solution
{
    public boolean isPowerOfFour(int n)
    {
        if (n == 0)
            return false;
        if (n == 1)
            return true;

        if (n % 4 != 0)
            return false;

        return isPowerOfFour(n / 4);
    }
}
