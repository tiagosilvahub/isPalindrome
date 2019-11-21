# isPalindrome
java implementation of determining if an int is a palindrome 

https://leetcode.com/problems/palindrome-number/

Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

Example 1:

Input: 121

Output: true

Example 2:

Input: -121

Output: false

Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

Example 3:

Input: 10

Output: false

Explanation: Reads 01 from right to left. Therefore it is not a palindrome.

First thoughts:

    - 0 is a palindrome.

    - All negative integers are not.

    - All numbers that end with a 0 are not (multiples of 10)

    - If the number was a string, and if the reserved string is equal to the original, then the number is a palindrome.

First solution, using StringBuilder reverse method:

```
    public boolean isPalindrome(int x) {
        StringBuilder s = new StringBuilder(String.valueOf(x));
        return s.toString().equals(s.reverse().toString());
    }
```

However, we can quickly see this is not the most efficient solution, even if it might be the most readable. Because it should only be necessary to do 1 comparison per digit, the first digit with the last, the second with the second last, etc.
By iterating over the integer as a char array we can do n/2 comparisons where n is the number of digits.
So while we will do fewer computations, we are not reducing the complexity since O(2n) == O(n/2). 

```
    public boolean isPalindrome(int x) {
        char[] c = String.valueOf(x).toCharArray();
        for (int i = 0, j = c.length - 1; i < j; i++, j--) {
            if (c[i] != c[j]) {
                return false;
            }
        }
        return true;
    }
```

If we use only math, we can reduce the usage of space too.

We can build a reserved number of the original by using the remainder of dividing by 10. 

For an even number of digits, if the reversed number is equal to the original then the number is a palindrome.
For an odd number of digits, if the reversed number is equal to the original while ignoring the middle digit, then the number is a palindrome.

```
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
```
