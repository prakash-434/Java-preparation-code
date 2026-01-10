import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class RecursionAndArrayProblems {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        
        do {
            displayMenu();
            choice = sc.nextInt();
            sc.nextLine(); // Consume newline
            
            switch(choice) {
                case 1: powerOfNumber(sc); break;
                case 2: checkPrime(sc); break;
                case 3: largestInArray(sc); break;
                case 4: smallestInArray(sc); break;
                case 5: reverseNumber(sc); break;
                case 6: hcfUsingRecursion(sc); break;
                case 7: lcmOfNumbers(sc); break;
                case 8: stringLengthRecursion(sc); break;
                case 9: printPermutations(sc); break;
                case 10: fibonacciNthTerm(sc); break;
                case 11: subsetsSum(sc); break;
                case 12: lastNonZeroFactorial(sc); break;
                case 13: pascalTriangle(sc); break;
                case 14: generateParentheses(sc); break;
                case 15: factorialRecursion(sc); break;
                case 16: palindromicPartitions(sc); break;
                case 17: nBitBinary(sc); break;
                case 18: allSubsets(sc); break;
                case 19: removeAdjacentDuplicates(sc); break;
                case 0: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice!");
            }
            System.out.println();
        } while(choice != 0);
        
        sc.close();
    }
    
    // Display Menu
    static void displayMenu() {
        System.out.println("========== RECURSION & ARRAY PROBLEMS ==========");
        System.out.println("1.  Power of a Number");
        System.out.println("2.  Check Prime Number");
        System.out.println("3.  Largest Element in Array");
        System.out.println("4.  Smallest Element in Array");
        System.out.println("5.  Reverse a Number");
        System.out.println("6.  HCF using Recursion");
        System.out.println("7.  LCM of Two Numbers");
        System.out.println("8.  String Length using Recursion");
        System.out.println("9.  Print All Permutations of String");
        System.out.println("10. Nth Fibonacci Term");
        System.out.println("11. Sum of All Subsets");
        System.out.println("12. Last Non-Zero Digit in Factorial");
        System.out.println("13. Pascal's Triangle Nth Row");
        System.out.println("14. Generate Balanced Parentheses");
        System.out.println("15. Factorial using Recursion");
        System.out.println("16. All Palindromic Partitions");
        System.out.println("17. N-bit Binary (1's >= 0's)");
        System.out.println("18. All Subsets of a Set");
        System.out.println("19. Remove Adjacent Duplicates");
        System.out.println("0.  Exit");
        System.out.print("Enter choice: ");
    }
    
    // 1. Power of a Number - Multiple approaches
    static void powerOfNumber(Scanner sc) {
        System.out.print("Enter base: ");
        int base = sc.nextInt();
        System.out.print("Enter exponent: ");
        int exp = sc.nextInt();
        
        // Method 1: Iterative
        long result1 = 1;
        for(int i = 0; i < exp; i++) {
            result1 *= base;
        }
        System.out.println("Power (Iterative): " + result1);
        
        // Method 2: Recursive
        long result2 = powerRecursive(base, exp);
        System.out.println("Power (Recursive): " + result2);
        
        // Method 3: Optimized (Divide and Conquer)
        long result3 = powerOptimized(base, exp);
        System.out.println("Power (Optimized): " + result3);
    }
    
    static long powerRecursive(int base, int exp) {
        if(exp == 0) return 1;
        return base * powerRecursive(base, exp - 1);
    }
    
    static long powerOptimized(int base, int exp) {
        if(exp == 0) return 1;
        long half = powerOptimized(base, exp / 2);
        if(exp % 2 == 0) {
            return half * half;
        } else {
            return base * half * half;
        }
    }
    
    // 2. Prime Number Check - Recursive approach
    static void checkPrime(Scanner sc) {
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        
        // Method 1: Iterative
        boolean isPrime1 = isPrimeIterative(num);
        System.out.println(num + " is " + (isPrime1 ? "Prime" : "Not Prime") + " (Iterative)");
        
        // Method 2: Recursive
        boolean isPrime2 = isPrimeRecursive(num, 2);
        System.out.println(num + " is " + (isPrime2 ? "Prime" : "Not Prime") + " (Recursive)");
    }
    
    static boolean isPrimeIterative(int n) {
        if(n <= 1) return false;
        if(n <= 3) return true;
        if(n % 2 == 0 || n % 3 == 0) return false;
        for(int i = 5; i * i <= n; i += 6) {
            if(n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }
    
    static boolean isPrimeRecursive(int n, int divisor) {
        if(n <= 1) return false;
        if(n == 2) return true;
        if(n % divisor == 0) return false;
        if(divisor * divisor > n) return true;
        return isPrimeRecursive(n, divisor + 1);
    }
    
    // 3. Largest Element in Array
    static void largestInArray(Scanner sc) {
        System.out.print("Enter array size: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        
        System.out.println("Enter " + n + " elements:");
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        // Method 1: Iterative
        int max1 = arr[0];
        for(int i = 1; i < n; i++) {
            if(arr[i] > max1) {
                max1 = arr[i];
            }
        }
        System.out.println("Largest (Iterative): " + max1);
        
        // Method 2: Recursive
        int max2 = findMaxRecursive(arr, n - 1);
        System.out.println("Largest (Recursive): " + max2);
        
        // Method 3: Using Arrays.stream()
        int max3 = Arrays.stream(arr).max().getAsInt();
        System.out.println("Largest (Stream): " + max3);
    }
    
    static int findMaxRecursive(int[] arr, int index) {
        if(index == 0) return arr[0];
        return Math.max(arr[index], findMaxRecursive(arr, index - 1));
    }
    
    // 4. Smallest Element in Array
    static void smallestInArray(Scanner sc) {
        System.out.print("Enter array size: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        
        System.out.println("Enter " + n + " elements:");
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        // Method 1: Iterative
        int min1 = arr[0];
        for(int i = 1; i < n; i++) {
            if(arr[i] < min1) {
                min1 = arr[i];
            }
        }
        System.out.println("Smallest (Iterative): " + min1);
        
        // Method 2: Recursive
        int min2 = findMinRecursive(arr, n - 1);
        System.out.println("Smallest (Recursive): " + min2);
        
        // Method 3: Using Arrays.stream()
        int min3 = Arrays.stream(arr).min().getAsInt();
        System.out.println("Smallest (Stream): " + min3);
    }
    
    static int findMinRecursive(int[] arr, int index) {
        if(index == 0) return arr[0];
        return Math.min(arr[index], findMinRecursive(arr, index - 1));
    }
    
    // 5. Reverse a Number - Recursive
    static void reverseNumber(Scanner sc) {
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        
        // Method 1: Iterative
        int reversed1 = 0;
        int temp = num;
        while(temp != 0) {
            reversed1 = reversed1 * 10 + temp % 10;
            temp /= 10;
        }
        System.out.println("Reversed (Iterative): " + reversed1);
        
        // Method 2: Recursive
        int reversed2 = reverseRecursive(num, 0);
        System.out.println("Reversed (Recursive): " + reversed2);
    }
    
    static int reverseRecursive(int num, int rev) {
        if(num == 0) return rev;
        return reverseRecursive(num / 10, rev * 10 + num % 10);
    }
    
    // 6. HCF using Recursion (Euclidean Algorithm)
    static void hcfUsingRecursion(Scanner sc) {
        System.out.print("Enter first number: ");
        int a = sc.nextInt();
        System.out.print("Enter second number: ");
        int b = sc.nextInt();
        
        int hcf = findHCF(a, b);
        System.out.println("HCF of " + a + " and " + b + ": " + hcf);
    }
    
    static int findHCF(int a, int b) {
        if(b == 0) return a;
        return findHCF(b, a % b);
    }
    
    // 7. LCM of Two Numbers
    static void lcmOfNumbers(Scanner sc) {
        System.out.print("Enter first number: ");
        int a = sc.nextInt();
        System.out.print("Enter second number: ");
        int b = sc.nextInt();
        
        // LCM(a,b) = (a * b) / HCF(a,b)
        int hcf = findHCF(a, b);
        int lcm = (a * b) / hcf;
        
        System.out.println("LCM of " + a + " and " + b + ": " + lcm);
        System.out.println("Formula: (a × b) / HCF = (" + a + " × " + b + ") / " + hcf);
    }
    
    // 8. String Length using Recursion
    static void stringLengthRecursion(Scanner sc) {
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        
        // Method 1: Built-in
        System.out.println("Length (Built-in): " + str.length());
        
        // Method 2: Recursive
        int length = stringLengthRec(str);
        System.out.println("Length (Recursive): " + length);
    }
    
    static int stringLengthRec(String str) {
        if(str.equals("")) return 0;
        return 1 + stringLengthRec(str.substring(1));
    }
    
    // 9. Print All Permutations of String
    static void printPermutations(Scanner sc) {
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        
        System.out.println("All permutations of '" + str + "':");
        List<String> result = new ArrayList<>();
        permuteHelper("", str, result);
        
        for(int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
            if((i + 1) % 10 == 0) System.out.println();
        }
        System.out.println("\nTotal permutations: " + result.size());
    }
    
    static void permuteHelper(String prefix, String remaining, List<String> result) {
        if(remaining.length() == 0) {
            result.add(prefix);
            return;
        }
        
        for(int i = 0; i < remaining.length(); i++) {
            char ch = remaining.charAt(i);
            String newRemaining = remaining.substring(0, i) + remaining.substring(i + 1);
            permuteHelper(prefix + ch, newRemaining, result);
        }
    }
    
    // 10. Nth Fibonacci Term
    static void fibonacciNthTerm(Scanner sc) {
        System.out.print("Enter N: ");
        int n = sc.nextInt();
        
        // Method 1: Recursive (inefficient for large n)
        long fib1 = fibRecursive(n);
        System.out.println("Fibonacci F(" + n + ") [Recursive]: " + fib1);
        
        // Method 2: Iterative (efficient)
        long fib2 = fibIterative(n);
        System.out.println("Fibonacci F(" + n + ") [Iterative]: " + fib2);
        
        // Method 3: Memoization (efficient recursion)
        long[] memo = new long[n + 1];
        Arrays.fill(memo, -1);
        long fib3 = fibMemoization(n, memo);
        System.out.println("Fibonacci F(" + n + ") [Memoization]: " + fib3);
    }
    
    static long fibRecursive(int n) {
        if(n <= 1) return n;
        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }
    
    static long fibIterative(int n) {
        if(n <= 1) return n;
        long a = 0, b = 1;
        for(int i = 2; i <= n; i++) {
            long temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }
    
    static long fibMemoization(int n, long[] memo) {
        if(n <= 1) return n;
        if(memo[n] != -1) return memo[n];
        memo[n] = fibMemoization(n - 1, memo) + fibMemoization(n - 2, memo);
        return memo[n];
    }
    
    // 11. Sum of All Subsets
    static void subsetsSum(Scanner sc) {
        System.out.print("Enter array size: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        
        System.out.println("Enter " + n + " elements:");
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        List<Integer> sums = new ArrayList<>();
        subsetSumHelper(arr, 0, 0, sums);
        
        System.out.println("Sums of all subsets:");
        for(int i = 0; i < sums.size(); i++) {
            System.out.print(sums.get(i) + " ");
            if((i + 1) % 10 == 0) System.out.println();
        }
        System.out.println("\nTotal subsets: " + sums.size());
    }
    
    static void subsetSumHelper(int[] arr, int index, int sum, List<Integer> sums) {
        if(index == arr.length) {
            sums.add(sum);
            return;
        }
        
        // Include current element
        subsetSumHelper(arr, index + 1, sum + arr[index], sums);
        
        // Exclude current element
        subsetSumHelper(arr, index + 1, sum, sums);
    }
    
    // 12. Last Non-Zero Digit in Factorial
    static void lastNonZeroFactorial(Scanner sc) {
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        
        int lastDigit = findLastNonZeroDigit(n);
        System.out.println("Last non-zero digit of " + n + "!: " + lastDigit);
    }
    
    static int findLastNonZeroDigit(int n) {
        if(n < 2) return 1;
        
        // For small numbers, calculate directly
        if(n < 10) {
            long fact = 1;
            for(int i = 2; i <= n; i++) {
                fact *= i;
            }
            // Remove trailing zeros
            while(fact % 10 == 0) {
                fact /= 10;
            }
            return (int)(fact % 10);
        }
        
        // For larger numbers, use pattern-based approach
        int[] table = {1, 1, 2, 6, 4, 2, 2, 4, 2, 8};
        
        if(n < 10) return table[n];
        
        if(((n / 10) % 10) % 2 == 1) {
            return (4 * table[n % 10] * table[n / 5]) % 10;
        } else {
            return (6 * table[n % 10] * table[n / 5]) % 10;
        }
    }
    
    // 13. Pascal's Triangle Nth Row
    static void pascalTriangle(Scanner sc) {
        System.out.print("Enter row number N: ");
        int n = sc.nextInt();
        
        // Method 1: Using recursion and combination formula
        System.out.print("Row " + n + " of Pascal's Triangle: ");
        for(int i = 0; i <= n; i++) {
            System.out.print(binomialCoeff(n, i) + " ");
        }
        System.out.println();
        
        // Method 2: Using dynamic programming
        List<Integer> row = pascalRow(n);
        System.out.print("Row " + n + " (DP approach): ");
        for(int num : row) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    
    static int binomialCoeff(int n, int k) {
        if(k == 0 || k == n) return 1;
        return binomialCoeff(n - 1, k - 1) + binomialCoeff(n - 1, k);
    }
    
    static List<Integer> pascalRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1);
        
        for(int i = 1; i <= rowIndex; i++) {
            for(int j = row.size() - 1; j > 0; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
            row.add(1);
        }
        return row;
    }
    
    // 14. Generate Balanced Parentheses
    static void generateParentheses(Scanner sc) {
        System.out.print("Enter number of pairs: ");
        int n = sc.nextInt();
        
        List<String> result = new ArrayList<>();
        generateParenHelper(result, "", 0, 0, n);
        
        System.out.println("All combinations of " + n + " pairs of balanced parentheses:");
        for(String combo : result) {
            System.out.println(combo);
        }
        System.out.println("Total combinations: " + result.size());
    }
    
    static void generateParenHelper(List<String> result, String current, int open, int close, int max) {
        if(current.length() == max * 2) {
            result.add(current);
            return;
        }
        
        if(open < max) {
            generateParenHelper(result, current + "(", open + 1, close, max);
        }
        if(close < open) {
            generateParenHelper(result, current + ")", open, close + 1, max);
        }
    }
    
    // 15. Factorial using Recursion
    static void factorialRecursion(Scanner sc) {
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        
        // Method 1: Iterative
        long fact1 = 1;
        for(int i = 1; i <= n; i++) {
            fact1 *= i;
        }
        System.out.println("Factorial (Iterative): " + fact1);
        
        // Method 2: Recursive
        long fact2 = factorialRec(n);
        System.out.println("Factorial (Recursive): " + fact2);
        
        // Method 3: Tail Recursion
        long fact3 = factorialTailRec(n, 1);
        System.out.println("Factorial (Tail Recursion): " + fact3);
    }
    
    static long factorialRec(int n) {
        if(n <= 1) return 1;
        return n * factorialRec(n - 1);
    }
    
    static long factorialTailRec(int n, long accumulator) {
        if(n <= 1) return accumulator;
        return factorialTailRec(n - 1, n * accumulator);
    }
    
    // 16. All Palindromic Partitions
    static void palindromicPartitions(Scanner sc) {
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        
        List<List<String>> result = new ArrayList<>();
        palindromePartitionHelper(str, 0, new ArrayList<>(), result);
        
        System.out.println("All palindromic partitions of '" + str + "':");
        for(List<String> partition : result) {
            System.out.println(partition);
        }
        System.out.println("Total partitions: " + result.size());
    }
    
    static void palindromePartitionHelper(String s, int start, List<String> current, List<List<String>> result) {
        if(start == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        for(int end = start + 1; end <= s.length(); end++) {
            String substring = s.substring(start, end);
            if(isPalindrome(substring)) {
                current.add(substring);
                palindromePartitionHelper(s, end, current, result);
                current.remove(current.size() - 1);
            }
        }
    }
    
    static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
    
    // 17. N-bit Binary Numbers (1's >= 0's)
    static void nBitBinary(Scanner sc) {
        System.out.print("Enter N (number of bits): ");
        int n = sc.nextInt();
        
        List<String> result = new ArrayList<>();
        nBitBinaryHelper("", n, 0, 0, result);
        
        System.out.println("All " + n + "-bit binary numbers with 1's >= 0's:");
        for(int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
            if((i + 1) % 8 == 0) System.out.println();
        }
        System.out.println("\nTotal count: " + result.size());
    }
    
    static void nBitBinaryHelper(String current, int n, int ones, int zeros, List<String> result) {
        if(n == 0) {
            result.add(current);
            return;
        }
        
        // Add '1'
        nBitBinaryHelper(current + "1", n - 1, ones + 1, zeros, result);
        
        // Add '0' only if ones > zeros
        if(ones > zeros) {
            nBitBinaryHelper(current + "0", n - 1, ones, zeros + 1, result);
        }
    }
    
    // 18. All Subsets of a Set
    static void allSubsets(Scanner sc) {
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        
        System.out.println("Enter " + n + " elements:");
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        // Method 1: Using recursion (backtracking)
        System.out.println("\nAll subsets (Backtracking):");
        List<List<Integer>> subsets1 = new ArrayList<>();
        findSubsetsBacktrack(arr, 0, new ArrayList<>(), subsets1);
        printSubsets(subsets1);
        
        // Method 2: Using bit manipulation
        System.out.println("\nAll subsets (Bit Manipulation):");
        List<List<Integer>> subsets2 = findSubsetsBitwise(arr);
        printSubsets(subsets2);
    }
    
    static void findSubsetsBacktrack(int[] arr, int index, List<Integer> current, List<List<Integer>> result) {
        if(index == arr.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        // Include current element
        current.add(arr[index]);
        findSubsetsBacktrack(arr, index + 1, current, result);
        current.remove(current.size() - 1);
        
        // Exclude current element
        findSubsetsBacktrack(arr, index + 1, current, result);
    }
    
    static List<List<Integer>> findSubsetsBitwise(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        int n = arr.length;
        int totalSubsets = 1 << n; // 2^n
        
        for(int i = 0; i < totalSubsets; i++) {
            List<Integer> subset = new ArrayList<>();
            for(int j = 0; j < n; j++) {
                if((i & (1 << j)) != 0) {
                    subset.add(arr[j]);
                }
            }
            result.add(subset);
        }
        return result;
    }
    
    static void printSubsets(List<List<Integer>> subsets) {
        for(List<Integer> subset : subsets) {
            System.out.print("{ ");
            for(int num : subset) {
                System.out.print(num + " ");
            }
            System.out.println("}");
        }
        System.out.println("Total subsets: " + subsets.size());
    }
    
    // 19. Remove Adjacent Duplicates Recursively
    static void removeAdjacentDuplicates(Scanner sc) {
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        
        // Method 1: Simple recursive
        String result1 = removeAdjDuplicates(str);
        System.out.println("Result (Simple): " + result1);
        
        // Method 2: Complete removal (keep removing until no duplicates)
        String result2 = removeAllAdjDuplicates(str);
        System.out.println("Result (Complete): " + result2);
    }
    
    static String removeAdjDuplicates(String s) {
        if(s.length() <= 1) return s;
        
        if(s.charAt(0) == s.charAt(1)) {
            return removeAdjDuplicates(s.substring(1));
        }
        
        return s.charAt(0) + removeAdjDuplicates(s.substring(1));
    }
    
    static String removeAllAdjDuplicates(String s) {
        if(s.length() <= 1) return s;
        
        StringBuilder sb = new StringBuilder();
        int i = 0;
        
        while(i < s.length()) {
            if(i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                // Skip all consecutive duplicates
                while(i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                    i++;
                }
                i++; // Skip the last duplicate
            } else {
                sb.append(s.charAt(i));
                i++;
            }
        }
        
        String result = sb.toString();
        
        // If string changed, recursively remove again
        if(result.equals(s)) {
            return result;
        } else {
            return removeAllAdjDuplicates(result);
        }
    }
}