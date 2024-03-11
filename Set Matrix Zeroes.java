/*
Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

You must do it in place.

 

Example 1:


Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]
Example 2:


Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 
*/

class Solution
{
    public void setZeroes(int[][] matrix)
    {
        boolean firstRow = false, firstCol = false;
        int rlen = matrix.length;
        int clen = matrix[0].length;

        for(int i=0; i<rlen; ++i)
        {
            for(int j=0; j<clen; ++j)
            {
                if(matrix[i][j] == 0)
                {
                    if(i==0)
                        firstRow = true;
                    if(j==0)
                        firstCol = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }//if
            }//for j
        }//for i
        
        for(int i=1; i<rlen; ++i)
        {
            for(int j=1; j<clen; ++j)
            {
                if(matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
        }

        if(firstRow)
        {
            for(int i=0; i<clen; ++i)
            {
                matrix[0][i] = 0;
            }
        }

        if(firstCol)
        {
            for(int i=0; i<rlen; ++i)
            {
                matrix[i][0] = 0;
            }
        }
    }
}
