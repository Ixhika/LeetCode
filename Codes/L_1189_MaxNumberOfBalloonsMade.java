package Codes;

public class L_1189_MaxNumberOfBalloonsMade {
    // Time complexity: O(n)
    public int maxNumberOfBalloons(String text) {
        // Character array for stroing count of each character
        int[] charCount = new int[26];
        for(int i=0;i<text.length();i++){
            charCount[text.charAt(i) - 'a']++;
        }

        // charCount[i] means ith character in alphabet series
        int minBalloons = charCount[1];  //for 'b'
        minBalloons = Math.min(minBalloons , charCount[0]);  //for 'a'

        minBalloons = Math.min(minBalloons , charCount[11]/2);   //for 'l' dividing by 2 beacuse for one balloon need only 2 'l's: 

        minBalloons = Math.min(minBalloons , charCount[14]/2);  //for 'o'  dividing by 2 beacuse for one balloon need only 2 'o's
        
        minBalloons = Math.min(minBalloons , charCount[13]);   //for 'n'

        return minBalloons;
    }
}

/* balloonballoo
b = 2
a = 2
l/2 = 2
o/2 = 2 
n = 1
thus returning the min of all to confirm how many balloons can be made*/

