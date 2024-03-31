/* A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all 
non-alphanumeric characters, it reads the same forward and backward.
Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

 ############################################################################################################################

Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.

Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.

Example 3:

Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.

#################################################################################################################################

Solution:1
 */
class Solution
{
    public boolean isPalindrome(String s)
    {
        int left = 0;
        int right = s.length()-1;

        while(left < right)
        {
            char l = s.charAt(left);
            char r = s.charAt(right);

            if(Character.isLetterOrDigit(l) == false)
            {
                left++;
                continue;
            }

            if(Character.isLetterOrDigit(r) == false)
            {
                right--;
                continue;
            }

            String ll = l+"";
            String rr = r+"";

            if(ll.equalsIgnoreCase(rr) == false)
                return false;

            left++;
            right--;
        }
        return true;
        
    }
}










//solution 2
class Solution
{
    public boolean isPalindrome(String s)
    {
        String str = "";
        int len = s.length();
        for(int i=0; i<len; ++i)
        {
            char c = (s.charAt(i));
            if(Character.isUpperCase(c))
                str+=(char)(c+32);
            else if(Character.isLowerCase(c))
                str+=(char)(c);
            else if(Character.isDigit(c))
                str+=(char)(c);
        }
        len = str.length();
        s = "";
        for(int i=0; i<len; ++i)
        {
            s = str.charAt(i) + s;
        }
        if(str.equalsIgnoreCase(s))
            return true;
        return false;
        
    }
}
