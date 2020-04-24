
public class Reverse {
    public static void main(String... args){
        String toBeReversed = ".eslaf eb t'ndluow ecnetnes siht ,dehctiws erew eslaf dna eurt fo sgninaem eht fI";

        // Create a method that can reverse a String, which is passed as the parameter
        // Use it on this reversed string to check it!
        // Try to solve this using charAt() first, and optionally anything else after.

        System.out.println(reverse(toBeReversed));
    }
    static String reverse(String toBeReversed) {
        Character[] stringByChar = new Character[toBeReversed.length()];
        Character[] newStringByChar = new Character[toBeReversed.length()];

        for (int i = 0; i < toBeReversed.length(); i++) {
            stringByChar[i] = toBeReversed.charAt(i);
            newStringByChar[toBeReversed.length()-i-1] = stringByChar[i];
        }
        String result = "";
        for (int i = 0; i < newStringByChar.length; i++) {
            result = result + newStringByChar[i];
        }
        return result;
        }

    }

