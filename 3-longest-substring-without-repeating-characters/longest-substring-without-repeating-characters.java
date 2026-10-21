class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max =0;

        for(int i=0;i<s.length();i++){
            boolean[] seen = new boolean[128];
            for(int j=i; j<s.length();j++){
                char ch = s.charAt(j);
                if(seen[ch]){
                    break;
                }

                seen[ch] = true;
                max = Math.max(max , j-i+1);
            }
        }
        return max;
    }
}