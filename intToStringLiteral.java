import java.util.Queue;

class intToStringLiteral{

  public static String stringBuilder(Queue<Integer> resultPackage){
    StringBuilder sbuild = new StringBuilder();

    if(resultPackage.poll() < 0){
      sbuild.append("negative ");
    }

    int iterator = 1;
    int tenthDecimal = 2;
    for(int i: resultPackage){
      if(iterator != tenthDecimal){
        System.out.println("--> " + convertToLiteral(i));
      }
      else{
        System.out.println("--> " + convertToLiteral(i*10));
        tenthDecimal += 3;
      }
      iterator++;
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
}
