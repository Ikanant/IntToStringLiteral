import java.util.Queue;
import java.util.LinkedList;

class util{

  /*
  This method will return an int array.
  The first element will be 1 or -1 that will help the program determine the sign of the int
  The second element will be the SIZE (or length) of the int. Example: 42 = 2
  The rest of the elements will be the int values broken down
  */
  public static Queue<Integer> breakDownInt(int input){
      // resultPackage will contain Sign, Size and int values from input i
      Queue<Integer> resultPackage = new LinkedList<Integer>();

      if(input<0){
        resultPackage.add(-1);
        input = input*(-1);
      } else {
        resultPackage.add(1);
      }

      while(input>=1){
        resultPackage.add(input%10);
        input /= 10;
      }

      return resultPackage;
    }

}
