import java.util.Stack;

class Util{
  public static Stack<Integer> stringToIntegerStack(String inputString){
    Stack<Integer> resultStack = new Stack<Integer>();

    int asciiVal = 0;
    int stringLength = inputString.length();

    // Check all characters are valid numbers && push them to our Stack
    for(int i=stringLength-1; i>=0; i--){
      asciiVal = inputString.charAt(i);

      if( asciiVal >= 48 && asciiVal <= 57 ){
        resultStack.push(asciiVal-48);
      }
      else if(asciiVal == 45 && i == 0){
        resultStack.push(-1);
      }
      else {
        return null; // Invalid character entered
      }
    }
    return resultStack;
  }

  //----------------------------------------------------------------------------

  public static String numberLiteralConverter(Stack<Integer> resultStack){
    StringBuilder sbuild = new StringBuilder();

    // Check if the given number is negative
    if(resultStack.peek() == -1){
      sbuild.append("negative ");
      resultStack.pop();
    }

    // If size == 1 we will handle "zeroes"
    int size = resultStack.size();
    if(size==1){
        sbuild.append(getNumberToLiteral(resultStack.pop()));
    }
    else{
        // possibleDec (Possible Decimal) will flag how to handle numbers between 10 - 19
        // We add 3 in case the number has more than 5 digits since we will deal with two decimals
        int possibleDec = 2;
        if (possibleDec+3 <= size){
          possibleDec += 3;
        }

        // I will use the conductor flag to point which single digit inside our number we are dealing with
        int conductor = size;
        int element;
        boolean possibleDecFlag = false;
        while (resultStack.size() > 0){
          element = resultStack.pop();
          if(element!=0){
            // Deal with numbers: 10 - 19
            if (conductor == possibleDec && element==1){
              sbuild.append(getNumberToLiteral(resultStack.pop() + 10));
              conductor--;
              possibleDecFlag = true;
            }
            // Deal with numbers: 20, 30, ..., 90
            else if(conductor == possibleDec && element!=1){
              sbuild.append(getNumberToLiteral(element*10));
            }
            // Deal with single digiits
            else {
              sbuild.append(getNumberToLiteral(element));

              if(conductor == 3 || conductor == 6){
                sbuild.append(" hundred");
              }
            }

            // Add space after appending (except for last digit)
            if (conductor!=1)
              sbuild.append(" ");
          }

          if(conductor == 4){
            sbuild.append("thousand ");
          }
          else if(conductor == possibleDec || possibleDecFlag){
            possibleDec -= 3;
          }

          conductor--;
        }
    }

    // return built String
    return sbuild.toString();
  }

  //----------------------------------------------------------------------------

  // Simple translator from Int to String
  private static String getNumberToLiteral(int input){
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
}
