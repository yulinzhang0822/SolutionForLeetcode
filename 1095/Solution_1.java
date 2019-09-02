class Solution {
    private int findPeakIdxBinarySearch(MountainArray ma) {
        int left  = 0, right = ma.length() - 1, peak = 0;
        while (left < right) {
            int mid = (left + right) / 2;
            if (ma.get(mid) < ma.get(mid + 1)) {
                left = peak = mid + 1;
                continue;
            }
            right = mid;
        }
        return peak;
    }
    
    private int findInLeft(int target, int left, int right, MountainArray ma) {
        if (left > right) return -1;
        int mid = (right + left) / 2;
        if (ma.get(mid) == target) {
            return mid;
        }
        if (ma.get(mid) < target) {
            return findInLeft(target, mid + 1, right, ma);
        }
        return findInLeft(target, left, mid - 1, ma);
    }
    
    private int findInRight(int target, int left, int right, MountainArray ma) {
        if (left > right) return -1;
        int mid = (right + left) / 2;
        if (ma.get(mid) == target) {
            return mid;
        }
        if (ma.get(mid) < target) {
            return findInRight(target, left, mid - 1, ma);
        }
        return findInRight(target, mid + 1, right, ma);
    }
    
    int findInMountainArray(int target, MountainArray ma) {
        int left = 0, right = ma.length() - 1;
        int peakId = findPeakIdxBinarySearch(ma);
        if (ma.get(peakId) == target) {
            return peakId;
        }
        int leftId = findInLeft(target, 0, peakId - 1, ma);
        int rightId = findInRight(target, peakId + 1, right, ma);
        return leftId != -1 ? leftId : rightId;
    }
}
