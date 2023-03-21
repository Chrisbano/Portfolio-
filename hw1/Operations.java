package cs280a1.hw1;

import java.util.ArrayList;
import java.util.List;

public class Operations{
    static String binary;
    static String hex;
    static String dec;

    static char[] hexNumSystem = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};


    public static int convertToInt(String str) {
        int convInt = 0; 
        int place = 1;
        for(int i = str.length()-1; i >= 0; i--) {
            convInt = convInt + (str.charAt(i) - '0') * place;
            place = place * 10;
        }
        return convInt;
    }

    //Start of Task 1
    public static void taskOne(String[] args) {
        if((args.length == 3)) {
            System.out.println("Correct number of arguments given.");
        }
        else{
            System.out.println("Incorrect number of arguments have been provided. Program Terminating!");
            System.exit(0);
        }  
    }

    //End of Task 1
    
    //Start of Task 2
    public static void taskTwo(String[] args) {

        for(String arg : args) {
            if(arg.contains("0b")){
                System.out.println(arg + "=Binary");
                binary = arg.substring(2);
            }
            else if(arg.contains("0x")){
                System.out.println(arg + "=Hexadecimal");
                hex = arg.substring(2);
            }
            else{
                System.out.println(arg + "=Decimal");
                dec = arg;
            }
        }

    }
    //End of Task 2

    //Start of Task 3
    public static void taskThree(String[] args) {
        boolean flag = false;
        //Binary
        if(binary.substring(2,binary.length()-1).matches("^[0-1]*$")){
            System.out.println(binary + "=true");
    
        }
        else{
            System.out.println(binary + "=false"); 
            flag = true;
    
        }
        //HEex
        if(hex.matches("^[0123456789ABCDEFabcdef]*$")){
            System.out.println(hex + "=true");
        }
        else{
            System.out.println(hex + "=false"); 
            flag = true;
            
        } 
        //Decimal

        if(dec.matches("^[0-9]*$")){
            System.out.println(dec + "=true");
        }
        else{
            System.out.println(dec + "=false");
            flag = true;
        } 
        if(flag == true){
            System.exit(0);
        }
    }

    //End of task 3

    //Start of task 4

    //------------------------------HELPER FUNCTIONS----------------------------------
    public static int binaryToDecimal(String binary) {
        int binBaseValue = 2;
        int binExpValue = 0;
        int binPowValue = 1;
        int binToDecNum = 0;
        int i = binary.length()-1;

        //could have used math.pow
        while(i >= 0){
            if(binary.charAt(i) == '1'){
                for(int k = 0; k < binExpValue; k++){
                    binPowValue = binPowValue * binBaseValue;
                }
                binToDecNum += binPowValue;
                binPowValue = 1;
            }
            binExpValue++;
            i--;
        }
        return binToDecNum;
        
    }
    public static int hexToDecimal(String hex) {
        int length = hex.length() - 1;
        int base = 1;
        int decimalValue = 0;
        int temp;
        hex = hex.toUpperCase();

        for(int i = length; i >= 0; i--){
            if(hex.charAt(i) >= '0' && hex.charAt(i) <= '9'){
                temp = hex.charAt(i) - 48;
                decimalValue += temp * base;
                base = base * 16;
            
            }
            else if(hex.charAt(i) >= 'A' && hex.charAt(i) <= 'F'){
                temp = hex.charAt(i) - 55;
                decimalValue += temp * base;
                base = base * 16;

            }
        }
        return decimalValue;
       


        
    }

    public static String decimalToBinary(int decimal) {
        
        String binary = "";
        String flipped = "";
        int temp;

        while(decimal != 0){
            binary += decimal%2;
            decimal = decimal / 2;
            
        }
        for(int i = binary.length() - 1; i >= 0; --i){
            flipped += binary.charAt(i);
        }
        return flipped;
       
    }

    public static String decToHexString(int decimal) {
        int remainder;
        String hex = "";

        while(decimal != 0){
            remainder = decimal % 16;
            hex = hexNumSystem[remainder] + hex;
            decimal = decimal / 16;
        }
        return hex;
        
    }

    //---------------------------OUTPUT--------------------------

    

       
    public static void taskFour(String[] args){
        System.out.println("Start="+dec+",Binary=0b" + decimalToBinary(convertToInt(dec)) + ",Decimal=" + dec + ",Hexadecimal=0x" + decToHexString(convertToInt(dec)));
        System.out.println("Start=0b"+binary+ ",Binary=0b"+binary + ",Decimal="+binaryToDecimal(binary)+",Hexadecimal=0x"+decToHexString(binaryToDecimal(binary)));
        System.out.println("Start=0x"+hex+","+"Binary=0b"+decimalToBinary(hexToDecimal(hex))+",Decimal="+hexToDecimal(hex) + ",Hexadecimal=0x"+hex);
    }


    // End of task 4 

    //Start of task 5

    public static String oneComp(String binary){
        String oc = "";
        for(int i = 0; i < binary.length(); i++){
            if(binary.charAt(i) == '1'){
                oc += '0';
            }else{
                oc += '1';
            }
        }
        return oc;
    }

    public static void taskFive(String[] args){
        //converts to binary
        String convertedHex = decimalToBinary(hexToDecimal(hex));
        String convertedDec = decimalToBinary(convertToInt(dec));

        System.out.println(dec + "=" + convertedDec + "=" + oneComp(convertedDec));
        System.out.println("0b" + binary + "=" + binary + "=" + oneComp(binary));
        System.out.println("0x" + hex + "=" + convertedHex + "=" + oneComp(convertedHex));

        


    }


    //End of task 5

    //Start of Task 6
    public static String twosComp(String binary){
        char carry = '1';
        String tc = "";
        String one = "";
        String flipped = "";
        for(int i = 0; i < binary.length() - 1; i++){
            one += '0';
        }
        one += '1';
        
        boolean flag = false;
        
        if((binary.charAt(binary.length()-1) == '1' && one.charAt(binary.length()-1) == '1')){

                flag = true;
            }
       
        for(int i = binary.length() - 1; i >= 0; i--){
            

            if(flag){
    
                if((binary.charAt(i) == '0' && one.charAt(i) == '0')){
                    tc += '1';
                    flag = false;
                }
                else if((binary.charAt(i) == '1' && one.charAt(i) == '1') || (binary.charAt(i) == '1' && one.charAt(i) == '1')){
                    tc += '0';
                    flag = true;
                }
                

            }
            else if(!flag){
                if(binary.charAt(i) == '0' && one.charAt(i) == '0'){
                    tc += '0';
                }
                
               
                else if((binary.charAt(i) == '0' && one.charAt(i) == '1') || (binary.charAt(i) == '1' && one.charAt(i) == '0')){
                        tc += '1';
                }
            }
        }    
        
        for(int i = tc.length() - 1;i >= 0; i--){
            flipped += tc.charAt(i);
        }
        
        
      

        return flipped;
        
    }

    public static void taskSix(String[] args){ 
        String binOC = oneComp(binary);
        String decOC = oneComp(decimalToBinary(convertToInt(dec)));
        String hexOC = oneComp(decimalToBinary(hexToDecimal(hex)));

        
        System.out.println(dec + "=" + decimalToBinary(convertToInt(dec)) + "=" + twosComp(decOC));
        System.out.println("0b" + binary + "=" + binary + "=" + twosComp(binOC));
        System.out.println("0x" +  hex + "=" + decimalToBinary(hexToDecimal(hex)) + "=" + twosComp(hexOC));

    }
    
    //end of task Six

    //Start of task 7

    //
    public static String[] padBin(String a, String b, String c) {
        String longest = a;
        String shortOne = b;
        String shortTwo = c;
       
        if (b.length() > longest.length()) {
            longest = b;
            shortOne = a;
        }
        if (c.length() > longest.length()) {
            longest = c;
            shortTwo = b;
        }
        while(shortOne.length() < longest.length()){
            shortOne = "0" + shortOne;
        }
        while(shortTwo.length() < longest.length()){
            shortTwo = "0" + shortTwo;
        }
        String[] strArray = {shortOne, shortTwo, longest};
        return strArray;
        
       

        
    }

    public static String bitOr(String a, String b, String c ) {
        String[] strArray = padBin(a, b, c);
        String or = "";
        for(int i = strArray[0].length() -1; i >= 0; i--) {
            if(strArray[0].charAt(i) == '1' || strArray[1].charAt(i) == '1' || strArray[2].charAt(i) == '1'){
                or = '1' + or;
            }
            else or = '0' + or;
        }

        return or;
        
    }
    public static String bitAnd(String a, String b, String c ) {
        String[] strArray = padBin(a, b, c);
        String or = "";
        for(int i = strArray[0].length() -1; i >= 0; i--) {
            if(strArray[0].charAt(i) == '1' && strArray[1].charAt(i) == '1' && strArray[2].charAt(i) == '1'){
                or = '1' + or;
            }
            else or = '0' + or;
        }

        return or;
        
    }

    public static String bitXor(String a, String b, String c) {
        String[] strArray = padBin(a, b, c);
        String or = "";
        for(int i = 0; i < strArray[0].length(); i++) {
            if(strArray[0].charAt(i) == '1' && strArray[1].charAt(i) == '0' && strArray[2].charAt(i) == '0'){
                or += '1';
            }
            else if(strArray[0].charAt(i) == '0' && strArray[1].charAt(i) == '1' && strArray[2].charAt(i) == '0'){
                or += '1';
            }
            else if(strArray[0].charAt(i) == '0' && strArray[1].charAt(i) == '0' && strArray[2].charAt(i) == '1'){
                or += '1';
            }
            else{
                or += '0' ;
            }
            
        }

        return or;
        
    }




    public static void taskSeven(String[] args){
        String bin = binary;
        String decBin = decimalToBinary(convertToInt(dec));
        String decHex = decimalToBinary(hexToDecimal(hex));
        String or = bitOr(bin, decBin, decHex);
        String and = bitAnd(bin, decBin, decHex);
        String xor = bitXor(bin, decBin, decHex);

        System.out.println(decBin + "||" + bin + "||" + decHex + "=>" + or);
        System.out.println(decBin + "&&" + bin + "&&" + decHex + "=>" + and);
        System.out.println(decBin + "^" + bin + "^" + decHex + "=>" + xor);
        
        

    }

    //TASK EIGHT
    public static String right(String binary){
        return binary.substring(0, binary.length()-2);
    }
    public static String left(String binary){
        return binary + "00";
    }

    public static void taskEight(String[] args) {
        String bin = binary;
        String decBin = decimalToBinary(convertToInt(dec));
        String decHex = decimalToBinary(hexToDecimal(hex));

        System.out.println(decBin + "<<2=" + left(decBin) + "," + decBin + ">>2=" + right(decBin));
        System.out.println(bin + "<<2=" + left(bin) + "," + decBin + ">>2=" + right(bin));
        System.out.println(decHex + "<<2=" + left(decHex) + "," + decHex + ">>2=" + right(decHex));

        
    }

    //

    public static void main(String[] args){

        System.out.println("Task 1");
        taskOne(args);

        System.out.println("\nTask 2");
        taskTwo(args);

        System.out.println("\nTask 3");
        taskThree(args);

        System.out.println("\nTask 4");
        taskFour(args);
        
        System.out.println("\nTask 5");
        taskFive(args);

        System.out.println("\nTask 6");
        taskSix(args);
        
        System.out.println("\nTask 7");
        taskSeven(args);

        System.out.println("\nTask 8");
        taskEight(args);

       


    }

}



    
