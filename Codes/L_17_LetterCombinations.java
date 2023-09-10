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
        // Storing all the combinations in a map
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
    // Base case for each condition to terminate and get stored in res
        if(idx == digits.length()){
            res.add(temp.toString());
            return;
        }
        // Getting all the values from the map and iterating over them
        String currString = map.get(digits.charAt(idx));
        for(int i=0;i<currString.length();i++){

            // Addig them to a temp list that will be checking all the possible combinations 
            /* str = "23"  res = "ad" ,"ae" , "af" , "bd" , ......."cf" */
             temp.append(currString.charAt(i));
            backtrack(digits, map, res,temp, idx+1);
            temp.deleteCharAt(temp.length()-1);   //Once combination is made backtracking to previous added element by removing the last element and making space for adding another element to the list
        }
    }
}
