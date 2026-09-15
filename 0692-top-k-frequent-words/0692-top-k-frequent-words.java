class Solution {
    public List<String> topKFrequent(String[] words, int k) {

        // 1. Count frequency of each word
        HashMap<String, Integer> freq = new HashMap<>();

        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }

    
        PriorityQueue<Map.Entry<String, Integer>> heap = new PriorityQueue<>(
            (a, b) -> {
                if (!a.getValue().equals(b.getValue())) {
                    return Integer.compare(a.getValue(), b.getValue());
                }
                return b.getKey().compareTo(a.getKey());
            }
        );

       
        for (Map.Entry<String, Integer> entry : freq.entrySet()) {

            heap.offer(entry);

            
            if (heap.size() > k) {
                heap.poll();
            }
        }

        
        String[] ans = new String[k];

        for (int i = k - 1; i >= 0; i--) {
            ans[i] = heap.poll().getKey();
        }

        return Arrays.asList(ans);
    }
}