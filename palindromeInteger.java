public class palindromeInteger {
    public static void main(String[] args) {
        SolutionStrategy[] strategies =
                new SolutionStrategy[]{
                        // Add strategies here
                        new mathOnlyStrategy(),
                        new fastStrategy(),
                        new easyToReadStrategy()
        };
        int[] input = {121, -121, 121212121, 1212321, 1111};
        boolean[] output = {true, false, true, false, true};
        boolean result;
        int errors = 0;

        int nTestCases = input.length;
        for (SolutionStrategy s : strategies) {
            for (int i = 0; i < nTestCases; i++) {
                result = s.isPalindrome(input[i]);
                if(result != output[i]) {
                    System.out.println("Solution " + s.getClass().getName() + " wrong for input " + input[i]);
                    System.out.println("Expected: " + output[i] + " but got: " + result);
                    System.out.println();
                    errors++;
                }
            }
        }
        printResults(errors, nTestCases);
    }

    private static void printResults(int errors, int nTestCases) {
        if(errors == 0) {
            System.out.println("All tests passed!");
        } else {
            System.out.println(errors + " tests failed.");
            System.out.println(nTestCases - errors + " tests passed.");
            System.out.println(nTestCases / errors + "% of tests passed.");
        }
    }

}

interface SolutionStrategy {
    boolean isPalindrome(int x);
}

class easyToReadStrategy implements SolutionStrategy {
    public boolean isPalindrome(int x) {
        StringBuilder s = new StringBuilder(String.valueOf(x));
        return s.toString().equals(s.reverse().toString());
    }
}

class fastStrategy implements SolutionStrategy {
    public boolean isPalindrome(int x) {
        char[] c = String.valueOf(x).toCharArray();
        for (int i = 0, j = c.length - 1; i < j; i++, j--) {
            if (c[i] != c[j]) {
                return false;
            }
        }
        return true;
    }
}

class mathOnlyStrategy implements SolutionStrategy {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }
        int reverse = 0;
        while (x > reverse) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }
        return x == reverse || x == reverse / 10;
    }
}
