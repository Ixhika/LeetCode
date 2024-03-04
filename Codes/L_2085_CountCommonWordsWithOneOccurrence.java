package Codes;

import java.util.HashMap;

public class L_2085_CountCommonWordsWithOneOccurrence {
    public int countWords(String[] words1, String[] words2) {
        HashMap<String,Integer> map1 = new HashMap<>();
        for(String s:words1){
            map1.put(s, map1.getOrDefault(s,0)+1);
        }
        HashMap<String,Integer> map2 = new HashMap<>();
        for(String s:words2){
            map2.put(s,map2.getOrDefault(s,0)+1);
        }
        int res = 0;
        for(String w : words1){
            if(map1.containsKey(w)&& map2.containsKey(w) && map1.get(w) == 1 && map2.get(w) == 1){
                res++;
            }
        }
        return res;
    }
}
