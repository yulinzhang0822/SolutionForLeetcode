//Dynamic Programming
//Let's determine dp[i], the farthest location we can get to using i refueling stops. 
//This is motivated by the fact that we want the smallest i for which dp[i] >= target.
class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int N = stations.length;
        long[] dp = new long[N + 1];
        dp[0] = startFuel;
        for (int i = 0; i < N; ++i)
            for (int t = i; t >= 0; --t)
                if (dp[t] >= stations[i][0])
                    dp[t+1] = Math.max(dp[t+1], dp[t] + (long) stations[i][1]);

        for (int i = 0; i <= N; ++i)
            if (dp[i] >= target) return i;
        return -1;
    }
}
//Time:O(N^2), Space:O(N)
