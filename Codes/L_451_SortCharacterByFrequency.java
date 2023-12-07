package Codes;

import java.util.HashMap;
import java.util.PriorityQueue;

public class L_451_SortCharacterByFrequency {
     public String frequencySort(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c:s.toCharArray()){
            map.put(c , map.getOrDefault(c,0)+1);
        }
        PriorityQueue<Character> heap = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));
        for(char key:map.keySet()){
            heap.add(key);
        }
        StringBuilder res = new StringBuilder();
        while(!heap.isEmpty()){
            char c = heap.poll();
            int freq = map.get(c);
            while(freq-- != 0){
                res.append(c);
            }
        }
        return res.toString();
    }
}
