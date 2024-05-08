public class AlgoTest {
    public static void main(String[] args) {
        Algo algo = new Algo();
        // System.out.println(algo.test());
        // String hello = "Hello";
        // System.out.println(algo.reverseString(hello));
        int[] ar = {12,24,10,24};
        int[] result =  algo.breakingRecords(ar);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}
