class TimeMap {

    class Pair<K, V> {
        private K key;
        private V value;

        Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    private Map<String, List<Pair<Integer, String>>> store;

    public TimeMap() {
        store = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        store.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair<>(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        List<Pair<Integer, String>> values = store.getOrDefault(key, new ArrayList<>());
        int low = 0;
        int high = values.size() - 1;
        String ans = "";

        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(values.get(mid).getKey() <= timestamp){
                ans = values.get(mid).getValue();
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}
