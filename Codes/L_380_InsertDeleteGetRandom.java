package Codes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class L_380_InsertDeleteGetRandom {
        Set<Integer> set;
    public void RandomizedSet() {
        set = new HashSet<>();
    }
    
    public boolean insert(int val) {
        if(!set.contains(val)){
            set.add(val);
            return true;
        }
        return false;
    }
    
    public boolean remove(int val) {
        return set.remove(val);
    }
    
    public int getRandom() {
        List<Integer> res = new ArrayList<>(set);
        Random random = new Random();
        return res.get( random.nextInt(res.size()));
    }
}

// For last function
/*List<Integer> res = new ArrayList<>(set);

This line initializes a new ArrayList named res and populates it with elements from a Set<Integer> called set. Similar to the previous example, it creates a new ArrayList containing the same elements as the set.

Random random = new Random();
This line creates a new instance of the Random class named random. The Random class provides methods to generate random numbers.
return res.get(random.nextInt(res.size()));

random.nextInt(res.size()) generates a random integer value between 0 (inclusive) and res.size() (exclusive). This value represents a valid index within the bounds of the res list.
res.get() retrieves the element from the res list at the randomly generated index using random.nextInt(res.size()).
The method then returns this randomly selected element as the output of the getRandom() method. */

