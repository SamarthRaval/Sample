import java.util.Scanner;

public class ReverseInteger {
    public static void main(String[] args)
    {
        System.out.println("Enter integer to reverse: ");
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();

        System.out.println("Reversed number is: "+ reverse(number));
    }

    private static int reverse(int number)
    {
        int output = 0;

        while(number != 0)
        {
            int remainder = number % 10;

            int latest = output * 10 + remainder;

            if((latest-remainder)/10 != output)
                return 0;

            output = latest;

            number = number / 10;
        }

        return output;
    }
}
/*
    1. First find the remainder using the modulo operator
        int remainder = number % 10
    
    2. multiply the previous output with 10 and add the new remainder to generate the new number
        result = result * 10 + remainder

    3. divide the number with 10 -> to get the new number
        number = number / 10
 */

