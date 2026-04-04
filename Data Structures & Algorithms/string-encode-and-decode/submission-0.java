class Solution {

    Map<String, List<String>> hm = new HashMap<>();
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String st : strs) {
            sb.append(st.length()).append("#").append(st);
        }
        hm.put(sb.toString(), strs);
        return sb.toString();
    }

    public List<String> decode(String str) {
        return hm.get(str);
    }
}
