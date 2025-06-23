/*
 * Cassidoo Interview question of the week @ https://buttondown.com/cassidoo/archive/this-life-is-hard-without-assistance-from-others/
 */
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class RemoveSirens {

    public static void main(String[] args) {
        System.out.println(removeSirens(Arrays.asList(Map.of(1, 5), Map.of(3,7), Map.of(6, 9), 
            Map.of(8, 10)))); 
        System.out.println(removeSirens(Arrays.asList(Map.of(0, 3), Map.of(2,4), Map.of(5, 7), 
            Map.of(6, 8), Map.of(8, 10)))); 
    }
    public static int removeSirens(List<Map<Integer, Integer>> sirenList) {
        int removeCount = 0;
        if (sirenList == null || sirenList.isEmpty()) {
            return removeCount;
        }
        sirenList.sort(Comparator.comparingInt(m -> m.keySet().iterator().next()));
        for (int i = 0; i < sirenList.size(); i++) {
            Map<Integer, Integer> siren = sirenList.get(i);
            int sirenEnd = 0;
            int nextSirenStart = 0;
            int removeIndex = 0;
            for (Integer key : siren.keySet()) {
                sirenEnd = siren.get(key);
                if (i + 1 < sirenList.size()) {
                    Map<Integer, Integer> nextSiren = sirenList.get(i + 1);
                    removeIndex = i+1;
                    for (Integer nextKey : nextSiren.keySet()) {
                        nextSirenStart = nextKey;
                    }
                }
            }
            if(nextSirenStart < sirenEnd && i + 1 < sirenList.size()){
                removeCount++;
                i = removeIndex;
            }
        }
        return removeCount;
    }
}
