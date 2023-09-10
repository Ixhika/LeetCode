package Codes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L_17_LetterCombinations {
       public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length() == 0){
            return new ArrayList<>();
        }
        HashMap<Character,String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        backtrack(digits, map, res ,new StringBuilder() , 0);
        return res;
        
    }

public void backtrack(String digits,HashMap<Character,String> map,List<String> res,StringBuilder temp,int idx){
        if(idx == digits.length()){
            res.add(temp.toString());
            return;
        }
        String currString = map.get(digits.charAt(idx));
        for(int i=0;i<currString.length();i++){
             temp.append(currString.charAt(i));
            backtrack(digits, map, res,temp, idx+1);
            temp.deleteCharAt(temp.length()-1);
        }
    }
}
