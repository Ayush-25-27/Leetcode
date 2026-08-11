class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
       Map<Character,Integer> have = new HashMap<>();
       Map<Character,Integer> need = new HashMap<>();
       int i;

       for(i = 0; i<ransomNote.length(); i++){
        need.put(ransomNote.charAt(i),need.getOrDefault(ransomNote.charAt(i),0)+1);
       } 

        for(i = 0; i<magazine.length(); i++){
        have.put(magazine.charAt(i),have.getOrDefault(magazine.charAt(i),0)+1);
       } 
       return fun(have,need);

    }

    boolean fun( Map<Character,Integer> have, Map<Character,Integer> need){
        for(Map.Entry<Character,Integer> i : need.entrySet()){
            char c = i.getKey();
            int fneed = i.getValue();
            int fhave = have.getOrDefault(c,0);

            if(fhave < fneed){
                return false;
            }
        }
        return true;
    }
}