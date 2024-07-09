public class StringReverse {
    public static void main(String[] args) {
        String str = "reverse this string";
        System.out.println("Reversed string: " + StringReverse.reverseWord(str));
    }

    public static String reverseWord(String str) {
        char[] charArray = str.toCharArray();
        int n = charArray.length;

        for (int i = 0; i < n / 2; i++) {
            char temp = charArray[i];
            charArray[i] = charArray[n - 1 - i];
            charArray[n - 1 - i] = temp;
        }

        return new String(charArray);
    }
}
