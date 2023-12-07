package Codes;

import java.util.ArrayList;
import java.util.List;

public class L_2147_NumberOfWaysToDivideLogCorridor {
     int mod = 1000000007;
    public int numberOfWays(String corridor) {
        List<Integer> seats = new ArrayList<>();
        for(int i = 0;i<corridor.length();i++){
            if(corridor.charAt(i) == 'S'){
                seats.add(i);
            }
        }
        if(seats.size() %2 != 0 || seats.isEmpty()){
            return 0;
        }
        long res = 1;
        int prevIdx = seats.get(1);
        for(int i=2;i<seats.size();i = i+2){
            int division = seats.get(i) - prevIdx;
            res = (res*division)%mod;

            prevIdx = seats.get(i+1);
        }
        return (int)res;
    }
}
