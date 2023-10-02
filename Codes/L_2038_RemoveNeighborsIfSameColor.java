package Codes;

public class L_2038_RemoveNeighborsIfSameColor {

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public boolean winnerOfGame(String colors) {
        int countA = 0;
        int countB = 0;
        for(int i=1;i<colors.length()-1;i++){

            // Simply counting the number of moves for both alice and bob
           if(colors.charAt(i-1) == colors.charAt(i) && colors.charAt(i) == colors.charAt(i+1)){
               if(colors.charAt(i) == 'A'){
                   countA++;
               }else{
                   countB++;
               }
           }
        }
        // If alice wins then true else false
        return countA>countB;
    }
}
