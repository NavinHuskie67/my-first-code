public class Main{


public static void main (String[] args){
    System.out.println("Hello World");
    int[] intArray = new int[5];
    int length = 0;
    for(int i = 0; i < intArray.length; i++){
        intArray[i] = i * i;
        System.out.println("The value at index " + length + " is " + intArray[length]);  
        length++;
        System.out.println("The value at index " + i + " is " + intArray[i]);
      }
}


}

