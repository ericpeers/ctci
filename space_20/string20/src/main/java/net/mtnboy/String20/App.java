package net.mtnboy.String20;

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

    public static String string_20 (String str) {
        if (str == null || str.isEmpty() ) return str;
        int spaces = 0;
        for (int i=0;i<str.length();i++) {
            if (str.charAt(i) == ' ') spaces++;
        }

        char buffer[] = new char[str.length() + 2*spaces];
        int location = 0;
        for (int i=0;i<str.length();i++) {
            if (str.charAt(i) == ' ') {
                buffer[location++] = '%';
                buffer[location++] = '2';
                buffer[location++] = '0';
            } else {
                buffer[location++] = str.charAt(i);
            }
        }
        return new String(buffer);
    }
}
