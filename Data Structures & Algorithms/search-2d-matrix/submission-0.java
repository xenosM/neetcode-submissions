class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        /*
         -> start from the mid index of search area(default=> [0] -> length) 
         -> do this while(seachStart < searchEnd)
            -> check if the target is in the matrix
                by performing ([0]< target <[last])
                    -> if true return true
            -> if(target< [0]) reduce the search area to the mid-1 index 
                ( length -> [mid+1] )
            -> else(target > [last]) reduce the search area to mid+1 index
                ([0] -> mid-1)

        */
        int searchStart = 0, searchEnd = matrix.length -1;
        while(searchStart<= searchEnd){
            int midIndex = (searchStart +searchEnd)/2 ;//middle index of the matrix
            int[] targetArray = matrix[midIndex]; //The array in the matrix in which we will be searching for the target
            if(targetArray[0] <=target && targetArray[targetArray.length -1] >= target){
                int l=0,r=targetArray.length-1;
                while(l<=r){
                    int mid = (l+r)/2;
                    if(targetArray[mid]==target){
                        return true;
                    }
                    else if(target<targetArray[mid]){
                        r=mid-1;
                    }
                    else{
                        l=mid+1;
                    }
                }
                return false;
            }
            else if(target<targetArray[0]){
                searchEnd = midIndex -1;
            }
            else{
                searchStart = midIndex+1;
            }
        }
        return false;
    }
}
