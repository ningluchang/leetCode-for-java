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
        boolean result = isPalindrome.isPalindromeNumber(123321);
        System.out.println(result);
    }

    // 转字符串然后翻转解法
    public boolean isPalindromeString(int x) {
        String str = String.valueOf(x);
        if (str.charAt(str.length() - 1) == '0') {
            return false;
        }
        return str.contentEquals(new StringBuffer(str).reverse());
    }

    // 翻转数字解法
    public boolean isPalindromeNumber(int x) {
        // 判断x是否小于0或者x的最后一位是否是0
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while (x > revertedNumber) {
            // revertedNumber * 10 + (x % 10) 是取到x的最后一位并放到revertedNumber里
            // revertedNumber * 10是在给数字添加位数
            revertedNumber = revertedNumber * 10 + (x % 10);
            // x除等与10，也就是去掉x的最后一位，以便下次循环再取
            x /= 10;
        }
        /*
         * 当x为偶数时，前者为true
         * 比如x是1221，循环两次之后x=12 revertedNumber=12，此时x==revertedNumber，不符合循环条件，循环结束
         *
         * 当x为奇数时，后者为true
         * 比如x是12321，循环三次之后x=12 revertedNumber=123，此时不符合循环条件
         * 奇数回文数中间的数不参与比较，所以去掉revertedNumber的最后一位就会与x相等
         * */
        return x == revertedNumber || x == revertedNumber / 10;
    }
}