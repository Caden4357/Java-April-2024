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



    // https://www.hackerrank.com/challenges/birthday-cake-candles/problem?isFullScreen=true





    // reverse integer array working in place givin [1,2,3,4,5] you should return [5,4,3,2,1] Without creating a new array

}
