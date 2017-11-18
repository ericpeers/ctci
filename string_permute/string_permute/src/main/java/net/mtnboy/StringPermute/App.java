package net.mtnboy.StringPermute;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
    public static boolean permute(String lhs, String rhs) {
        if ((lhs == null) || (rhs == null)) {
            if (lhs == rhs) return true;
            else return false;
        }

        //this handles mismatch lengths
        if ( lhs.length() != rhs.length() ) return false;
        if (lhs.length() == 0) return true; //early eject.

        int frequency[] = new int[256]; //let's assume ascii, not a 16b character.
        //this isn't necessary. Default value is 0.
        //for (int i=0;i<256;i++) { frequency[i] = 0; }
        // or...
        //Arrays.fill(frequency, 0);

        for (int i=0;i<rhs.length();i++) {
            int charIndex = Character.getNumericValue(rhs.charAt(i));
            frequency[charIndex]++;
        }

        for (int i=0;i<lhs.length();i++) {
            int charIndex = Character.getNumericValue(lhs.charAt(i));
            if ((charIndex > 255) || (charIndex < 0)) {
                //we're not in ascii land.
                throw new NumberFormatException();
            }

            if (frequency[charIndex]==0) return false;
            frequency[charIndex]--;
        }

        return true;

    }

    public static 
}
