package Codes;

import java.util.HashMap;

public class L_290_WordPattern {
   public boolean wordPattern(String pattern, String s) {
    // Splitting the words string and making every word as an array element, this is the function of split: s = ["dog" , "cat" , "cat" , "dog"]
        String[] word = s.split(" ");
        if(word.length != pattern.length()){
            return false;
        }

        // Creating two hashmaps one pointing a-> dog b -> cat and another hashMap is pointing dog -> a cat-> b
        HashMap<Character,String> charWord = new HashMap<>();
        HashMap<String,Character> wordChar = new HashMap<>();

        for(int i=0;i<pattern.length();i++){
            char ch = pattern.charAt(i);
            String w = word[i];

            // if the character has not been mapped to the word then it will map it i.e a-> dog
            if(!charWord.containsKey(ch)){
                charWord.put(ch,w);
            }

            // if the word has not been mapped then it will map dog -> a
            if(!wordChar.containsKey(w)){
                wordChar.put(w,ch);
            }

            // thus checking if noth maps are mapped to same or not i.e a-> dog and dog->a
            if(!charWord.get(ch).equals(w) || !wordChar.get(w).equals(ch)){
                return false;
            }
        }
        return true;
    } 
}
