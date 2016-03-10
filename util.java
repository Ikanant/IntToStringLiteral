import java.util.Stack;

class Util{

  /*
  This method will return an int array.
  The first element will be 1 or -1 that will help the program determine the sign of the int
  The second element will be the SIZE (or length) of the int. Example: 42 = 2
  The rest of the elements will be the int values broken down
  */

  public static int stringToInt(String inputString){

    boolean negativeFlag = false;
    int asciiVal = 0;
    int decimalPoint = toThePowerOf( inputString.length() );
    int resultInt = 0;

     int resultingInt = 0;
    for(int i=0; i<inputString.length(); i++){
      asciiVal = inputString.charAt(i);

      if (asciiVal == 45 && resultingInt == 0){
        negativeFlag = true;
      }
      else if(asciiVal >= 48 && asciiVal <= 57){
        resultInt += (asciiVal-48) * decimalPoint;
      }
      decimalPoint /= 10;
    }

    return negativeFlag ? resultInt * (-1) : resultInt;
  }

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



  public static String stringBuilder(Stack<Integer> resultStack){
    StringBuilder sbuild = new StringBuilder();

    int size = resultStack.size()-1; // Ignore sign integer
    if(size==1){
        sbuild.append(convertToLiteral(resultStack.pop()));
    }
    else{
        int possibleDec = 2; // Scalable
        while (possibleDec+3 <= size){
          possibleDec += 3;
        }

        int conductor = size;
        int element;

        while (resultStack.size() > 1){
          element = resultStack.pop();
          if(element!=0){
            if (conductor == possibleDec && element==1){
              sbuild.append(convertToLiteral(resultStack.pop() + 10) + " ");
              conductor --;
            }
            else if(conductor == possibleDec && element!=1){
              sbuild.append(convertToLiteral(element*10) + " ");
            }
            else {
              sbuild.append(convertToLiteral(element) + " ");
              if(conductor == 3 || conductor == 6){
                sbuild.append("hundred ");
              }
            }
          }

          if(conductor == 4){
            sbuild.append("thousand ");
          }
          else if(conductor == possibleDec){
            possibleDec -= 3;
          }

          conductor--;
        }
    }

    if(resultStack.pop() < 0){
      sbuild.insert(0, "negative ");
    }

    return sbuild.toString();
  }

  private static String convertToLiteral(int input){
    switch(input){
      case 0:
        return "zero";
      case 1:
        return "one";
      case 2:
        return "two";
      case 3:
        return "three";
      case 4:
        return "four";
      case 5:
        return "five";
      case 6:
        return "six";
      case 7:
        return "seven";
      case 8:
        return "eight";
      case 9:
        return "nine";
      case 10:
        return "ten";
      case 11:
        return "eleven";
      case 12:
        return "twelve";
      case 13:
        return "thirteen";
      case 14:
        return "fourteen";
      case 15:
        return "fifteen";
      case 16:
        return "sixteen";
      case 17:
        return "seventeen";
      case 18:
        return "eighteen";
      case 19:
        return "nineteen";
      case 20:
        return "twenty";
      case 30:
        return "thirty";
      case 40:
        return "forty";
      case 50:
        return "fifty";
      case 60:
        return "sixty";
      case 70:
        return "seventy";
      case 80:
        return "eighty";
      case 90:
        return "ninety";
      default:
        return null;
    }
  }

  private static int toThePowerOf(int exponent){
    int powerValue = 1;
    while(exponent>1){
      powerValue *= 10;
      exponent--;
    }
    return powerValue;
  }
}
