/**
 * Cassidoo Interview question of the week @https://buttondown.com/cassidoo/archive/the-truth-is-no-one-of-us-can-be-free-until/
 * Question:
    * Given an array of attack damages and a shield capacity for a spaceship, 
    return the index when cumulative damage exceeds the shield. Return -1 if shield survives.
    * Examples:
    * > findShieldBreak([10, 20, 30, 40], 50)
    * > 2
    * > findShieldBreak([1, 2, 3, 4], 20)
    * > -1

    * > findShieldBreak([50], 30)
    * > 0
 */
public class FindShieldBreak {
    public static void main(String[] args){
        System.out.println(findShieldBreak(new int[] {10, 20, 30, 40}, 50));
        System.out.println(findShieldBreak(new int[] {1, 2, 3, 4}, 20));
        System.out.println(findShieldBreak(new int[] {50}, 30));
    }

    public static int findShieldBreak(int[] attackDamages, int shieldCapacity){
        int cumulativeDamage = 0;
        int damageIndex = 0;
        for (int damage : attackDamages) {
            cumulativeDamage += damage;
            if(cumulativeDamage > shieldCapacity){
                return damageIndex;
            }
            damageIndex++;
        }
        return -1;
        
    }
}
