/*
You are given a string sentence that consist of words separated by spaces. Each word consists of lowercase and uppercase letters only.

We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.) The rules of Goat Latin are as follows:

If a word begins with a vowel ('a', 'e', 'i', 'o', or 'u'), append "ma" to the end of the word.
For example, the word "apple" becomes "applema".
If a word begins with a consonant (i.e., not a vowel), remove the first letter and append it to the end, then add "ma".
For example, the word "goat" becomes "oatgma".
Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
For example, the first word gets "a" added to the end, the second word gets "aa" added to the end, and so on.
Return the final sentence representing the conversion from sentence to Goat Latin.

 ###############################################################################################################################################

Example 1:

Input: sentence = "I speak Goat Latin"
Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
Example 2:

Input: sentence = "The quick brown fox jumped over the lazy dog"
Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"

###############################################################################################################################################

Solution:

*/

class Solution
{
    public String toGoatLatin(String sentence)
    {
        sentence+=" ";
        int len = sentence.length();
        String goat = "";
        String word = "";
        int count = 0;
        for(int i=0; i<len ;++i)
        {
            char ch = sentence.charAt(i);
            if(ch == ' ')
            {
                count++;
                char c = word.charAt(0);
                if(c=='a' || c=='A' || c=='e' || c=='E' || c=='i' || c=='I' || c=='o' || c=='O' ||     c=='u' || c=='U')
                    goat += word + "ma";
                
                else
                    goat += word.substring(1)+word.charAt(0)+"ma";

                for(int j=1; j<=count; ++j)
                {
                    goat += "a";
                }
                goat += " ";
                word = "";
            }
            else
            {
                word += ch;
            }
        }
        return goat.trim();
        
    }
}
 
