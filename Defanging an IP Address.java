/*Given a valid (IPv4) IP address, return a defanged version of that IP address.

A defanged IP address replaces every period "." with "[.]".

############################################################################################################################################### 

Example 1:

Input: address = "1.1.1.1"
Output: "1[.]1[.]1[.]1"
Example 2:

Input: address = "255.100.50.0"
Output: "255[.]100[.]50[.]0"

###############################################################################################################################################

Solution

*/class Solution
{
    public String defangIPaddr(String address)
    {
        String defanged = "";
        int len = address.length();
        for(int i=0; i<len; ++i)
        {
            char ch = address.charAt(i);
            if(ch == '.')
                defanged += "[.]";
            else
                defanged += ch;
        }
        return defanged;
        
    }
}
