/*Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.

 

Example 1:

Input: n = 2
Output: [0,1,1]
Explanation:
0 --> 0
1 --> 1
2 --> 10
Example 2:

Input: n = 5
Output: [0,1,1,2,1,2]
Explanation:
0 --> 0
1 --> 1
2 --> 10
3 --> 11
4 --> 100
5 --> 101*/


class Solution
{
    public int[] countBits(int n)
    {
        int count[] = new int[n+1];
        for(int i=0; i<=n; ++i)
        {
            count[i] = NumberOfOnes(i);
        }
        return count;       
    }

    public int NumberOfOnes(int num)
    {
        String bin = makeBinary(num);
        int len = bin.length();
        int ones = 0;
        for(int i=0; i<len; ++i)
        {
            char ch = bin.charAt(i);
            if(ch == '1')
            {
                ones++;
            }
        }
        return ones;
    }

    public String makeBinary(int num)
    {
        String bin = "";
        while(num != 0)
        {
            bin = num%2 + bin;
            num /= 2;
        }
        return bin;        
    }
}
