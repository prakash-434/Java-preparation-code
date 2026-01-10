import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WorkingWithNumbers {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        
        do {
            displayMenu();
            choice = sc.nextInt();
            
            switch(choice) {
                case 1: findHCF(sc); break;
                case 2: findLCM(sc); break;
                case 3: findGCD(sc); break;
                case 4: binaryToDecimal(sc); break;
                case 5: octalToDecimal(sc); break;
                case 6: hexadecimalToDecimal(sc); break;
                case 7: decimalToBinary(sc); break;
                case 8: decimalToOctal(sc); break;
                case 9: decimalToHexadecimal(sc); break;
                case 10: binaryToOctal(sc); break;
                case 11: octalToBinary(sc); break;
                case 12: findQuadrant(sc); break;
                case 13: permutations(sc); break;
                case 14: maxHandshakes(sc); break;
                case 15: addFractions(sc); break;
                case 16: replaceZeroWithOne(sc); break;
                case 17: sumOfTwoPrimes(sc); break;
                case 18: countDecodings(sc); break;
                case 19: areaOfCircle(sc); break;
                case 20: primesUpTo100(); break;
                case 21: countDigits(sc); break;
                case 22: numberToWords(sc); break;
                case 23: daysInMonth(sc); break;
                case 24: countDigitOccurrence(sc); break;
                case 25: numbersWithXDivisors(sc); break;
                case 0: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice!");
            }
            System.out.println();
        } while(choice != 0);
        
        sc.close();
    }
    
    // Display Menu
    static void displayMenu() {
        System.out.println("========== WORKING WITH NUMBERS ==========");
        System.out.println("1.  HCF (Highest Common Factor)");
        System.out.println("2.  LCM (Lowest Common Multiple)");
        System.out.println("3.  GCD (Greatest Common Divisor)");
        System.out.println("4.  Binary to Decimal");
        System.out.println("5.  Octal to Decimal");
        System.out.println("6.  Hexadecimal to Decimal");
        System.out.println("7.  Decimal to Binary");
        System.out.println("8.  Decimal to Octal");
        System.out.println("9.  Decimal to Hexadecimal");
        System.out.println("10. Binary to Octal");
        System.out.println("11. Octal to Binary");
        System.out.println("12. Coordinate Quadrant");
        System.out.println("13. Permutations (n people, r seats)");
        System.out.println("14. Maximum Handshakes");
        System.out.println("15. Addition of Two Fractions");
        System.out.println("16. Replace 0's with 1's");
        System.out.println("17. Sum of Two Prime Numbers");
        System.out.println("18. Count Decodings");
        System.out.println("19. Area of Circle");
        System.out.println("20. Prime Numbers 1-100");
        System.out.println("21. Count Digits");
        System.out.println("22. Number to Words");
        System.out.println("23. Days in Month");
        System.out.println("24. Count Digit Occurrence");
        System.out.println("25. Numbers with X Divisors");
        System.out.println("0.  Exit");
        System.out.print("Enter choice: ");
    }
    
    // 1. HCF using Euclidean Algorithm
    static void findHCF(Scanner sc) {
        System.out.print("Enter first number: ");
        int a = sc.nextInt();
        System.out.print("Enter second number: ");
        int b = sc.nextInt();
        
        // Method 1: Euclidean Algorithm (Iterative)
        int hcf1 = findHCFIterative(a, b);
        System.out.println("HCF (Iterative): " + hcf1);
        
        // Method 2: Recursive
        int hcf2 = findHCFRecursive(a, b);
        System.out.println("HCF (Recursive): " + hcf2);
    }
    
    static int findHCFIterative(int a, int b) {
        while(b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    static int findHCFRecursive(int a, int b) {
        if(b == 0) return a;
        return findHCFRecursive(b, a % b);
    }
    
    // 2. LCM using formula: LCM(a,b) = (a * b) / HCF(a,b)
    static void findLCM(Scanner sc) {
        System.out.print("Enter first number: ");
        int a = sc.nextInt();
        System.out.print("Enter second number: ");
        int b = sc.nextInt();
        
        int hcf = findHCFRecursive(a, b);
        int lcm = (a * b) / hcf;
        
        System.out.println("LCM: " + lcm);
        System.out.println("Formula: (a × b) / HCF = (" + a + " × " + b + ") / " + hcf);
    }
    
    // 3. GCD (Same as HCF)
    static void findGCD(Scanner sc) {
        System.out.print("Enter first number: ");
        int a = sc.nextInt();
        System.out.print("Enter second number: ");
        int b = sc.nextInt();
        
        int gcd = findHCFRecursive(a, b);
        System.out.println("GCD: " + gcd);
        System.out.println("Note: GCD and HCF are the same thing");
    }
    
    // 4. Binary to Decimal
    static void binaryToDecimal(Scanner sc) {
        System.out.print("Enter binary number: ");
        String binary = sc.next();
        
        // Method 1: Using Integer.parseInt()
        int decimal1 = Integer.parseInt(binary, 2);
        System.out.println("Decimal (built-in): " + decimal1);
        
        // Method 2: Manual conversion
        int decimal2 = 0;
        int power = 0;
        for(int i = binary.length() - 1; i >= 0; i--) {
            if(binary.charAt(i) == '1') {
                decimal2 += Math.pow(2, power);
            }
            power++;
        }
        System.out.println("Decimal (manual): " + decimal2);
    }
    
    // 5. Octal to Decimal
    static void octalToDecimal(Scanner sc) {
        System.out.print("Enter octal number: ");
        String octal = sc.next();
        
        // Method 1: Using Integer.parseInt()
        int decimal1 = Integer.parseInt(octal, 8);
        System.out.println("Decimal (built-in): " + decimal1);
        
        // Method 2: Manual conversion
        int decimal2 = 0;
        int power = 0;
        for(int i = octal.length() - 1; i >= 0; i--) {
            int digit = octal.charAt(i) - '0';
            decimal2 += digit * Math.pow(8, power);
            power++;
        }
        System.out.println("Decimal (manual): " + decimal2);
    }
    
    // 6. Hexadecimal to Decimal
    static void hexadecimalToDecimal(Scanner sc) {
        System.out.print("Enter hexadecimal number: ");
        String hex = sc.next();
        
        // Method 1: Using Integer.parseInt()
        int decimal1 = Integer.parseInt(hex, 16);
        System.out.println("Decimal (built-in): " + decimal1);
        
        // Method 2: Manual conversion
        int decimal2 = 0;
        int power = 0;
        for(int i = hex.length() - 1; i >= 0; i--) {
            char ch = hex.charAt(i);
            int digit;
            if(ch >= '0' && ch <= '9') {
                digit = ch - '0';
            } else {
                digit = ch - 'A' + 10;  // or ch - 'a' + 10
            }
            decimal2 += digit * Math.pow(16, power);
            power++;
        }
        System.out.println("Decimal (manual): " + decimal2);
    }
    
    // 7. Decimal to Binary
    static void decimalToBinary(Scanner sc) {
        System.out.print("Enter decimal number: ");
        int decimal = sc.nextInt();
        
        // Method 1: Using Integer.toBinaryString()
        String binary1 = Integer.toBinaryString(decimal);
        System.out.println("Binary (built-in): " + binary1);
        
        // Method 2: Manual conversion using division
        StringBuilder binary2 = new StringBuilder();
        int num = decimal;
        while(num > 0) {
            binary2.insert(0, num % 2);
            num /= 2;
        }
        System.out.println("Binary (manual): " + binary2);
        
        // Method 3: Using bitwise operations
        StringBuilder binary3 = new StringBuilder();
        for(int i = 31; i >= 0; i--) {
            int bit = (decimal >> i) & 1;
            if(bit == 1 || binary3.length() > 0) {
                binary3.append(bit);
            }
        }
        System.out.println("Binary (bitwise): " + (binary3.length() == 0 ? "0" : binary3));
    }
    
    // 8. Decimal to Octal
    static void decimalToOctal(Scanner sc) {
        System.out.print("Enter decimal number: ");
        int decimal = sc.nextInt();
        
        // Method 1: Using Integer.toOctalString()
        String octal1 = Integer.toOctalString(decimal);
        System.out.println("Octal (built-in): " + octal1);
        
        // Method 2: Manual conversion
        StringBuilder octal2 = new StringBuilder();
        int num = decimal;
        while(num > 0) {
            octal2.insert(0, num % 8);
            num /= 8;
        }
        System.out.println("Octal (manual): " + octal2);
    }
    
    // 9. Decimal to Hexadecimal
    static void decimalToHexadecimal(Scanner sc) {
        System.out.print("Enter decimal number: ");
        int decimal = sc.nextInt();
        
        // Method 1: Using Integer.toHexString()
        String hex1 = Integer.toHexString(decimal).toUpperCase();
        System.out.println("Hexadecimal (built-in): " + hex1);
        
        // Method 2: Manual conversion
        StringBuilder hex2 = new StringBuilder();
        char[] hexChars = "0123456789ABCDEF".toCharArray();
        int num = decimal;
        while(num > 0) {
            hex2.insert(0, hexChars[num % 16]);
            num /= 16;
        }
        System.out.println("Hexadecimal (manual): " + hex2);
    }
    
    // 10. Binary to Octal (via Decimal)
    static void binaryToOctal(Scanner sc) {
        System.out.print("Enter binary number: ");
        String binary = sc.next();
        
        // Method 1: Binary -> Decimal -> Octal
        int decimal = Integer.parseInt(binary, 2);
        String octal1 = Integer.toOctalString(decimal);
        System.out.println("Octal (via decimal): " + octal1);
        
        // Method 2: Group by 3 bits
        // Pad left with zeros to make length multiple of 3
        while(binary.length() % 3 != 0) {
            binary = "0" + binary;
        }
        StringBuilder octal2 = new StringBuilder();
        for(int i = 0; i < binary.length(); i += 3) {
            String group = binary.substring(i, i + 3);
            int octalDigit = Integer.parseInt(group, 2);
            octal2.append(octalDigit);
        }
        System.out.println("Octal (grouping): " + octal2);
    }
    
    // 11. Octal to Binary
    static void octalToBinary(Scanner sc) {
        System.out.print("Enter octal number: ");
        String octal = sc.next();
        
        // Method 1: Octal -> Decimal -> Binary
        int decimal = Integer.parseInt(octal, 8);
        String binary1 = Integer.toBinaryString(decimal);
        System.out.println("Binary (via decimal): " + binary1);
        
        // Method 2: Each octal digit to 3 binary digits
        StringBuilder binary2 = new StringBuilder();
        for(int i = 0; i < octal.length(); i++) {
            int digit = octal.charAt(i) - '0';
            String binaryDigit = String.format("%3s", Integer.toBinaryString(digit)).replace(' ', '0');
            binary2.append(binaryDigit);
        }
        System.out.println("Binary (direct): " + binary2);
    }
    
    // 12. Quadrant of Coordinate
    static void findQuadrant(Scanner sc) {
        System.out.print("Enter x coordinate: ");
        int x = sc.nextInt();
        System.out.print("Enter y coordinate: ");
        int y = sc.nextInt();
        
        if(x == 0 && y == 0) {
            System.out.println("Point is at Origin");
        } else if(x == 0) {
            System.out.println("Point lies on Y-axis");
        } else if(y == 0) {
            System.out.println("Point lies on X-axis");
        } else if(x > 0 && y > 0) {
            System.out.println("Point lies in Quadrant I");
        } else if(x < 0 && y > 0) {
            System.out.println("Point lies in Quadrant II");
        } else if(x < 0 && y < 0) {
            System.out.println("Point lies in Quadrant III");
        } else {
            System.out.println("Point lies in Quadrant IV");
        }
    }
    
    // 13. Permutations: P(n,r) = n! / (n-r)!
    static void permutations(Scanner sc) {
        System.out.print("Enter total people (n): ");
        int n = sc.nextInt();
        System.out.print("Enter seats available (r): ");
        int r = sc.nextInt();
        
        if(r > n) {
            System.out.println("Invalid input: r cannot be greater than n");
            return;
        }
        
        // Calculate P(n,r) = n! / (n-r)!
        long permutation = factorial(n) / factorial(n - r);
        System.out.println("Permutations P(" + n + "," + r + "): " + permutation);
        System.out.println("Formula: n! / (n-r)! = " + factorial(n) + " / " + factorial(n-r));
    }
    
    static long factorial(int n) {
        if(n <= 1) return 1;
        long result = 1;
        for(int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
    
    // 14. Maximum Handshakes: nC2 = n(n-1)/2
    static void maxHandshakes(Scanner sc) {
        System.out.print("Enter number of people: ");
        int n = sc.nextInt();
        
        // Formula: nC2 = n * (n-1) / 2
        int handshakes = n * (n - 1) / 2;
        System.out.println("Maximum handshakes: " + handshakes);
        System.out.println("Formula: n(n-1)/2 = " + n + " × " + (n-1) + " / 2");
    }
    
    // 15. Addition of Two Fractions
    static void addFractions(Scanner sc) {
        System.out.print("Enter numerator of first fraction: ");
        int num1 = sc.nextInt();
        System.out.print("Enter denominator of first fraction: ");
        int denom1 = sc.nextInt();
        
        System.out.print("Enter numerator of second fraction: ");
        int num2 = sc.nextInt();
        System.out.print("Enter denominator of second fraction: ");
        int denom2 = sc.nextInt();
        
        // Add fractions: a/b + c/d = (ad + bc) / bd
        int numerator = num1 * denom2 + num2 * denom1;
        int denominator = denom1 * denom2;
        
        // Simplify by dividing by GCD
        int gcd = findHCFRecursive(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
        
        System.out.println(num1 + "/" + denom1 + " + " + num2 + "/" + denom2 + " = " + numerator + "/" + denominator);
    }
    
    // 16. Replace 0's with 1's
    static void replaceZeroWithOne(Scanner sc) {
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        
        // Method 1: Using String manipulation
        String numStr = String.valueOf(num);
        String replaced1 = numStr.replace('0', '1');
        System.out.println("Result (String method): " + replaced1);
        
        // Method 2: Mathematical approach
        int result = 0;
        int multiplier = 1;
        while(num > 0) {
            int digit = num % 10;
            if(digit == 0) {
                digit = 1;
            }
            result = digit * multiplier + result;
            multiplier *= 10;
            num /= 10;
        }
        System.out.println("Result (Math method): " + result);
    }
    
    // 17. Sum of Two Prime Numbers (Goldbach's Conjecture)
    static void sumOfTwoPrimes(Scanner sc) {
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        
        boolean found = false;
        System.out.println("Pairs of primes that sum to " + num + ":");
        
        for(int i = 2; i <= num / 2; i++) {
            if(isPrime(i) && isPrime(num - i)) {
                System.out.println(i + " + " + (num - i) + " = " + num);
                found = true;
            }
        }
        
        if(!found) {
            System.out.println("No pairs found");
        }
    }
    
    static boolean isPrime(int n) {
        if(n <= 1) return false;
        if(n <= 3) return true;
        if(n % 2 == 0 || n % 3 == 0) return false;
        for(int i = 5; i * i <= n; i += 6) {
            if(n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }
    
    // 18. Count Decodings (Dynamic Programming)
    static void countDecodings(Scanner sc) {
        System.out.print("Enter digit sequence: ");
        String digits = sc.next();
        
        int count = countWaysToDecodeDP(digits);
        System.out.println("Number of ways to decode: " + count);
        System.out.println("(A=1, B=2, ... Z=26)");
    }
    
    static int countWaysToDecodeDP(String s) {
        if(s == null || s.length() == 0 || s.charAt(0) == '0') return 0;
        
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        
        for(int i = 2; i <= n; i++) {
            // Single digit
            if(s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
            
            // Two digits
            int twoDigit = Integer.parseInt(s.substring(i - 2, i));
            if(twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        
        return dp[n];
    }
    
    // 19. Area of Circle
    static void areaOfCircle(Scanner sc) {
        System.out.print("Enter radius: ");
        double radius = sc.nextDouble();
        
        // Method 1: Using Math.PI
        double area1 = Math.PI * radius * radius;
        System.out.println("Area (Math.PI): " + area1);
        
        // Method 2: Using approximation
        double area2 = 3.14159 * radius * radius;
        System.out.println("Area (approx): " + area2);
        
        // Also calculate circumference
        double circumference = 2 * Math.PI * radius;
        System.out.println("Circumference: " + circumference);
    }
    
    // 20. Prime Numbers from 1 to 100
    static void primesUpTo100() {
        System.out.println("Prime numbers from 1 to 100:");
        
        // Method 1: Simple iteration
        int count = 0;
        for(int i = 2; i <= 100; i++) {
            if(isPrime(i)) {
                System.out.print(i + " ");
                count++;
                if(count % 10 == 0) System.out.println();
            }
        }
        System.out.println("\nTotal primes: " + count);
        
        // Method 2: Sieve of Eratosthenes (more efficient)
        System.out.println("\nUsing Sieve of Eratosthenes:");
        boolean[] isPrime = new boolean[101];
        for(int i = 2; i <= 100; i++) {
            isPrime[i] = true;
        }
        
        for(int i = 2; i * i <= 100; i++) {
            if(isPrime[i]) {
                for(int j = i * i; j <= 100; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        count = 0;
        for(int i = 2; i <= 100; i++) {
            if(isPrime[i]) {
                System.out.print(i + " ");
                count++;
                if(count % 10 == 0) System.out.println();
            }
        }
        System.out.println("\nTotal primes: " + count);
    }
    
    // 21. Count Digits
    static void countDigits(Scanner sc) {
        System.out.print("Enter a number: ");
        long num = sc.nextLong();
        
        // Method 1: Convert to String
        int count1 = String.valueOf(Math.abs(num)).length();
        System.out.println("Digit count (String): " + count1);
        
        // Method 2: Using loop
        int count2 = 0;
        long temp = Math.abs(num);
        if(temp == 0) {
            count2 = 1;
        } else {
            while(temp > 0) {
                temp /= 10;
                count2++;
            }
        }
        System.out.println("Digit count (Loop): " + count2);
        
        // Method 3: Using logarithm
        if(num != 0) {
            int count3 = (int)Math.log10(Math.abs(num)) + 1;
            System.out.println("Digit count (Log): " + count3);
        }
    }
    
    // 22. Number to Words
    static void numberToWords(Scanner sc) {
        System.out.print("Enter a number (0-999999): ");
        int num = sc.nextInt();
        
        if(num == 0) {
            System.out.println("Zero");
            return;
        }
        
        String words = convertToWords(num);
        System.out.println("In words: " + words);
    }
    
    static String convertToWords(int num) {
        String[] ones = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String[] teens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", 
                         "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        
        if(num < 10) {
            return ones[num];
        } else if(num < 20) {
            return teens[num - 10];
        } else if(num < 100) {
            return tens[num / 10] + (num % 10 != 0 ? " " + ones[num % 10] : "");
        } else if(num < 1000) {
            return ones[num / 100] + " Hundred" + (num % 100 != 0 ? " " + convertToWords(num % 100) : "");
        } else if(num < 1000000) {
            return convertToWords(num / 1000) + " Thousand" + (num % 1000 != 0 ? " " + convertToWords(num % 1000) : "");
        }
        return "";
    }
    
    // 23. Days in Month
    static void daysInMonth(Scanner sc) {
        System.out.print("Enter month (1-12): ");
        int month = sc.nextInt();
        System.out.print("Enter year: ");
        int year = sc.nextInt();
        
        // Method 1: Using switch-case
        int days;
        switch(month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                days = 31;
                break;
            case 4: case 6: case 9: case 11:
                days = 30;
                break;
            case 2:
                // Check leap year
                if((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                    days = 29;
                } else {
                    days = 28;
                }
                break;
            default:
                System.out.println("Invalid month");
                return;
        }
        
        System.out.println("Days in month " + month + " of year " + year + ": " + days);
        
        // Method 2: Using array
        int[] daysInMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if(month == 2 && ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))) {
            daysInMonths[1] = 29;
        }
        System.out.println("Days (Array method): " + daysInMonths[month - 1]);
    }
    
    // 24. Count Digit Occurrence
    static void countDigitOccurrence(Scanner sc) {
        System.out.print("Enter the number: ");
        String num = sc.next();
        System.out.print("Enter digit to count (0-9): ");
        int digit = sc.nextInt();
        
        // Method 1: Using loop
        int count1 = 0;
        for(int i = 0; i < num.length(); i++) {
            if(num.charAt(i) - '0' == digit) {
                count1++;
            }
        }
        System.out.println("Count (Loop): " + count1);
        
        // Method 2: Using String methods
        int count2 = 0;
        String digitStr = String.valueOf(digit);
        for(int i = 0; i < num.length(); i++) {
            if(num.substring(i, i + 1).equals(digitStr)) {
                count2++;
            }
        }
        System.out.println("Count (String): " + count2);
        
        // Method 3: Using replace
        int originalLength = num.length();
        int newLength = num.replace(digitStr, "").length();
        int count3 = originalLength - newLength;
        System.out.println("Count (Replace): " + count3);
    }
    
    // 25. Numbers with Exactly X Divisors
    static void numbersWithXDivisors(Scanner sc) {
        System.out.print("Enter range start: ");
        int start = sc.nextInt();
        System.out.print("Enter range end: ");
        int end = sc.nextInt();
        System.out.print("Enter number of divisors (X): ");
        int x = sc.nextInt();
        
        System.out.println("Numbers with exactly " + x + " divisors:");
        int count = 0;
        
        for(int i = start; i <= end; i++) {
            int divisorCount = countDivisors(i);
            if(divisorCount == x) {
                System.out.print(i + " ");
                count++;
                if(count % 10 == 0) System.out.println();
            }
        }
        System.out.println("\nTotal count: " + count);
    }
    
    static int countDivisors(int n) {
        int count = 0;
        // Optimized: check only up to sqrt(n)
        for(int i = 1; i * i <= n; i++) {
            if(n % i == 0) {
                if(i * i == n) {
                    count++;  // Square root counted once
                } else {
                    count += 2;  // Both i and n/i
                }
            }
        }
        return count;
    }
}