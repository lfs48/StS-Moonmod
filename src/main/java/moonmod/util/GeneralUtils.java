package moonmod.util;

public class GeneralUtils {
    public static String arrToString(Object[] arr) {
        if (arr == null)
            return null;
        if (arr.length == 0)
            return "";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length - 1; ++i) {
            sb.append(arr[i]).append(", ");
        }
        sb.append(arr[arr.length - 1]);
        return sb.toString();
    }

    // Function to convert camel/pascal case to camel case
    public static String toSnakeCase(String str)
    {
 
        // Empty String
        String result = "";
 
        // Append first character(in lower case)
        // to result string
        char c = str.charAt(0);
        result = result + Character.toLowerCase(c);
 
        // Traverse the string from
        // ist index to last index
        for (int i = 1; i < str.length(); i++) {
 
            char ch = str.charAt(i);
 
            // Check if the character is upper case
            // then append '_' and such character
            // (in lower case) to result string
            if (Character.isUpperCase(ch)) {
                result = result + '_';
                result
                    = result
                      + Character.toLowerCase(ch);
            }

            // If the character is a
            // space then append '_'

            else if (ch == ' ') {
                result = result + '_';
            }

            // If the character is lower case then
            // add such character into result string

            else {
                result = result + ch;
            }
        }
 
        // return the result
        return result;
    }
}
