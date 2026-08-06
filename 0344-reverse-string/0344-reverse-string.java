class Solution {
    public void reverseString(char[] s) {
        Stack<Character> st = new Stack<>();
        int res= 0;
         for(int i = 0; i<s.length; i++){
            st.push(s[i]);
         }
         while(!st.isEmpty()){
            char c = st.peek();
            st.pop();
            s[res] = c;
           res++;
         }
    }
}