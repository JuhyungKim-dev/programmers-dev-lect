public class Main {

    public static void main(String[] args) {

        System.out.println("=== normalizeSpaces ===");
        System.out.println(StringUtils.normalizeSpaces("  hello   world  "));

        System.out.println("=== reverse ===");
        System.out.println(StringUtils.reverse("abc def"));

        System.out.println("=== isPalindrome ===");
        System.out.println(StringUtils.isPalindrome("nurses run"));
        System.out.println(StringUtils.isPalindrome("hello"));

        System.out.println("=== countWords ===");
        System.out.println(StringUtils.countWords("  one   two   three  "));
    }
}