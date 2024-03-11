/*
Given an m x n matrix, return all elements of the matrix in spiral order.

 

Example 1:


Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:


Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 
*/

class Solution
{
    public List<Integer> spiralOrder(int[][] matrix)
    {
        List<Integer> list = new ArrayList<>();
        

        int rowBegin = 0;
        int rowEnd = matrix.length-1;
        int colBegin = 0;
        int colEnd = matrix[0].length-1;

        while(rowBegin<=rowEnd && colBegin<=colEnd)
        {
            for( int i=colBegin; i<=colEnd; ++i)
            {
                list.add(matrix[rowBegin][i]);
            }
            rowBegin++;
            for(int i=rowBegin; i<=rowEnd; ++i)
            {
                list.add(matrix[i][colEnd]);
            }
            colEnd--;
        if (rowBegin <= rowEnd)
        {
            for (int j = colEnd; j >= colBegin; j--) 
            {
                list.add(matrix[rowEnd][j]);
            }
        }
        rowEnd--;

        if (colBegin <= colEnd)
        {
        // Traverse Up
            for (int j = rowEnd; j >= rowBegin; j--) 
            {
                list.add(matrix[j][colBegin]);
            }
        }
        colBegin++;
    }
        return list;

        

    }
}
