//Binary Search
class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int lo = 1, hi = 100000;
        while(lo<hi) {
            int mid = (lo+hi)/2;
            if(!canShip(weights, D, mid)) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
    public boolean canShip(int[] weights, int D, int capacity) {
        int num = 0, tmpWeight = 0;
        for(int weight: weights) {
            if(weight>capacity) {
                return false;
            }
            if(tmpWeight+weight<=capacity) {
                tmpWeight+=weight;
            } else {
                num++;
                tmpWeight = weight;
            }
        }
        if(tmpWeight>0) {
            num++;
        }
        return num <= D;
    }
}
//Time:O(WlogN), Space:O(1)
