public class AlgoTest {
    public static void main(String[] args) {
        Algo algo = new Algo();
        // System.out.println(algo.test());
        // String hello = "Hello";
        // System.out.println(algo.reverseString(hello));
        int[] ar = {12,24,10,24};
        int[] candles = {4,4,1,3,5,8,9};
        int[] candles2 = {4};


        // int[] result =  algo.breakingRecords(ar);
        int result =  algo.birthdayCakeCandles(candles);
        System.out.println(result); // 1
        // System.out.println(algo.frequencyCounter("hello"));
        // System.out.println(algo.sameFrequency("hello", "olleh")); // true
        // System.out.println(algo.sameFrequency("hello", "olle")); // false

        // System.out.println(result[0]);
        // System.out.println(result[1]);
    }
}
