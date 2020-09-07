package problems.done;

import java.util.HashMap;
import java.util.Map;

public class ModularExponentiation {
    public static void main(String[] args) {
        System.out.println(optimizeGeResult(450, 768, 517));
    }

    public static long geModularResult(long a, long b, long c) {
        Map<String, Long> dp = new HashMap<>();
        return geResult(a, c, 1, b, dp);
    }

    private static long geResult(long a, long c, long start, long end, Map<String, Long> dp) {
        if (dp.containsKey(start + "" + end)) {
            return dp.get(start + "" + end);
        }
        if (start < end) {
            long mid = start + (end - start) / 2;
            long leftPartResult = geResult(a, c, start, mid, dp);
            dp.put(start + "" + mid, leftPartResult);
            long rightPartResult = geResult(a, c, mid + 1, end, dp);
            dp.put((mid + 1) + "" + end, rightPartResult);
            return (leftPartResult * rightPartResult) % c;
        }
        dp.put(start + "" + end, a % c);
        return dp.get(start + "" + end);
    }

    public static long optimizeGeResult(long a, long b, long c) {
        if (b == 0) {
            return 1;
        }
        a = a % c;
        long result = 1;
        while (b > 0) {
            if ((b & 1) == 1l) {
                result = (result * a) % c;
            }
            a = (a * a) % c;
            b = b >> 1;
        }
        return result;
    }
}
