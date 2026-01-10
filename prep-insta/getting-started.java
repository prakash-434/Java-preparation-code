import java.util.Scanner;
import java.util.ArrayList;

public class NumberProblemsCompendium {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        
        do {
            displayMenu();
            choice = sc.nextInt();
            
            switch(choice) {
                case 1: checkPositiveNegative(sc); break;
                case 2: checkEvenOdd(sc); break;
                case 3: sumFirstNNatural(sc); break;
                case 4: sumNNaturalNumbers(sc); break;
                case 5: sumInRange(sc); break;
                case 6: greatestOfTwo(sc); break;
                case 7: greatestOfThree(sc); break;
                case 8: checkLeapYear(sc); break;
                case 9: checkPrime(sc); break;
                case 10: primeInRange(sc); break;
                case 11: sumOfDigits(sc); break;
                case 12: reverseNumber(sc); break;
                case 13: checkPalindrome(sc); break;
                case 14: checkArmstrong(sc); break;
                case 15: armstrongInRange(sc); break;
                case 16: fibonacciSeries(sc); break;
                case 17: nthFibonacci(sc); break;
                case 18: factorial(sc); break;
                case 19: powerOfNumber(sc); break;
                case 20: factorsOfNumber(sc); break;
                case 21: primeFactors(sc); break;
                case 22: checkStrongNumber(sc); break;
                case 23: checkPerfectNumber(sc); break;
                case 24: checkPerfectSquare(sc); break;
                case 25: checkAutomorphic(sc); break;
                case 26: checkHarshad(sc); break;
                case 27: checkAbundant(sc); break;
                case 28: checkFriendlyPair(sc); break;
                case 0: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice!");
            }
            System.out.println();
        } while(choice != 0);
        
        sc.close();
    }
    
    // Display Menu
    static void displayMenu() {
        System.out.println("========== NUMBER PROBLEMS MENU ==========");
        System.out.println("1.  Positive or Negative");
        System.out.println("2.  Even or Odd");
        System.out.println("3.  Sum of First N Natural Numbers");
        System.out.println("4.  Sum of N Natural Numbers");
        System.out.println("5.  Sum in Given Range");
        System.out.println("6.  Greatest of Two Numbers");
        System.out.println("7.  Greatest of Three Numbers");
        System.out.println("8.  Leap Year Check");
        System.out.println("9.  Prime Number Check");
        System.out.println("10. Prime Numbers in Range");
        System.out.println("11. Sum of Digits");
        System.out.println("12. Reverse Number");
        System.out.println("13. Palindrome Check");
        System.out.println("14. Armstrong Number Check");
        System.out.println("15. Armstrong in Range");
        System.out.println("16. Fibonacci Series");
        System.out.println("17. Nth Fibonacci Term");
        System.out.println("18. Factorial");
        System.out.println("19. Power of Number");
        System.out.println("20. Factors of Number");
        System.out.println("21. Prime Factors");
        System.out.println("22. Strong Number");
        System.out.println("23. Perfect Number");
        System.out.println("24. Perfect Square");
        System.out.println("25. Automorphic Number");
        System.out.println("26. Harshad Number");
        System.out.println("27. Abundant Number");
        System.out.println("28. Friendly Pair");
        System.out.println("0.  Exit");
        System.out.print("Enter choice: ");
    }
    
    // 1. Positive or Negative - Using if-else
    static void checkPositiveNegative(Scanner sc) {
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        
        if(num > 0) {
            System.out.println(num + " is Positive");
        } else if(num < 0) {
            System.out.println(num + " is Negative");
        } else {
            System.out.println("Number is Zero");
        }
    }
    
    // 2. Even or Odd - Using modulo operator
    static void checkEvenOdd(Scanner sc) {
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        
        // Method 1: Using modulo
        if(num % 2 == 0) {
            System.out.println(num + " is Even");
        } else {
            System.out.println(num + " is Odd");
        }
        
        // Method 2: Using bitwise AND
        System.out.println("Using bitwise: " + ((num & 1) == 0 ? "Even" : "Odd"));
    }
    
    // 3. Sum of First N Natural Numbers - Using formula
    static void sumFirstNNatural(Scanner sc) {
        System.out.print("Enter N: ");
        int n = sc.nextInt();
        
        // Method 1: Formula
        int sum1 = n * (n + 1) / 2;
        System.out.println("Sum (formula): " + sum1);
        
        // Method 2: Loop
        int sum2 = 0;
        for(int i = 1; i <= n; i++) {
            sum2 += i;
        }
        System.out.println("Sum (loop): " + sum2);
    }
    
    // 4. Sum of N Natural Numbers (entering each number)
    static void sumNNaturalNumbers(Scanner sc) {
        System.out.print("How many numbers: ");
        int n = sc.nextInt();
        int sum = 0;
        
        System.out.println("Enter " + n + " numbers:");
        for(int i = 0; i < n; i++) {
            sum += sc.nextInt();
        }
        System.out.println("Sum: " + sum);
    }
    
    // 5. Sum in Range - Using loop
    static void sumInRange(Scanner sc) {
        System.out.print("Enter start: ");
        int start = sc.nextInt();
        System.out.print("Enter end: ");
        int end = sc.nextInt();
        
        int sum = 0;
        for(int i = start; i <= end; i++) {
            sum += i;
        }
        System.out.println("Sum from " + start + " to " + end + ": " + sum);
    }
    
    // 6. Greatest of Two - Using ternary operator
    static void greatestOfTwo(Scanner sc) {
        System.out.print("Enter first number: ");
        int a = sc.nextInt();
        System.out.print("Enter second number: ");
        int b = sc.nextInt();
        
        // Method 1: Ternary
        int max = (a > b) ? a : b;
        System.out.println("Greatest: " + max);
        
        // Method 2: Math.max()
        System.out.println("Using Math.max(): " + Math.max(a, b));
    }
    
    // 7. Greatest of Three - Nested if-else
    static void greatestOfThree(Scanner sc) {
        System.out.print("Enter three numbers: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        
        int max;
        if(a >= b && a >= c) {
            max = a;
        } else if(b >= a && b >= c) {
            max = b;
        } else {
            max = c;
        }
        System.out.println("Greatest: " + max);
    }
    
    // 8. Leap Year - Multiple conditions
    static void checkLeapYear(Scanner sc) {
        System.out.print("Enter year: ");
        int year = sc.nextInt();
        
        boolean isLeap = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        
        if(isLeap) {
            System.out.println(year + " is a Leap Year");
        } else {
            System.out.println(year + " is NOT a Leap Year");
        }
    }
    
    // 9. Prime Number - Optimized check
    static void checkPrime(Scanner sc) {
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        
        if(isPrime(num)) {
            System.out.println(num + " is Prime");
        } else {
            System.out.println(num + " is NOT Prime");
        }
    }
    
    // Helper method for prime check
    static boolean isPrime(int n) {
        if(n <= 1) return false;
        if(n <= 3) return true;
        if(n % 2 == 0 || n % 3 == 0) return false;
        
        // Check divisors up to sqrt(n)
        for(int i = 5; i * i <= n; i += 6) {
            if(n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
    
    // 10. Prime in Range - Using loop with prime check
    static void primeInRange(Scanner sc) {
        System.out.print("Enter start: ");
        int start = sc.nextInt();
        System.out.print("Enter end: ");
        int end = sc.nextInt();
        
        System.out.println("Prime numbers between " + start + " and " + end + ":");
        for(int i = start; i <= end; i++) {
            if(isPrime(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
    
    // 11. Sum of Digits - Using modulo and division
    static void sumOfDigits(Scanner sc) {
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        int original = num;
        int sum = 0;
        
        while(num > 0) {
            sum += num % 10;  // Extract last digit
            num /= 10;         // Remove last digit
        }
        System.out.println("Sum of digits of " + original + ": " + sum);
    }
    
    // 12. Reverse Number - Building reversed number
    static void reverseNumber(Scanner sc) {
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        int original = num;
        int reversed = 0;
        
        while(num != 0) {
            reversed = reversed * 10 + num % 10;
            num /= 10;
        }
        System.out.println("Reverse of " + original + ": " + reversed);
    }
    
    // 13. Palindrome - Compare with reverse
    static void checkPalindrome(Scanner sc) {
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        int original = num;
        int reversed = 0;
        
        while(num != 0) {
            reversed = reversed * 10 + num % 10;
            num /= 10;
        }
        
        if(original == reversed) {
            System.out.println(original + " is a Palindrome");
        } else {
            System.out.println(original + " is NOT a Palindrome");
        }
    }
    
    // 14. Armstrong Number - Sum of cubes of digits
    static void checkArmstrong(Scanner sc) {
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        
        if(isArmstrong(num)) {
            System.out.println(num + " is an Armstrong Number");
        } else {
            System.out.println(num + " is NOT an Armstrong Number");
        }
    }
    
    // Helper for Armstrong check
    static boolean isArmstrong(int n) {
        int original = n;
        int digits = String.valueOf(n).length();
        int sum = 0;
        
        while(n > 0) {
            int digit = n % 10;
            sum += Math.pow(digit, digits);
            n /= 10;
        }
        return sum == original;
    }
    
    // 15. Armstrong in Range
    static void armstrongInRange(Scanner sc) {
        System.out.print("Enter start: ");
        int start = sc.nextInt();
        System.out.print("Enter end: ");
        int end = sc.nextInt();
        
        System.out.println("Armstrong numbers between " + start + " and " + end + ":");
        for(int i = start; i <= end; i++) {
            if(isArmstrong(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
    
    // 16. Fibonacci Series - Iterative approach
    static void fibonacciSeries(Scanner sc) {
        System.out.print("Enter number of terms: ");
        int n = sc.nextInt();
        
        int a = 0, b = 1;
        System.out.print("Fibonacci Series: " + a + " " + b + " ");
        
        for(int i = 2; i < n; i++) {
            int next = a + b;
            System.out.print(next + " ");
            a = b;
            b = next;
        }
        System.out.println();
    }
    
    // 17. Nth Fibonacci - Recursive and Iterative
    static void nthFibonacci(Scanner sc) {
        System.out.print("Enter N: ");
        int n = sc.nextInt();
        
        // Iterative method
        System.out.println("Nth Fibonacci (iterative): " + fibIterative(n));
        
        // Recursive method (inefficient for large n)
        System.out.println("Nth Fibonacci (recursive): " + fibRecursive(n));
    }
    
    static int fibIterative(int n) {
        if(n <= 1) return n;
        int a = 0, b = 1;
        for(int i = 2; i <= n; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }
    
    static int fibRecursive(int n) {
        if(n <= 1) return n;
        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }
    
    // 18. Factorial - Iterative and Recursive
    static void factorial(Scanner sc) {
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        
        // Iterative
        long fact1 = 1;
        for(int i = 1; i <= n; i++) {
            fact1 *= i;
        }
        System.out.println("Factorial (iterative): " + fact1);
        
        // Recursive
        System.out.println("Factorial (recursive): " + factorialRecursive(n));
    }
    
    static long factorialRecursive(int n) {
        if(n <= 1) return 1;
        return n * factorialRecursive(n - 1);
    }
    
    // 19. Power of Number - Multiple approaches
    static void powerOfNumber(Scanner sc) {
        System.out.print("Enter base: ");
        int base = sc.nextInt();
        System.out.print("Enter exponent: ");
        int exp = sc.nextInt();
        
        // Method 1: Using Math.pow()
        System.out.println("Using Math.pow(): " + Math.pow(base, exp));
        
        // Method 2: Using loop
        long result = 1;
        for(int i = 0; i < exp; i++) {
            result *= base;
        }
        System.out.println("Using loop: " + result);
        
        // Method 3: Recursive
        System.out.println("Using recursion: " + powerRecursive(base, exp));
    }
    
    static long powerRecursive(int base, int exp) {
        if(exp == 0) return 1;
        return base * powerRecursive(base, exp - 1);
    }
    
    // 20. Factors of Number
    static void factorsOfNumber(Scanner sc) {
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        
        System.out.print("Factors of " + num + ": ");
        for(int i = 1; i <= num; i++) {
            if(num % i == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
    
    // 21. Prime Factors
    static void primeFactors(Scanner sc) {
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        
        System.out.print("Prime factors of " + num + ": ");
        
        // Divide by 2
        while(num % 2 == 0) {
            System.out.print(2 + " ");
            num /= 2;
        }
        
        // Check odd numbers
        for(int i = 3; i * i <= num; i += 2) {
            while(num % i == 0) {
                System.out.print(i + " ");
                num /= i;
            }
        }
        
        if(num > 2) {
            System.out.print(num);
        }
        System.out.println();
    }
    
    // 22. Strong Number - Sum of factorials of digits equals number
    static void checkStrongNumber(Scanner sc) {
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        int original = num;
        int sum = 0;
        
        while(num > 0) {
            int digit = num % 10;
            sum += factorialIterative(digit);
            num /= 10;
        }
        
        if(sum == original) {
            System.out.println(original + " is a Strong Number");
        } else {
            System.out.println(original + " is NOT a Strong Number");
        }
    }
    
    static int factorialIterative(int n) {
        int fact = 1;
        for(int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
    
    // 23. Perfect Number - Sum of proper divisors equals number
    static void checkPerfectNumber(Scanner sc) {
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        
        int sum = 0;
        for(int i = 1; i < num; i++) {
            if(num % i == 0) {
                sum += i;
            }
        }
        
        if(sum == num) {
            System.out.println(num + " is a Perfect Number");
        } else {
            System.out.println(num + " is NOT a Perfect Number");
        }
    }
    
    // 24. Perfect Square
    static void checkPerfectSquare(Scanner sc) {
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        
        int sqrt = (int) Math.sqrt(num);
        
        if(sqrt * sqrt == num) {
            System.out.println(num + " is a Perfect Square");
        } else {
            System.out.println(num + " is NOT a Perfect Square");
        }
    }
    
    // 25. Automorphic Number - Square ends with same digits
    static void checkAutomorphic(Scanner sc) {
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        
        long square = (long) num * num;
        String numStr = String.valueOf(num);
        String squareStr = String.valueOf(square);
        
        if(squareStr.endsWith(numStr)) {
            System.out.println(num + " is Automorphic (square: " + square + ")");
        } else {
            System.out.println(num + " is NOT Automorphic (square: " + square + ")");
        }
    }
    
    // 26. Harshad Number - Divisible by sum of its digits
    static void checkHarshad(Scanner sc) {
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        int original = num;
        int sum = 0;
        
        while(num > 0) {
            sum += num % 10;
            num /= 10;
        }
        
        if(original % sum == 0) {
            System.out.println(original + " is a Harshad Number");
        } else {
            System.out.println(original + " is NOT a Harshad Number");
        }
    }
    
    // 27. Abundant Number - Sum of proper divisors > number
    static void checkAbundant(Scanner sc) {
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        
        int sum = 0;
        for(int i = 1; i < num; i++) {
            if(num % i == 0) {
                sum += i;
            }
        }
        
        if(sum > num) {
            System.out.println(num + " is an Abundant Number (sum: " + sum + ")");
        } else {
            System.out.println(num + " is NOT an Abundant Number (sum: " + sum + ")");
        }
    }
    
    // 28. Friendly Pair - Same abundance ratio
    static void checkFriendlyPair(Scanner sc) {
        System.out.print("Enter first number: ");
        int num1 = sc.nextInt();
        System.out.print("Enter second number: ");
        int num2 = sc.nextInt();
        
        int sum1 = sumOfDivisors(num1);
        int sum2 = sumOfDivisors(num2);
        
        // Abundance ratio = sum of divisors / number
        if(sum1 * num2 == sum2 * num1) {
            System.out.println(num1 + " and " + num2 + " are Friendly Pair");
        } else {
            System.out.println(num1 + " and " + num2 + " are NOT Friendly Pair");
        }
    }
    
    static int sumOfDivisors(int n) {
        int sum = 0;
        for(int i = 1; i <= n; i++) {
            if(n % i == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
