import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class CryptArithmetic {
    
    public static void main(String[] args) {

        // * Problem: TWO + TWO = FOUR
        String[] problem = {"TWO", "TWO", "FOUR"};
        
        // Get all unique characters in the problem
        Set<Character> chars = new HashSet<>();
        for (String s: problem) {
            for (int i = 0; i < s.length(); i++)
                chars.add(s.charAt(i));
        }
        
        // Initialize a map to store the assignment of characters to digits
        HashMap<Character, Integer> map = new HashMap<>();

        // Solve the problem
        CryptArithmetic crypt = new CryptArithmetic();
        map = crypt.solve(problem, map, chars);

        if (map != null) {
            for (Character c: map.keySet()) {
                System.out.println(c + " = " + map.get(c));
            }
            System.out.println("Problem : " + problem[0] + " + " + problem[1] + " = " + problem[2]);
            System.out.println("Solution: " + crypt.stringToInt(problem[0], map) + " + " + crypt.stringToInt(problem[1], map) + " = " + crypt.stringToInt(problem[2], map));

        } else {
            System.out.println("No solution found!");
        }
    }

    // Convert a string to an integer using the given map
    public int stringToInt(String s, HashMap<Character, Integer> map) {
        int num = 0;
        for (int i = 0; i < s.length(); i++)
            num = num * 10 + map.get(s.charAt(i));
        return num;
    }

    // Check if the problem is solved
    public boolean checkSolution(String[] problem, HashMap<Character, Integer> map) {
        int sum1 = 0, sum2 = 0, sum3 = 0;
        for (int i = 0; i < problem[0].length(); i++)
            sum1 = sum1 * 10 + map.get(problem[0].charAt(i));
        for (int i = 0; i < problem[1].length(); i++)
            sum2 = sum2 * 10 + map.get(problem[1].charAt(i));
        for (int i = 0; i < problem[2].length(); i++)
            sum3 = sum3 * 10 + map.get(problem[2].charAt(i));
        return sum1 + sum2 == sum3;
    }

    // Solve the cryptarithmetic problem and return the solution
    public HashMap<Character, Integer> solve(String[] problem, HashMap<Character, Integer> map, Set<Character> chars) {
        //  If all characters are assigned, check if the problem is solved
        if (map.size() == chars.size()) {
            if (checkSolution(problem, map)) {
                return map;
            }
        }

        // Try to assign a digit to the next character
        for (Character c: chars) {
            // Proceed only if the character is not already assigned (unique assignment)
            if (!map.containsKey(c)) {
                //  Try each digit from 0 to 9 that is not already assigned
                for (int d = 0; d < 10; d++) {
                    // Assigning 0 to the first character of a string is not allowed
                    if (d == 0 && (c == problem[0].charAt(0) || c == problem[1].charAt(0) || c == problem[2].charAt(0))) {
                        continue;
                    }
                    if (!map.containsValue(d)) {
                        map.put(c, d);
                        // Recursively solve the problem with the new assignment
                        HashMap<Character, Integer> result = solve(problem, map, chars);
                        if (result != null) {
                            return result;
                        }
                        // Remove the assignment to try the next digit, if the problem is not solved
                        map.remove(c);
                    }
                }
            }
        }
        return null;
    }
}