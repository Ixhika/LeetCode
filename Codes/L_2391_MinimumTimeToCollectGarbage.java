package Codes;

import java.util.HashMap;

public class L_2391_MinimumTimeToCollectGarbage {
    public int garbageCollection(String[] garbage, int[] travel) {
        int totalTime = 0;
        int[] prevSum = new int[travel.length + 1];
        prevSum[1] = travel[0];
        for(int i=1;i<travel.length;i++){
            prevSum[i+1] = prevSum[i] + travel[i];
        }

        // System.out.println(prevSum);

        HashMap<Character,Integer> lastPos = new HashMap<>();

        HashMap<Character,Integer> countGarbage = new HashMap<>();
        for(int i=0;i<garbage.length;i++){
            for(char c:garbage[i].toCharArray()){
                lastPos.put(c,i);
                countGarbage.put(c , countGarbage.getOrDefault(c , 0)+1);
            }
        }
        // System.out.println(countGarbage);
        //  System.out.println(lastPos);
    
        String type = "MPG";
        for(char ch:type.toCharArray()){
            if(countGarbage.containsKey(ch)){
                totalTime += prevSum[lastPos.get(ch)] + countGarbage.get(ch);
            }
        }
        return totalTime;
    }
}
