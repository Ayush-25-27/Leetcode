class Solution {
    public int[] dailyTemperatures(int[] temp) {
       int n = temp.length;
       Stack<Integer> st = new Stack<>();
       int[] res = new int[n];
       res[n-1] = 0;
       st.push(n-1);

       for(int i = n-2; i>=0; i--){
        while(!st.isEmpty() && temp[st.peek()]<= temp[i]){
            st.pop();
        }
        if(st.isEmpty()){
            res[i] = 0;
        } else{
            res[i] = st.peek() - i;
        }
        st.push(i);
       } 
       return res;
    }
}