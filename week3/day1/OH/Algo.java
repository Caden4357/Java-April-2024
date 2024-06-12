import java.util.HashMap;

public class Algo {
    
    public String test() {
        return "test";
    }
    // write a function that takes in a string and returns the string reversed (you can make a new string to return at the end)
    public String reverseString(String str){
        String reversedStr = "";
        if(str.length() == 0){
            return "Empty string";
        }else{
            // loop through the string backwards printing out each char
            // for(start, stop, increment)
            for(int idx = str.length() - 1; idx >= 0; idx--){
                reversedStr += str.charAt(idx);
            }
        }
        return reversedStr;
    }

    // https://www.hackerrank.com/challenges/breaking-best-and-worst-records/problem?isFullScreen=true
    // Maria plays college basketball and wants to go pro. Each season she maintains a record of her play. She tabulates the number of times she breaks her season record for most points and least points in a game. Points scored in the first game establish her record for the season, and she begins counting from there.
    // 1.) write a function that takes in an array of integers
    // 2.) we need 2 vars one for maxScore and one for minScore both start at scores[0]
    // 3.) loop through the scores array 
    // 4.) if statement 


    // [12,24,10,24]
    public int[] breakingRecords(int[] scores){
        int[] recordBreaks = new int[2];
        int minScore = scores[0];
        int maxScore = scores[0];
        for(int idx = 0; idx < scores.length; idx++){
            if(scores[idx] > maxScore){
                maxScore = scores[idx];
                recordBreaks[0]++;
            }
            else if(scores[idx] < minScore){
                minScore = scores[idx];
                recordBreaks[1]++;
            }
        }
        return recordBreaks; // [1,1]
    }


    // https://www.hackerrank.com/challenges/birthday-cake-candles/problem?isFullScreen=true
    // You are in charge of the cake for a child's birthday. You have decided the cake will have one candle for each year of their total age. They will only be able to blow out the tallest of the candles. Count how many candles are tallest.
    // candles = [4,4,1,3,5,8,9] return --> 1 because there are 2 4s and thats the largest number 
    // we need to find the highest number (compare every number)
    // count for how many highest number in the array 
    // return the count 
    public int birthdayCakeCandles(int[] ar){
        int count = 1;
        int maxNum = ar[0];
        for(int i = 1; i < ar.length; i++){
            if(ar[i] > maxNum){
                maxNum = ar[i];
                count = 1;
                System.out.println("Count: " + count);
                System.out.println("Max Num : " + maxNum);

            }else if(ar[i] == maxNum){
                count++;
                System.out.println("Count: " + count);
                System.out.println("Max Num : " + maxNum);
            }
        }
        return count;
    }
    // Frequency Counter


    
    // Same Frequency




    // Reverse integer array working in place givin [1,2,3,4,5] you should return [5,4,3,2,1] Without creating a new array
}
