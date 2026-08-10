import java.util.AbstractMap;

class Solution {
    public String removeDuplicates(String s, int k) {
        int n = s.length();
        Stack<Map.Entry<Character,Integer>> st = new Stack<>();

        for(int i=0; i<n; i++){
            char c = s.charAt(i);

            if(st.isEmpty()){
                st.push(new AbstractMap.SimpleEntry<>(c,1));
                continue;
            }

            if(st.peek().getKey()!= c){
                st.push(new AbstractMap.SimpleEntry<>(c,1));
                continue;
            }

            if(st.peek().getValue()<(k-1)){
                Map.Entry<Character,Integer> p = st.peek();
                st.pop();
                st.push(new AbstractMap.SimpleEntry<>(p.getKey(),p.getValue()+1));
            } else {
                st.pop();
            }
        }
        
        StringBuilder res = new StringBuilder();
        while(!st.isEmpty()){
           Map.Entry<Character,Integer> p = st.peek();
           st.pop();
           int count = p.getValue();
           while(count-- > 0){
            res.append(p.getKey());
           }
        }
        return res.reverse().toString();
    }
}