class Solution {
    public String removeDuplicates(String s) {
       int n = s.length();
       Stack<Character> st = new Stack<>();
       StringBuilder res = new StringBuilder();
       int i = 0;
        for(i = 0; i<n; i++){
            if(st.isEmpty()){
                st.push(s.charAt(i));
                continue;
            }
            if(st.peek()== s.charAt(i)){
                st.pop();
                continue;
            }
            st.push(s.charAt(i));
        }
         while(!st.isEmpty()){
            res.append(st.peek());
            st.pop();
         } 
        res.reverse();
        return res.toString();
    }
}