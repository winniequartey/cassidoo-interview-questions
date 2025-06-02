/**
 * Cassidoo Interview question of the week @ https://buttondown.com/cassidoo/archive/consistent-actions-produce-results-more-often/
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NestArray {
    public static void main(String[] args) {
        System.out.println(getNestedArray(new int[] {1, 2, 3, 4}));
        System.out.println(getNestedArray(new int[] {1}));
        System.out.println(getNestedArray(null));
    }

    public static Object getNestedArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new ArrayList<>();
        }
        List<Object> nestedArray = null;
        for (int i = arr.length-1; i >= 0; i--) {
            if(i == arr.length-1 ){
                nestedArray = Arrays.asList(arr[i]);
            } else {
                nestedArray = Arrays.asList(arr[i], nestedArray);        
            }
        }
        return nestedArray;
    }
}
