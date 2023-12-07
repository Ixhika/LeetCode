package Codes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class L_49_GroupAnagrams {
    // Time complexity: O(n*log n)
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for(String s : strs){

            /*It converts the current string str into a character array.
            Sorts the character array alphabetically using Arrays.sort.
            Constructs a new string sortedStr from the sorted character array. */

           char[] ch = s.toCharArray();
           Arrays.sort(ch);
           String update_str = new String(ch);

           /*Checks if the sorted string sortedStr is already a key in the map. If not, it adds a new entry with the sorted string as the key and an empty list as its value.
It then retrieves the list associated with the sorted string key and adds the original unsorted string str to that list. This step essentially groups the anagrams together by using the sorted string as a key in the map. */

           if(!map.containsKey(update_str)){
               map.put(update_str , new ArrayList<>());
           }
           map.get(update_str).add(s);
           System.out.println(map);
        }

        return new ArrayList<>(map.values());
    }
}

// how the map looks
/*{aet=[eat]}
{aet=[eat, tea]}
{aet=[eat, tea], ant=[tan]}
{aet=[eat, tea, ate], ant=[tan]}
{aet=[eat, tea, ate], ant=[tan, nat]}
{aet=[eat, tea, ate], abt=[bat], ant=[tan, nat]} */
