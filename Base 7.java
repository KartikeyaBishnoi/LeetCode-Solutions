/*Given an integer num, return a string of its base 7 representation.

 

Example 1:

Input: num = 100
Output: "202"
Example 2:

Input: num = -7
Output: "-10"

  */


class Solution
{
    public String convertToBase7(int num)
    {
        int flag = 0;
        if(num == 0)
        {
            return "0";
        }
        if(num < 0)
        {
            num *= -1;
            flag = 1;
        }

        String result = "";
        while(num != 0)
        {
            result = num%7 + result;
            num /= 7;
        }
        if(flag == 1)
        {
            result = "-" + result;
        }
        return result;
        
    }
}
