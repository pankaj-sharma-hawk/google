package problems.done;

import java.util.Arrays;

public class FindBinaryOfGivenNumber {

    public static void main(String[] args) {
        System.out.println(getBinaryOfGivenNumber(50));
    }

    public static String getBinaryOfGivenNumber(Integer number) {
        int size = getMaximumPowerOf2OfGivenNumber(number);
        char binaryChar[] = new char[size + 1];
        Arrays.fill(binaryChar,'0');
        binaryChar[0] = '1';
        number = (int) (number - Math.pow(2, size));
        while (number > 0) {
            int index = getMaximumPowerOf2OfGivenNumber(number);
            binaryChar[size - index] = '1';
            number = (int) (number - Math.pow(2, index));
        }
        return new String(binaryChar);
    }

    private static int getMaximumPowerOf2OfGivenNumber(Integer number) {
        int i = 1;
        int power = 0;
        while (i <= number) {
            power++;
            i = i << 1;
        }
        return power - 1;
    }
}


