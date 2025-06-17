/**
 * Cassidoo Interview question of the week @ https://buttondown.com/cassidoo/archive/to-be-afraid-is-to-behave-as-if-the-truth-were/
 */
import java.util.*;

public class SortMonarchs {
    private static Map<Character, Integer> ordinalToNumMap = Map.of(
        'I', 1,
        'V', 5,
        'X', 10,
        'L', 50,
        'C', 100,
        'D', 500,
        'M', 1000
    );
    private static Map<Integer, String> numToOrdinalMap =  new HashMap<>();
    
    public static void main(String[] args) {
        System.out.println(sortArrayOfMonarchs(Arrays.asList("Louis IX", "Philip II", "Louis VIII", "Philip I")));
        System.out.println(sortArrayOfMonarchs(Arrays.asList("George VI", "George V", "Elizabeth II", "Edward VIII")));
    }

    public static List<String> sortArrayOfMonarchs(List<String> monarchList){
        if(monarchList == null || monarchList.isEmpty()) {
            return monarchList;
        }
        String[] split;
        String[] numSplit;
        List<String> numMonarchs = new ArrayList<>();
        List<String> sortedmonarchList = new ArrayList<>();
        for (int i = 0; i < monarchList.size(); i++) {
            split = monarchList.get(i).split(" ");
            int num = ordinalToNumber(split[1]);
            numToOrdinalMap.put(num, split[1]);
            numMonarchs.add(monarchList.get(i).replace(split[1], String.valueOf(num)));
        }
        numMonarchs.sort(null);
        for (int i = 0; i < numMonarchs.size(); i++) {
            numSplit = numMonarchs.get(i).split(" ");
            String ordinal = numToOrdinalMap.get(Integer.parseInt(numSplit[1]));
            sortedmonarchList.add(numMonarchs.get(i).replace(numSplit[1], ordinal));
        }
        return sortedmonarchList;
    }

    public static int ordinalToNumber(String ordinalString){
        int num = 0;
        for (int i = 0; i < ordinalString.length(); i++) {
             int currOrd = ordinalToNumMap.get(ordinalString.charAt(i));
            if (i + 1 < ordinalString.length() && currOrd < ordinalToNumMap.get(ordinalString.charAt(i + 1))) {
                num += ordinalToNumMap.get(ordinalString.charAt(i + 1)) - currOrd;
                i++;
            }
            else {
                num += currOrd;
            }
        }
        return num;
    }
}
