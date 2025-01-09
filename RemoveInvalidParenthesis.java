// Time Complexity: O(2^n) - 2 possible solutions at every step choose and no choose
// Space complexity: O(n) Queue space

import java.util.*;

public class RemoveInvalidParenthesis {
    public List<String> removeInvalidBrackets(String s) {
        List<String> result = new ArrayList(); // to store result
        // base case
        if (s == null) return result;

        Set<String> visited = new HashSet<>(); // for storing visited parenthesis
        Queue<String> queue = new LinkedList<>();

        boolean found = false;
        queue.add(s);
        visited.add(s);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            if (isValid(current)) {
                result.add(current); // if the string is valid, add it to the result set
                found = true; // mark it as found true
            }
            if (found)
                continue; // if a valid string is found in the same level we do not need to explore its further babies

            // Generate all the possible parenthesis combinations

            for (int i = 0; i < current.length(); i++) {
                if (current.charAt(i) != '(' && current.charAt(i) != ')') continue;

                String next = current.substring(0, i) + current.substring(i + 1);

                if (!visited.contains(next)) { // Now explore the next element, if it is not in the visited set add it to the queue and add to the visited sset
                    queue.add(next);
                    visited.add(next);
                }
            }
        }
        return result;
    }

    public boolean isValid(String s){
        int count = 0;
        for( char c : s.toCharArray()){
            if(c =='(') count ++;
            else if( c ==')'){
                count--;
                if( count < 0) return false; // number f opening parenthesis is< than closing parenthesis
            }
        }
        return count == 0;
    }

    public static void main( String [] args){
        RemoveInvalidParenthesis solution =  new RemoveInvalidParenthesis();
        System.out.println(solution.removeInvalidBrackets("()())()"));
    }
}
