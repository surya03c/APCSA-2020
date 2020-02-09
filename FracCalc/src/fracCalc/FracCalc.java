package fracCalc;
import java.util.*;
public class FracCalc {

    public static void main(String[] args) 
    {
      Scanner console = new Scanner(System.in);
      System.out.println("Type \"Use\" to get started. If you would like to quit, type \"quit\"");
      String response = console.nextLine();
      while (!response.equalsIgnoreCase("quit")) {
      System.out.println("Enter your line: ");
      String input = console.nextLine();
      System.out.println(produceAnswer(input));
    System.out.println("Would you like to use again? Follow similar instructions to quit or go again");
    String response2 = console.nextLine();
    if (response2.equalsIgnoreCase("quit")) {
    	break;
    }
    
      }
    }
    
    
   
    
    public static String produceAnswer(String input)
    { 
    int firstSpace = input.indexOf(" ");// finds index of first space to parse and find op1.
    String op1= input.substring(0,firstSpace);
    String operator = input.substring(firstSpace+1,firstSpace + 2);// finding the operator
    int Length = input.length();
    String op2 = input.substring(firstSpace+3, Length);// the rest of it has to be op2.
 
    	
    int slashfind1 = op1.indexOf("/");// determining whether op1 is a fraction
    int num1 = 0;
    int den1 = 0;
    int whole1 = 0;
    if (slashfind1>0) {//if it is a fraction...
    	 int underFind1 = op1.indexOf("_");
    	 String whole1s = "";
    	  if (underFind1>0) {// used for finding whether there is whole number inputted
    	    	whole1s=op1.substring(0,underFind1);
    	        whole1 = Integer.valueOf(whole1s);// finding the numerical value of the whole number
    	    	
    	    	String num1string = op1.substring(underFind1+1,slashfind1);
    	    	
    	        
    	        num1=Integer.valueOf(num1string);// finds the actual value of the numerator of op1
    	        
    	        int length1 = op1.length();
    	               String dem1 = op1.substring(slashfind1+1,length1);
    	        den1=Integer.valueOf(dem1);// finds the actual value of the denominator of op1
    	        
    	        }
    	  else {//there is a slash but no underscores, then only fraction is operand.
            whole1 = 0;
    		String num1string = op1.substring(underFind1+1,slashfind1);
    		int L1 =num1string.length();
	    	int signFinder1 = num1string.indexOf("-");// ONLY FOR NEGATIVES!!
	    	if (signFinder1>=0) {
	        	String numneg1=num1string.substring(1,L1);//seperates the negative , then converts to num
	        	int Num1 = Integer.valueOf(numneg1);
	        	Num1=0-Num1;// makes it negative
	        	num1=Num1;
	        	
	        }
	    	
  	        num1=Integer.valueOf(num1string);//same thing of finding numerator and denominator for mixed number inputs
  	        int length1 = op1.length();
  	        String dem1 = op1.substring(slashfind1+1,length1);
  	        den1=Integer.valueOf(dem1);// finds denominator
  	        
    	  }
    	    }    	
    	    
    
    else {// only whole number has been inputted, without any underscores
    	num1=0;
    	den1=1;
    	whole1=Integer.valueOf(op1);
    	
    	
    }
    if (den1==0) {
    	System.out.println("ERROR! You cannot divide by zero. Rerun the program and try again");
    	System.exit(1);
    }
    int slashfind2 = op2.indexOf("/");// repeat above steps for the second operand
    int num2 = 0;
    int den2 = 0;
    int whole2 = 0;
    if (slashfind2>0) {
    	 int underFind2 = op2.indexOf("_");
    	 String whole2s = "";
    	  if (underFind2>0) {// used for finding whether there is underscore
    	    	whole2s=op2.substring(0,underFind2);
    	        whole2 = Integer.valueOf(whole2s);
    	    	;
    	    	String num2string = op2.substring(underFind2+1,slashfind2);
    	        
    	        num2=Integer.valueOf(num2string);
    	        int length2 = op2.length();
    	        String dem2 = op2.substring(slashfind2+1,length2);
    	        den2=Integer.valueOf(dem2);
    	        
    	        }
    	  else {//there is a slash but no underscores, then only fraction is operand.
            whole2 = 0;
    		String num2string = op2.substring(underFind2+1,slashfind2);
    		int L2 =num2string.length();
	    	int signFinder2 = num2string.indexOf("-");
	    	if (signFinder2>=0) {
	        	String numneg2=num2string.substring(1,L2);
	        	int Num2 = Integer.valueOf(numneg2);
	        	Num2=0-Num2;
	        	num2=Num2;
	        	
	        }
  	        num2=Integer.valueOf(num2string);
  	        int length2 = op2.length();
  	        String dem2 = op2.substring(slashfind2+1,length2);
  	        den2=Integer.valueOf(dem2);
  	        
    	  }
    	    }    	
    	    
    
    else {// only whole number has been inputted, without any underscores
    	num2=0;
    	den2=1;
    	whole2=Integer.valueOf(op2);
    	
    	
    }
    if (den2==0) {
    	System.out.println("ERROR! You cannot divide by zero. Rerun the program and try again");
    	System.exit(1);
    }
    int wholeanswer=0;
    int numtotal=0;
    int dentotal=0;
    String FinalResponse3="";
    if (whole1>0) { // this is to get the new numerator for our improper fractions. 
    	num1=num1+den1*whole1;
    	
    }
    if (whole2>0) { // this is to get the new numerator for our improper fractions. 
    	num2=num2+den2*whole2;
    	
    }
    if (whole1<0) {// we have to treat this differently when we get negative numbers, but the goals are the same.
    	num1=whole1*den1-num1;
    	
    }
    if (whole2<0) {//Same thing as seen above
    	num2=whole2*den2-num2;
    	
    }
   
    if (operator.equals("+")) {//two branches of addition that we can follow
    	 if (den1==den2) {//if values are same denominator, then you can add directly
    		numtotal=num1+num2;
    		dentotal=den1;
    	 }
    	 else {   // if not, then we have to find a new denominator
    		 dentotal=den1*den2; 
    		 num1=num1*den2;
    	    num2=num2*den1;
    	numtotal=num1+num2;	
    }
    }
    if (operator.equals("-")) {
    	if (den1==den2) {// same thing here: if the denominators are the same, then we can simply subtract
    		numtotal=num1-num2;
    		
    		dentotal=den1;
    	 }
    else {dentotal=den1*den2;// if different, we need to redefine the denominator
	    num1=num1*den2;
    	    num2=num2*den1;
    	numtotal=num1-num2;
    }
    }
    if (operator.equals("*")) {// we can simply multiply out the numerator and denominator, and save the reducing pain for later
    	numtotal=num1*num2;
    	
    	dentotal=den1*den2;
    	
    }
    if (operator.equals("/")) {// division is just multiplying by the reciprocal, so we switch and multiply
    	numtotal=num1*den2;
    	dentotal=den1*num2;
    }
   
    int NT = Math.abs(numtotal);
    int DT = Math.abs(dentotal);
   if (numtotal>0 && dentotal>0) {// way to find out new wholeanswer by modding and dividing
	   wholeanswer=numtotal/dentotal;
	   numtotal=numtotal%dentotal;
	   
	  
   }
   if (numtotal<0 && dentotal<0) {// sometimes with the way the code is written we can find negatives in both numerator and denominator.
	   wholeanswer=NT/DT;// this is equivalent to just doing the same reducing, as 2 negatives cancel and make a positive
	   numtotal=NT%DT;
	   dentotal=DT;
   }
  if (numtotal<0 && dentotal>0) {// dealing with converting negative improper fractions to negative mixed numbers
	  wholeanswer=NT/dentotal;
	  wholeanswer=0-wholeanswer;
	  numtotal=Math.abs(numtotal-wholeanswer*dentotal);
	  if (wholeanswer==0) {// the above line made numtotal absolutely positive, so we need to re-negativize it.
	    	numtotal=0-numtotal;
	    	
	    }
  }
  if (numtotal>0 && dentotal<0) {// same thing as the previous if statements.
	  wholeanswer=NT/DT;
	  wholeanswer=0-wholeanswer;
	  numtotal=Math.abs(numtotal-wholeanswer*dentotal);
	  dentotal=Math.abs(dentotal);
	  if (wholeanswer==0) {
	    	numtotal=0-numtotal;
	    	
	    }
    
  }
    
    
  if (numtotal==0) {// universal rule guaranteed to make sure dentotal is never 0.
	  dentotal=1;
  }
  
  int factor = findGcd(dentotal,numtotal);//method written for reducing num and den
  numtotal = numtotal /factor;
  dentotal = dentotal /factor;
  
  
  FinalResponse3 = (wholeanswer+"_" +numtotal+"/"+dentotal);
  if (wholeanswer==0) {// specifications for string format as specified by Final checkpoint 
	   if (numtotal==0) {
		  FinalResponse3="0";
	   }
	   else if (dentotal ==1 || dentotal==-1) { // universal identity rule of dividing by 1 or -1
	   FinalResponse3=(numtotal/dentotal+"");
	   }
	   else {   
		   FinalResponse3 = (numtotal+"/"+dentotal);// for returning an answer with only fractions
   }
   }
   if (wholeanswer !=0 && numtotal==0) {// whole wholeanswer output
	   FinalResponse3=(wholeanswer+"");
   }
   
   
    return FinalResponse3;
    }


public static int findGcd(int number1, int number2) {// Euclid's formula keeps finding modulus until the number 2 =0, then kicks out
	if (number2 == 0) {
		return number1;
	}
	return findGcd(number2, number1 % number2);
}
}



