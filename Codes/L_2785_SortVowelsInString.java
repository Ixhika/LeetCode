package Codes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class L_2785_SortVowelsInString {
     public String sortVowels(String s) {

        // Creating a list of vowels then sorting them in ascending order
        List<Character> list = new ArrayList<>();
        for(char c: s.toCharArray()){
            if(Vowels(c)){
                list.add(c);
            }
        }
        Collections.sort(list);
        // System.out.print(list);
        

        // Creating a resultant string where the result where the vowels will be sorted according to their ascii values
        StringBuilder res = new StringBuilder();
        int i = 0;
        for(char ch : s.toCharArray()){
            if(Vowels(ch)){
                res.append(list.get(i));
                i++;
            }else{
                res.append(ch);
            }
            // i++;
        }
        return res.toString();
    }
    public boolean Vowels(char ch){
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }
}
