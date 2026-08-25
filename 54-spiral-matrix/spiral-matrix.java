class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<>();

        int m = matrix.length;
        int n = matrix[0].length;

        int srow =0;
        int scol =0;

        int erow = m-1;
        int ecol = n-1;

        while(srow <= erow && scol <= ecol){
            for(int i= scol ; i<= ecol ;i++){
                result.add(matrix[srow][i]);
            }

            for(int j= srow+1 ; j<= erow; j++){
                result.add(matrix[j][ecol]);
            }

            if(srow< erow){
                for(int i= ecol-1; i>= scol; i--){
                    result.add(matrix[erow][i]);
                }
            }
            
            if(scol < ecol){
                for(int j= erow-1; j> srow;j--){
                    result.add(matrix[j][scol]);
                }
            }
            

            srow++;
            erow--;
            scol++;
            ecol--;

        }
        return result;
    }
}