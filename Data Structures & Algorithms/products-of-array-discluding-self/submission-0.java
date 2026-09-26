class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        int totalProduct =1;
        int zeroCount =0;
        for(int num:nums){
            if(num ==0) zeroCount++;
            if(zeroCount==2){
                totalProduct = 0;
                break;
            }
            if(num != 0 ){
                totalProduct*=num;
            }
        }
        for(int i=0; i<nums.length;i++){
            if (zeroCount>=1){
                output[i]=nums[i] == 0? totalProduct: 0;
            }
            else{
                output[i] = totalProduct/nums[i];
            }
        }
        return output;
    }
}  
