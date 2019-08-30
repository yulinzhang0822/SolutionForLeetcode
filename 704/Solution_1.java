class Solution {
    public int search(int[] nums, int target) {
        if(nums.length==1&&nums[0]!=target) {
            return -1;
        }
        int start = 0, end = nums.length-1, res = -1;
        while(start<=end) {
            int mid = start + (end-start)/2;
            if(nums[mid]==target){
                res = mid;
                break;
            }
            if(nums[mid]<target) {
                start = mid+1;
            } else {
                end = mid - 1;
            }
        }
        return res;
    }
}
//Time:O(logn), Space:O(1)
