import java.util.Scanner;

class ConvertNumber{
  public static void main(String[] args){

    int inputValue;
while(true){
    if(args.length == 1){
      inputValue = Util.stringToInt(args[0]);
    }
    else {
      System.out.print("Input: Integer values from -999,999 to 999,999\n>");
      Scanner input = new Scanner(System.in);
      inputValue = input.nextInt();
    }

    String result = Util.stringBuilder(Util.breakDownInt(inputValue));

    System.out.println(result);
  }
}
}
