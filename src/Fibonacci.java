import java.util.Scanner;

public class Fibonacci {

    static long[] fibArray;
    public static void main(String[] args)
    {
        Fibonacci fibonacci = new Fibonacci();

        System.out.println("Enter the input:");
        Scanner scanner = new Scanner(System.in);

        int input = scanner.nextInt();

        fibArray = new long[input+1];
        fibArray[0] = 0;
        fibArray[1] = 1;
        long preTime = System.currentTimeMillis();
        System.out.println("Answer="+ fibonacci.fibonacci(input));
        long postTime = System.currentTimeMillis();
        System.out.println("Total computation time="+ (postTime-preTime));
    }

    public long fibonacci(int input)
    {
        if(input == 0)
            return 0;
        else if(input == 1)
            return 1;
        else if(fibArray[input] != 0)
            return fibArray[input];
        else
        {
            long fibValue = fibonacci(input-1) + fibonacci(input-2);
            fibArray[input] = fibValue;
            return fibValue;
        }

    }
}
