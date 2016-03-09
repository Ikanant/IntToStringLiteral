class util{
  public static int getIntSize(int i){
      if(i<0){
        i = i*(-1);
      }

      int size = 1;
      while(true){
        i /= 10;
        if(i<1){
          break;
        } else {
          size++;
        }
      }

      return size;
    }
}
