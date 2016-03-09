import java.util.Scanner;

class main{
  public static void main(String[] args){
    System.out.println("Input: Integer values from -999,999 to 999,999");
    System.out.print("> ");

    int val;
    Scanner input = new Scanner(System.in);
    val = input.nextInt();


    System.out.println("Size of int: " + util.getIntSize(val) );
  }
}
