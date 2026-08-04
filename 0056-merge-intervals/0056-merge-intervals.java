class Solution {
    public int[][] merge(int[][] intervals) {
       List<int[]>  res = new ArrayList<>();
       int n = intervals.length;
       Arrays.sort(intervals, (x, y) -> Integer.compare(x[0], y[0]));

       int start = intervals[0][0];
       int end = intervals[0][1];

       for(int i = 0; i < n; i++){
        int s = intervals[i][0];
        int e = intervals[i][1];
        
        if(end>=s){
            start = start;
            end = Math.max(end,e);
            continue;
        }
        res.add(new int[]{start,end});
        start = s;
        end = e;
       } 
       res.add(new int[]{start,end});
      return res.toArray(new int[res.size()][]);
    }
}