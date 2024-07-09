public class ReverseWords {
    public static void main(String[] args) {
        String str = "i.like.this.program.very.much";

        ReverseWords r = new ReverseWords();
        System.out.println("Reversed string: " + r.reverseWords(str));
    }

    String reverseWords(String S) {
        String[] words = S.split("\\.");

        int n = words.length;

        for (int i = 0; i < n / 2; i++) {
            String temp = words[i];
            words[i] = words[n - 1 - i];
            words[n - 1 - i] = temp;
        }

        return String.join(".", words);
    }
}
