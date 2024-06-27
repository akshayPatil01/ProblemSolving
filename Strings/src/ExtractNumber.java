public class ExtractNumber {
    public static void main(String[] args) {
        ExtractNumber e = new ExtractNumber();
        System.out.println("Max Extracted Number: " + e.extractNumber("This is alpha 5057 and 97"));
    }

    long extractNumber(String sentence) {
        // code here
        String[] words = sentence.split(" ");

        long maxNum = -1;

        for (String word : words) {
            if (isNumber(word)) {
                long curNum = Long.parseLong(word);
                if (!containsNine(curNum) && curNum > maxNum) {
                    maxNum = curNum;
                }
            }
        }

        return maxNum;
    }

    private boolean containsNine(long num) {
        while (num > 0) {
            long digit = num % 10;
            if (digit == 9)
                return true;
            num /= 10;
        }

        return false;
    }

    private boolean isNumber(String word) {
        for (char c : word.toCharArray()) {
            if (!Character.isDigit(c))
                return false;
        }

        return true;
    }
}
