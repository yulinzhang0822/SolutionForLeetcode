//Heap
//When driving past a gas station, let's remember the amount of fuel it contained. 
//We don't need to decide yet whether to fuel up here or not - for example, there 
//could be a bigger gas station up ahead that we would rather refuel at.

//When we run out of fuel before reaching the next station, we'll retroactively fuel up: 
//greedily choosing the largest gas stations first.

//This is guaranteed to succeed because we drive the largest distance possible before each 
//refueling stop, and therefore have the largest choice of gas stations to (retroactively) stop at.

class Solution {
    public int minRefuelStops(int target, int tank, int[][] stations) {
        // pq is a maxheap of gas station capacities
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        int ans = 0, prev = 0;
        for (int[] station: stations) {
            int location = station[0];
            int capacity = station[1];
            tank -= location - prev;
            while (!pq.isEmpty() && tank < 0) {  // must refuel in past
                tank += pq.poll();
                ans++;
            }

            if (tank < 0) return -1;
            pq.offer(capacity);
            prev = location;
        }

        // Repeat body for station = (target, inf)
        {
            tank -= target - prev;
            while (!pq.isEmpty() && tank < 0) {
                tank += pq.poll();
                ans++;
            }
            if (tank < 0) return -1;
        }

        return ans;
    }
}
//Time:O(NlogN), Space:O(N)
