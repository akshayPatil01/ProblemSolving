public class CompareTwoFractions {
    public static void main(String[] args) {
        CompareTwoFractions c = new CompareTwoFractions();
        String str = "11/45, 5/6";

        String solution = c.compareFrac(str);
        System.out.println(solution);
    }

    private String compareFrac(String str) {
        String[] fractions = str.split("[, ]+");

        double frac1 = fracStringToDouble(fractions[0]);
        double frac2 = fracStringToDouble(fractions[1]);

        int compareInt = Double.compare(frac1, frac2);
        if(compareInt == 0)
            return "equal";

        return compareInt > 0 ? fractions[0] : fractions[1];
    }

    private double fracStringToDouble(String str) {
        String[] nums = str.split("/");
        return (double) Integer.parseInt(nums[0]) / Integer.parseInt(nums[1]);
    }
}
