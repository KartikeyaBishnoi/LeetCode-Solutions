/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

 

Example 1:


Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9
 */

class Solution
{
    public int trap(int[] height)
    {
        int len = height.length;
        int arr[][] = new int[2][len];
        int maxLeft = 0;
        int maxRight = 0;
        for(int i=0; i<len; ++i)
        {
            arr[0][i] = maxLeft;
            if(height[i] > maxLeft)
                maxLeft = height[i];

            arr[1][len-i-1] = maxRight;

            if(height[len-i-1] > maxRight)
                maxRight = height[len-i-1];            
        }
        int rain = 0;
        for(int i=0; i<len; ++i)
        {
            int trapped = Math.min(arr[0][i], arr[1][i]) - height[i];
            if(trapped > 0)
                rain += trapped;
        }
        return rain;


        
    }
}
