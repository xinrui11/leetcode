package RotateImage;

import java.util.HashMap;
import java.util.Map;

/**
 *You are given an n x n 2D matrix representing an image.

 Rotate the image by 90 degrees (clockwise).

 Note:
 You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
 DO NOT allocate another 2D matrix and do the rotation.

 Example 1:

 Given input matrix =
 [
     [1,2,3],
     [4,5,6],
     [7,8,9]
 ],

 rotate the input matrix in-place such that it becomes:
 [
     [7,4,1],
     [8,5,2],
     [9,6,3]
 ]
 Example 2:

 Given input matrix =
 [
     [ 5, 1, 9,11],
     [ 2, 4, 8,10],
     [13, 3, 6, 7],
     [15,14,12,16]
 ],

 rotate the input matrix in-place such that it becomes:
 [
     [15,13, 2, 5],
     [14, 3, 4, 1],
     [12, 6, 8, 9],
     [16, 7,10,11]
 ]
 */

public class RotateImage {
    //this my solution,but it's accepted,only beats 2%
    //main idea is exchange directly
    public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length ==0 || matrix[0] == null || matrix[0].length == 0){
            return;
        }
        int height = matrix.length;
        int allcount = 0,alllength = height*height;
        Map<String,Boolean> map = new HashMap<>();
        for(int i = 0; i < height; i++){
            for(int j = 0; j < height; j++){
                if(map.get(i+","+j) != null)
                    continue;
                allcount = exchange(height,i,j,matrix,allcount,map);
                if(alllength == allcount)
                    break;
            }
            if(alllength == allcount)
                break;
        }
    }

    private int exchange(int height, int i, int j, int[][] matrix,int allcount,Map<String,Boolean> map){
        int y = height - 1 - i;
        if(map.get(j+","+y) == null){
            int temp = matrix[i][j];
            map.put(j+","+y,true);
            allcount = exchange(height,j,y,matrix,allcount,map);
            matrix[j][y] = temp;
            return allcount + 1;
        }
        return allcount;
    }

    //Solution in discuss
    /**
     [
         [1,2,3],          [1,4,7],           [7,4,1],
         [4,5,6],   -->    [2,5,8],    -->    [8,5,2],
         [7,8,9]           [3,6,9]            [9,6,3]
     ]
     */
    public void rotate2(int[][] matrix) {
        int size = matrix.length;
        for(int i = 0; i < size; i++){
            for(int j = i; j < size; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size/2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][size - j - 1];
                matrix[i][size - j - 1] = temp;
            }
        }
    }
}
