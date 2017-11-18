package net.mtnboy.CompressApp;

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

    public static String compress(String in) {
        if (in == null) {
            return null;
        }
        if (in == "") {
            return new String();
        }

        char[] chars = in.toCharArray();
        char curr = chars[0];
        int count = 1;
        StringBuilder out = new StringBuilder(chars.length); //set init length to in

        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != curr) {
                out.append(curr); out.append(count);
                curr = chars[i];
                count = 1;
            } else {
                count++;
            }
        }

        out.append(curr); out.append(count);
        if (out.length() > in.length()) {
            return new String(in);
        } else {
            return out.toString();
        }
    }
}
