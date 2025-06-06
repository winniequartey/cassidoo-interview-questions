/**
 * Cassidoo Interview question of the week @ https://buttondown.com/cassidoo/archive/false-expectations-take-away-joy-sandra-bullock/
 */
import java.util.ArrayList;
import java.util.List;

public class OddSum {
    public static void main(String[] args){
        System.out.println(getOddSumPair(new int[] {9, 14, 6, 2, 11}, new int[] {8, 4, 7, 20}));
        System.out.println(getOddSumPair(new int[] {2, 4, 6, 8}, new int[] {10, 12, 14}));
    }

    public static List<List>  getOddSumPair(int[] arr1, int[] arr2){
        List<List> oddSumPairs = new ArrayList<>();
        if (null == arr1 || null == arr2){
            return oddSumPairs;
        }
        if (arr1.length < 1 || arr2.length < 1){
            return oddSumPairs;
        }
        for (int num1 : arr1){
            for (int num2 : arr2){
                if ((num1 % 2 == 0) && (num2 % 2 == 0)) {
                    continue;
                }
                else if ((num1 % 2 != 0) && (num2 % 2 != 0)) {
                    continue;
                }
                else {
                    List<Integer> pair = new ArrayList<>();
                    pair.add(num1);
                    pair.add(num2);
                    oddSumPairs.add(pair);
                }
            }
        }
        return oddSumPairs;
    }
}
