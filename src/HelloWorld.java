public class HelloWorld {
    public static void main(String[] args)
    {
        System.out.println("Samarth Raval");
        int a = 5 + 10;
        System.out.println("Sum would be = " + a);
        int mul = 5 * 10;
        System.out.println("Multiplication = " + mul);

        HelloWorld helloWorld = new HelloWorld();
        helloWorld.printStatement();
        System.out.println("return value = "+ helloWorld.subtraction());
    }

    public void printStatement()
    {
        System.out.println("Just for checking how method is working");
    }

    public int subtraction()
    {
        System.out.println("Subtraction = "+ (10-2));
        return 9;
    }
}
