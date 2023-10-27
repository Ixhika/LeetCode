package Codes;

import java.util.HashMap;

public class L_205_IsomorphicStrings {

    // Time complexity: O(n)
    // Space Complexity: O(1)
    public boolean isIsomorphic(String s, String t) {
        // If the length of two strings are not equal then return false;
        if(s.length() != t.length()){
            return false;
        }

        // Creating a hashmap to map characters with each other in such a way so that
        // All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character,
        //  but a character may map to itself.

        HashMap<Character,Character> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char original = s.charAt(i);
            char replacement = t.charAt(i);

            // If the map does not contain the given key and value mapped pair then adding them to map
            if(!map.containsKey(original)){
                if(!map.containsValue(replacement)){
                    map.put(original,replacement);
                }else{
                    return false;
                }
            }else{
                // if they have already been mapped and again the same key is asking to map another value it will return false;
                char mapChar = map.get(original);
                if(mapChar != replacement){
                    return false;
                }
            }
        }
        return true;
    }
}


// this solution also correct but taking too much time and space

// HashMap<Character,Character> map1 = new HashMap<>();
// HashMap<Character,Character> map2 = new HashMap<>();
// int i=0;
// int j = 0;

// while(i < s.length() && j < t.length()){
//    if(map1.containsKey(s.charAt(i)) && map1.get(s.charAt(i)) != t.charAt(j) || map2.containsKey(t.charAt(j)) && map2.get(t.charAt(j)) != s.charAt(i)){
//                 return false;
//        }
//        map1.put(s.charAt(i) , t.charAt(j));
//        map2.put(t.charAt(j) , s.charAt(i));
//        i++;
//        j++;
//    }
//  return true;

