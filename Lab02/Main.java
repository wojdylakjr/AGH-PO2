import java.math.BigInteger;

public class Main {
    public static int extendedEuclid(int a, int b) {
        int x_0 = 1;
        int x = 0;
        int b_0 = b;
        while (b != 0) {
            int q = a / b;
            int temp = x;
            x = x_0 - q * x;
            x_0 = temp;
            temp = a % b;
            a = b;
            b = temp;
        }
        if (x_0 < 0) {
            x_0 = x_0 + b_0;
        }
        return x_0;
    }

    public static int[] codeWord(String[] args, BigInteger e, BigInteger n) {
        int[] arrayOfCodedWord = new int[args[0].length()];

        System.out.println("Typed word: " + args[0]);
        for (int i = 0; i < args[0].length(); i++) {
            int letterCode = args[0].charAt(i);
            BigInteger letter = new BigInteger("" + letterCode);
            arrayOfCodedWord[i] = letter.modPow(e, n).intValue();
        }
        return arrayOfCodedWord;
    }

    public static String decodeWord(int[] arrayOfCodedWord, BigInteger d, BigInteger n) {
        byte[] arrayOfDecodedWord = new byte[arrayOfCodedWord.length];
        for (int i = 0; i < arrayOfCodedWord.length; i++) {
            BigInteger codedLetter = new BigInteger("" + arrayOfCodedWord[i]);
            arrayOfDecodedWord[i] = codedLetter.modPow(d, n).byteValueExact();
        }
//        for (byte number : arrayOfDecodedWord) {
//            System.out.print(number + " ");
//        }
//        System.out.println();

        return new String(arrayOfDecodedWord);

    }

    public static void main(String[] args) {
        int p = 397;
        int q = 103;
        int n = p * q;
        int x = (p - 1) * (q - 1);
        BigInteger fi_n = new BigInteger("" + x);
        BigInteger e = new BigInteger("" + 3);

        while (e.gcd(fi_n).intValue() != 1) {
            e = e.add(new BigInteger("" + 2));
        }
        System.out.println("e: " + e);

        int d = Main.extendedEuclid(e.intValue(), fi_n.intValue());
        System.out.println("d: " + d);

        if (args.length > 0) {
            int[] arrayOfCodedWord = codeWord(args, e, new BigInteger("" + n));
            System.out.print("Array of coded word: ");
            for (int number : arrayOfCodedWord) {
                System.out.print(number + " ");
            }
            System.out.println();

            String decodedWord = decodeWord(arrayOfCodedWord, new BigInteger("" + d), new BigInteger("" + n));
            System.out.println("Decoded word: " + decodedWord);
        }
    }
}