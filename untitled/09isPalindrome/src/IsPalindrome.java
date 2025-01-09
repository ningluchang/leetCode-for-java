/**
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * <p>
 * 回文数
 * 是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 例如，121 是回文，而 123 不是。
 */
public class IsPalindrome {
    public static void main(String[] args) {
        IsPalindrome isPalindrome = new IsPalindrome();
        boolean result = isPalindrome.isPalindrome(12220);
        System.out.println(result);
    }

    public boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        if (str.charAt(str.length() - 1) == '0') {
            return false;
        }
        return str.contentEquals(new StringBuffer(str).reverse());
    }
}