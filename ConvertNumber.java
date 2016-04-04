import java.util.Scanner;
import java.util.Stack;

class ConvertNumber{
  public static void main(String[] args){
    String inputValue;

    if(args.length == 1){
      inputValue = args[0];
    }
    else {
      System.out.print("Input: Integer values from -999,999 to 999,999\n>");
      Scanner input = new Scanner(System.in);
      inputValue = input.nextLine();
    }

    // Predicting I will be performing basic calculations on some characters, I decided to
    // convert the given String into a Stack of Integers
    Stack<Integer> myStack = null;

    // Check for empty input
    if ( inputValue.length() > 0)
      myStack = Util.stringToIntegerStack(inputValue);

    // Check for valid Stack
    if(myStack != null){
      String result = Util.numberLiteralConverter(myStack);
      System.out.println(result);
    }
    else {
      System.out.println("The value entered was NOT valid");
    }
  }
}
