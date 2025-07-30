import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class A_LogicalAndAnalyticalProgramming {

    void palindromeCheck(){
        String input1 = "abccba";

        input1 = input1.toLowerCase().replaceAll("[^0-9a-z]","");

        //classic way
        boolean isPalindrome = true;
        int si = 0;
        int ei = input1.length()-1;
        
        while(si < ei){
            if(input1.charAt(si)!=input1.charAt(ei)){
                isPalindrome = false;
                break;
            }
            si++;
            ei--;
        }
        System.out.println("Is Palindrome "+isPalindrome);

        //rev string way
        String revStrInput = new StringBuilder(input1).reverse().toString();

        if(input1.equalsIgnoreCase(revStrInput)){
            System.out.println("It is a palindrome");
        }
        else{
            System.out.println("It is NOT a palindrome");
        }
        
        //streams api
        String finalInput = input1;
        boolean isPalindromeStreams = IntStream.range(0, input1.length()/2)
                .allMatch(i -> finalInput.charAt(i)== finalInput.charAt(finalInput.length()-i-1));
        System.out.println("It is a Palindrome chked using Streams API");
    }

    void armstrongNumber(){
        int input1 = 153;

        //classic way
        int cubeSum = 0;
        int tempInput = input1;
        int tempDigit = 0;

        while(tempInput>0){
            tempDigit = tempInput%10;
            cubeSum += tempDigit * tempDigit * tempDigit;
            tempInput /= 10;
        }

        if(cubeSum==input1){
            System.out.println("It is an armstrong");
        }
        else{
            System.out.println("It is NOT an armstrong");
        }

        //streams api
        String input1Str = String.valueOf(input1);

        int cubeSumStreams = input1Str.chars()
                .map(c->c-'0')
                .map(i->i*i*i)
                .sum();

        int cubeSumStreamsReduced = input1Str.chars()
                .map(c->c-'0')
                .reduce(0,(a,b)->a + (b*b*b));

        if(cubeSumStreams==input1){
            System.out.println("It is an armstrong chkd streams api");
        }
        else{
            System.out.println("It is NOT an armstrong chkd streams api");
        }
    }

    boolean primeCheck(int input1){
//        int input1 = 5;
        boolean isPrime = true;

        if(input1<=1) isPrime = false;
        else if(input1==2) isPrime = true;
        else if(input1%2==0) isPrime = false;
        else {

            int inputSqRt = (int)Math.sqrt(input1);

            //classic way
//        for(int i=3; i<=inputSqRt;i+=2){
//            if(input1%i==0) isPrime = false;
//        }

            //stream api way
            isPrime = IntStream.rangeClosed(3, inputSqRt)
                    .filter(i -> i%2!=0)
                    .noneMatch(i->input1%i==0);

//        if(isPrime) System.out.println("It is a prime");
//        else System.out.println("It is not a prime");


        }
         return isPrime;
    }

    void generatePrimes(){
        int input1 = 20;
        int inputSqRt = (int)Math.sqrt(input1);

        IntStream.range(2, input1)
                .filter(this::primeCheck)
                .forEach(System.out::println);
    }

    void fibonacciIterative(){
        int input1 = 20;

        int a = 0;
        int b = 1;
        int next;

        System.out.print(a);
        System.out.print(" ");
        System.out.print(b);
        System.out.print(" ");

        while(b<=input1){
            next = a + b;
            System.out.print(next);
            System.out.print(" ");
            a = b;
            b = next;
        }
    }

    void fibonacciRecursive(){
        int input1 = 20;
        for(int i=0;i<=input1;++i){
            System.out.print(fibonacci(i));
            System.out.print(" ");
        }
    }

    private int fibonacci(int num){
        if(num<=1) return num;
        else return fibonacci(num-1) + fibonacci(num-2);
    }

    void fibonacciStreamIterate(){
        int input1 = 10;

        Stream.iterate(new long[]{0,1}, arr -> new long[]{arr[1], arr[0]+arr[1]})
                .limit(input1)
                .map(arr -> arr[0])
                .forEach(System.out::println);
    }

    private int factorial(int num){
        if(num==1 || num==0) return 1;
        else return factorial(num-1)*num;
    }

    void factorialIterativeNRecursive(){
        int input1 = 5;

        int iterativeResult = 1;
        for(int i=input1; i>=1; --i){
            iterativeResult *= i;
        }
        System.out.println("Iterative Factorial of "+input1+" is "+iterativeResult);

        System.out.println("Recursive Factorial of "+input1+" is "+factorial(input1));

    }

    void factorialStreams(){
        int input1 = 5;

        int result = IntStream.rangeClosed(1, input1)
//                .peek(System.out::println)
                .reduce(1, (a,b)->a*b);
        System.out.println("Factorial of "+input1+" is "+result);
    }

    void digitsSumProduct(){
        int input1 = 12345;

        //classic
        int tempInput = input1;
        int sum = 0;
        int product = 1;
        int tempDigit;
        while(tempInput>=1){
            tempDigit = tempInput%10;
            sum += tempDigit;
            product *= tempDigit;
            tempInput /= 10;
        }

        System.out.printf("Input %d Sum %d Product %d", input1, sum, product);
    }

    void digitsSumProductStreams(){
        int input1 = 12345;

        String inputStr = String.valueOf(input1);

        //sum
        int sum = inputStr.chars()
                .map(c -> c - '0')
                .sum();

        int product = inputStr.chars()
                .map(c -> c - '0')
                .reduce(1, (i, s)-> i*s);

        System.out.printf("Input %d Sum %d Product %d", input1, sum, product);
    }

    void reverseDigits(){
        int input1 = 12345;

        int result = 0;

        int tempInput = input1;
        int tempDigit = 0;
        while(tempInput>0){
            tempDigit = tempInput%10;
            if(result > 0) result *= 10;
            result += tempDigit;
            tempInput/=10;
        }

        System.out.printf("Input %d Reversed %d", input1, result);
    }

    void reverseString(){
        String input1 = "12345";

        StringBuilder sb = new StringBuilder();

        for(int i=input1.length()-1;i>=0;--i){
            sb.append(input1.charAt(i));
        }

        String result = sb.toString();

        System.out.printf("Input %s Reversed %s", input1, result);
    }

    void reverseDigitsStreams(){
        int input1 = 12345;

        int digitCnt = 0;
        int tempInput = input1;

        while(tempInput>0){
            digitCnt++;
            tempInput/=10;
        }

        tempInput = input1;
        String input1Str = String.valueOf(input1);

        int result = IntStream.range(0, input1Str.length())

                .map(i -> input1Str.charAt(input1Str.length()-1-i))
                .map(i -> i - '0')
                .peek(System.out::println)
                .reduce(0, (a,b)->{
                    return a*10+b;
                });

        System.out.printf("Input %d Reversed %d", input1, result);
    }

    void frequencyWithStreams(){
        String input = "asdasdfasdf";
        String frequentLetter = "f";

        long result = input.chars()
                .mapToObj(i->(char)i)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .get(frequentLetter.charAt(0));

        System.out.printf("Input %s Letter %c Frequency %d", input, frequentLetter.charAt(0),result);

        int input2 = 1234532129;
        int frequentDigit = 2;


    }
}
