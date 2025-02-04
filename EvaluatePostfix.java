/**
 * Cassidoo Interview question of the week @https://buttondown.com/cassidoo/archive/if-im-scared-be-scared-allow-it-release-it-move/
 * Question:
    * Write a function that evaluates a postfix expression (also known as Reverse Polish Notation) and returns the result.
     The expression will contain single-digit integers and the operators +, -, *, and /. 
     You can assume the input is always a valid expression!
    * Examples:
    * evaluatePostfix('12+')
    * > 3
    * evaluatePostfix('56+7*')
    * > 77
 */

import java.util.*;

class EvaluatePostfix {
    public static void main(String[] args){
        System.out.println(evaluatePostfix("12+")); // 3
        System.out.println(evaluatePostfix("56+7*")); //77
        System.out.println(evaluatePostfix("34-5+")); //4
        System.out.println(evaluatePostfix("34+56+*")); //77
    }
    public static int evaluatePostfix(String input){
        Map<String, String> operators = new HashMap<>(); 
        operators.put("+", "add");
        operators.put("-", "subtract");
        operators.put("*", "multiply");
        operators.put("÷", "division");
        operators.put("/", "division");
        int result = 0;
        List<Integer> evaluatorStack = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            if(!operators.containsKey(String.valueOf(input.charAt(i)))){
                evaluatorStack.add(input.charAt(i) - '0');
            } else {
                if(evaluatorStack.size() > 1){
                    int stackSize = evaluatorStack.size();
                    int first = evaluatorStack.get(stackSize-2);
                    int second = evaluatorStack.get(stackSize-1);
                    evaluatorStack.removeLast(); 
                    evaluatorStack.removeLast();
                    switch (operators.get(String.valueOf(input.charAt(i)))) {
                        case "add":
                            result = first + second;
                            break;
                        case "subtract":
                            result = first - second; 
                            break;
                        case "multiply":
                            result = first * second;
                            break;
                        case "division":
                            result = first / second;  
                            break;
                        default:
                            break;
                    }
                    evaluatorStack.add(result);
                }
            }  
        }
        return result;
    }

}