
package net.mtnboy.StringUnique;
import java.util.Set;
import java.util.HashSet;

public class App {
    public static void main( String[] args ) {
        System.out.println( hasAllUnique("Hello World!"));
    }

    //static since this doesn't require storage outside of this one invocation.
    public static boolean hasAllUnique(String str) {
        if ((str == null) || (str.isEmpty())) {
            return true;
        }

        Set<Character> present = new HashSet();;
        for (int i=0; i<str.length(); i++) {
            Character testChar = str.charAt(i);
            if (present.contains(testChar)) {
                return false;
            }
            present.add(testChar);
        }
        //didn't see a dup. Therefore it is unique
        return true;
    }

    public static boolean hasAllUnique2(final String input) {
        return (input == null) ||
                input.length() == input.chars().distinct().count();
    }
}
