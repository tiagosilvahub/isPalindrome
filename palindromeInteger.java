public class palindromeInteger {
    public static void main(String[] args) {
        SolutionStrategy[] strategies =
                new SolutionStrategy[]{
                        // Add strategies here
                        new mathOnlyStrategy(),
                        new charArrayStrategy(),
                        new stringBuilderReverseStrategy()
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
        printResults(errors, nTestCases * strategies.length);
    }

    private static void printResults(int errors, int nTestCases) {
        if(errors == 0) {
            System.out.println("All tests passed!");
        } else {
            System.out.println(errors + " tests failed.");
            System.out.println(nTestCases - errors + " tests passed.");
            System.out.println((0.0 + nTestCases - errors) / nTestCases * 100  + "% of tests passed.");
        }
    }
}
