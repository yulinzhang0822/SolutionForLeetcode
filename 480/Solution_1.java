class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
    
        //always make the size of minHeap equal (when there are even numbers) or 1 element more         //(when there are odd numbers) than the size of maxHeap
        for(int i = 0; i < nums.length; i++) {
            if(minHeap.size() <= maxHeap.size()) {
                maxHeap.add(nums[i]);
                minHeap.add(maxHeap.remove());
            } else {
                minHeap.add(nums[i]);
                maxHeap.add(minHeap.remove());
            }
        
            if(minHeap.size() + maxHeap.size() == k) {
                double median;
                if(minHeap.size() == maxHeap.size()) {
                    median = (double) ((long)minHeap.peek() + (long)maxHeap.peek()) / 2;
                } else {
                    median = (double) minHeap.peek();
                }
            
                int start = i - k + 1;
                result[start] = median;
                if(!minHeap.remove(nums[start])) {
                    maxHeap.remove(nums[start]);
                }
            }
        }
        return result;
    }
}
//Time:O(nk), Space:O(n)
