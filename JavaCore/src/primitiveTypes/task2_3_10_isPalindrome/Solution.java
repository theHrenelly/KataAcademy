package primitiveTypes.task2_3_10_isPalindrome;

public class Solution {
    public static void main(String[] args) {
        System.out.println(isPalindrome("Was it a cat I saw?"));
        System.out.println(isPalindrome2("Was it a cat I saw?"));
    }

    public static boolean isPalindrome(String text) {
        text = text.replaceAll("[^a-zA-Z0-9]", "");
        return text.equalsIgnoreCase(new StringBuilder(text).reverse().toString());
    }

    public static boolean isPalindrome2(String text) {
        StringBuilder leftToRight = new StringBuilder();

        text.chars()
                .filter(Character::isLetterOrDigit)
//                .map(Character::toLowerCase)
                .forEach(leftToRight::appendCodePoint);

        StringBuilder rightToLeft = new StringBuilder(leftToRight).reverse();

        return leftToRight.toString().equalsIgnoreCase(rightToLeft.toString());
    }
}