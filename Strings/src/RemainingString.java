public class RemainingString {
    public static void main(String[] args) {
        String s = "Thisisdemostring";
        System.out.println("Given string: " + s);

        char ch = 'i';
        int count = 3;

        RemainingString r = new RemainingString();
        System.out.printf("Remaining string after %d times %c  -->  %s", count, ch, r.printString(s, ch, count));
    }

    public String printString(String s, char ch, int count) {
        int chCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ch) continue;

            chCount++;
            if (chCount == count) return s.substring(i + 1);
        }

        return "";
    }
}
