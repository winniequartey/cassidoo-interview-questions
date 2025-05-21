/**
 * Cassidoo Interview question of the week @ https://buttondown.com/cassidoo/archive/birds-born-in-a-cage-think-flying-is-an-illness/
 * Question
 * Given two integers origin and target, add operators in the origin number to make it equal target, if possible. You can return just one, or all possibilities for this!
 * Examples:
 * > addOperators(123, 6)
 * > ["1*2*3", "1+2+3"]
 * > addOperators(3456237490, 9191)
 * > [] // none possible
 */

import java.util.ArrayList;
import java.util.List;

public class AddOperators {
    public static void main(String[] args){
        System.out.println(addOperators("123", "6"));
        System.out.println(addOperators("3456237490", "9191"));
    }

    public static List<String> addOperators(String origin, String target){
        String originString = origin;
        Integer additionResult;
        String additionPossibility = "";
        Integer subtractionResult;
        String subtractionPossibility = "";
        Integer multiplicationResult;
        String multiplicationPossibility = "";
        Integer divisionResult;
        String divisionPossibility = "";
        List<String> possibilities = new ArrayList<>();
        Integer targetInt = Integer.parseInt(target);

        int numAtIndex = originString.charAt(0) - '0';
        additionResult = numAtIndex;
        subtractionResult = numAtIndex;
        multiplicationResult = numAtIndex;
        divisionResult = numAtIndex;
        additionPossibility = additionPossibility.concat(String.valueOf(additionResult));
        subtractionPossibility = subtractionPossibility.concat(String.valueOf(subtractionResult));
        multiplicationPossibility = multiplicationPossibility.concat(String.valueOf(multiplicationResult));
        divisionPossibility = divisionPossibility.concat(String.valueOf(divisionResult));
        for (int j = 1; j < originString.length(); j++) {
            int nextNum = originString.charAt(j) - '0';
            //addition
            additionResult += nextNum;
            additionPossibility = additionPossibility.concat("+" + String.valueOf(nextNum));
            //subtraction
            subtractionResult = subtractionResult - nextNum;
            subtractionPossibility = subtractionPossibility.concat("-" + String.valueOf(nextNum));
            //multiplication
            multiplicationResult = multiplicationResult * nextNum;
            multiplicationPossibility = multiplicationPossibility.concat("*" + String.valueOf(nextNum));
            //division
            try {
                divisionResult = divisionResult / nextNum;
                divisionPossibility = divisionPossibility.concat("/" + String.valueOf(nextNum));
            } catch (ArithmeticException arithmeticException){
                //
            }
        } 
        if(targetInt.equals(additionResult)){
            possibilities.add(additionPossibility);
        } 
        if(targetInt.equals(multiplicationResult)) {
            possibilities.add(multiplicationPossibility);
        } 
        if(targetInt.equals(subtractionResult)) {
            possibilities.add(divisionPossibility);
        }
        if(targetInt.equals(divisionResult)){
            possibilities.add(divisionPossibility);
        }
        return possibilities;
    } 
}
