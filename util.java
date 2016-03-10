import java.util.Stack;

class util{

  /*
  This method will return an int array.
  The first element will be 1 or -1 that will help the program determine the sign of the int
  The second element will be the SIZE (or length) of the int. Example: 42 = 2
  The rest of the elements will be the int values broken down
  */
  public static Stack<Integer> breakDownInt(int input){
      // resultStack will contain Sign, Size and int values from input i
      Stack<Integer> resultStack = new Stack<Integer>();

      if(input<0){
        resultStack.push(-1);
        input = input*(-1);
      } else {
        resultStack.push(1);
      }

      if(input < 10){
        resultStack.push(input);
      }
      else {
        while(input>=1){
          resultStack.push(input%10);
          input /= 10;
        }
      }

      return resultStack;
    }

}
