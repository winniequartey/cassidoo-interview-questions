/**
 * Cassidoo Interview question of the week @ https://buttondown.com/cassidoo/archive/our-feelings-are-our-most-genuine-paths-to/
 */
import java.util.Map;

public class ValidTrafficSequence {
    public static void main(String[] args) {
        System.out.println(isValidTrafficSequence(new String[] {"red", "green", "yellow", "red", "green"}));
        System.out.println(isValidTrafficSequence(new String[] {"red", "yellow", "green"}));
        System.out.println(isValidTrafficSequence(new String[] {"yellow", "red", "green"}));
        System.out.println(isValidTrafficSequence(new String[] {"red", "green", "yellow"}));
        System.out.println(isValidTrafficSequence(new String[] {"yellow", "green", "red", "yellow"}));
        System.out.println(isValidTrafficSequence(new String[] {}));
    }

    public static boolean isValidTrafficSequence(String[] trafficSequence) {
        boolean validTrafficSequence = true;
        if(trafficSequence == null || trafficSequence.length == 0) {
            return validTrafficSequence;
        }
        Map<String,String> trafficRules = Map.of(
            "red", "green",
            "green", "yellow",
            "yellow", "red"
        );
        for(int i = 0; i < trafficSequence.length; i++) {
            if(i > trafficSequence.length-2){
                return validTrafficSequence;
            }
            String currentLight = trafficSequence[i];
            String nextLightSequence = trafficSequence[i+1];
            if(null != trafficRules.get(currentLight) && nextLightSequence.equalsIgnoreCase(trafficRules.get(currentLight))){
                validTrafficSequence = true;
            }
            else {
                validTrafficSequence = false;
                break;
            }
        }
        return validTrafficSequence;
    }
}