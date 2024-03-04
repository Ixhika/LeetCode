package Codes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class L_1291_SequentialDigits {
    public List<Integer> sequentialDigits(int low, int high) {
     List<Integer> res = new ArrayList<>();
        for(int i=1;i<=9;i++){
            int temp = i;

            for(int j = i+1;j<=9;j++){
                temp = temp*10+j;
                if(temp >= low && temp <= high){
                    res.add(temp);
                }else if(temp > high){
                    break;
                }
            }
        }
        Collections.sort(res);
        return res;
    }
}
