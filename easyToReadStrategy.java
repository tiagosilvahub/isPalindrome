public class easyToReadStrategy implements SolutionStrategy {
    public boolean isPalindrome(int x) {
        StringBuilder s = new StringBuilder(String.valueOf(x));
        return s.toString().equals(s.reverse().toString());
    }
}
