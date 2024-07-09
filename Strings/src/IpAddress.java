public class IpAddress {
    public static void main(String[] args) {
        String ip6 = "222.111.111.111";

        IpAddress i = new IpAddress();
        System.out.println("Is " + ip6 + " IPv4 Address valid ?: " + i.isValid(ip6));

        String ip7 = "0.0.0.0.";
        System.out.println("Is " + ip7 + "  IPv4 Address valid ?: " + i.isValid(ip7));

        String ip1 = "222.111.111.111";
        System.out.println("Is " + ip1 + "  IPv4 Address valid ?: " + i.isValid(ip1));

        String ip2 = "256.256.256.256";
        System.out.println("Is " + ip2 + "  IPv4 Address valid ?: " + i.isValid(ip2));

        String ip3 = "192.168.1.01";
        System.out.println("Is " + ip3 + "  IPv4 Address valid ?: " + i.isValid(ip3));

        String ip4 = "192.168@1.1";
        System.out.println("Is " + ip4 + "  IPv4 Address valid ?: " + i.isValid(ip4));

        String ip5 = "0.0.0.0";
        System.out.println("Is " + ip5 + "  IPv4 Address valid ?: " + i.isValid(ip5));
    }

    public boolean isValid(String s) {
        int dotCount = 0;
        for (char c : s.toCharArray()) {
            if (c == '.') dotCount++;
        }

        if (dotCount > 3) return false;

        String[] decimals = s.split("\\.");

        if (decimals.length != 4) return false;

        for (String str : decimals) {
            try {
                int num = Integer.parseInt(str);
                if (num < 0 || num > 255) return false;

                if (Integer.toString(num).length() != str.length()) return false;
            } catch (NumberFormatException e) {
                return false;
            }
        }

        return true;
    }
}
