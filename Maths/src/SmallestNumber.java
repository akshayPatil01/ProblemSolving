package Maths.src;

public class SmallestNumber {
    public static void main(String[] args) {
        int sum = 9;
        int digits = 2;

        SmallestNumber s = new SmallestNumber();
        System.out.printf("Smallest number possible with Sum %d & %d Digits  -->  %s", sum, digits, s.smallestNumber(sum, digits));
    }

    public String smallestNumber(int s, int d) {
        if (s == 0 && d == 1) return "0";

        if (s > d * 9 || s < 1) return "-1";

        int num = 1;
        for (int i = 1; i < d; i++)
            num *= 10;

        int sumDiff = s - 1;

        int temp = 1;
        while (sumDiff > 9) {
            num += temp * 9;
            sumDiff -= 9;
            temp *= 10;
        }

        num += (sumDiff * temp);

        return Integer.toString(num);
    }
}
