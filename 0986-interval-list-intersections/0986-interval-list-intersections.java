class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int n = firstList.length;
        int m = secondList.length;

        int i=0 , j=0;
        List<int[]> res = new ArrayList<>();
        while(i<n && j<m){
         int  start_1 = firstList[i][0];
         int end_1 = firstList[i][1];
         int start_2 = secondList[j][0];
         int end_2 = secondList[j][1];

          if(start_1 <= start_2){
            if(end_1 >= start_2){
                int s = Math.max(start_1,start_2);
                int e = Math.min(end_1,end_2);
                res.add(new int[]{s,e});
            }
          }

          else {
            if(end_2>=start_1){
                int s = Math.max(start_1,start_2);
                int e = Math.min(end_1,end_2);
                res.add(new int[]{s,e});
            }
          }

          if(end_1<=end_2){
            i++;
          } else{
            j++;
          }

        }
    return res.toArray(new int[res.size()][]);




    }
}