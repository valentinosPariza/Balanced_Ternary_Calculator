package BalancedTernaryCalculator;
import java.util.Scanner;

/**
 *   This class is a class-type for creating and managing objects for Balanced Ternary numbers.Also it has a some 
 *   helpful methods for editing a String and generating it in a BalancedTernary object.Moreover it appears to have 
 *   the power to perform some basic functions on balanced numbers (and also on decimal) such as add,subtract,multiply,
 *   and other and also convert from decimal to Balance Ternary numbers and the opposite function.It has a method for
 *   the communication with people(interface for receiving and giving data-exchanging).
 *    
 * 
 * @author Valentinos Pariza
 * @category Balanced_Ternary_Numbers
 * @version 1.0
 * @since 4/8/2018
 * 
 *  There are two fields-variables for objects of this class 
 *  {@link BalancedTernary#btnum} which is a private variable of this class representing a Balanced Ternary number
 *  {@link BalancedTernary#memory} which illustrates the variabale which is used for saving Balanced Ternary numbers
 *  
 *  Last there is one public static final variable TERNARYBASE which represents the base of all Balanced 
 *  Ternary numbers which is 3
 *  {@link BalancedTernary#TERNARYBASE}
 *  
 */
public class BalancedTernary {
	
	 

	 /**
	  *  public static variable for representing the bas 
	     of every Balanced ternary Number(static)
	  */
	public  static final int TERNARYBASE=3; 
	
	/**
	 * the ternary balanced number as a field in BalancedTernary
	 */
	private String btnum;		
	
	/**
	 * the field of this class which is used the case of having a calculator
	 * and saving as memory the last used number or the desirable by user 	
	 * when is needed there is a specific structure of a constructor in order to
	 * to create a memory and not a simple number.Memory is used to store/save
	 * directly(without converting) only balanced Ternary numbers NOT decimal
	 */
	private BalancedTernary memory;    
	
	
	/**
	 * creating a Balanced Ternary number with value 0.Memory field in this constructor is not used!
	 * 
	 * @return void
	 * @since 4/8/2018
	 */
	public BalancedTernary() 
	{	this.btnum="0";    }

	
	/**
	 * creating a Balanced Ternary number with value 0.Memory field in this constructor is not used!
	 * 
	 * @param val   A String representation of what the Balanced Ternary number would have as a value.It uses the 
	 * 				value which is given to tell if a number is "NaN"(Not a number,like 1/0),to represent any Balanced
	 * 				Ternary number and also for giving the opporunity to create an object BalancedTernary for the 
	 * 				memory ,if the val is equal to  "mem".
	 * 
	 * @return nothing -type void
	 * @since 4/8/2018
	 */
	public BalancedTernary(String val) 
	{
		
		if(val.equals("nan")) this.btnum="NaN";    // creating a not number variable "NaN"
		
		else if(val.equals("mem")) 				   
		{
			this.memory=new BalancedTernary();	   //  creates an object for memory (use) if the value of val is "mem"
			this.btnum="0";
		}
		else
	    {
			
		  for(int i=0;i<val.length();i++)
			{		
			char c=val.charAt(i);				//  assign value of val to the tbnum field of the object if the number
												//  includes only digits of 'N' ,'1' and '0' else makes the value of 
			if((c!='0')&&(c!='1')&&(c!='N'))	//  the field tbnum zero ,literal "0"
			   { val="0"; break; }				//  if is not a Balanced Ternary number get out of the loop to save 
			}									//  time
		  		this.btnum=val;
		}
  }
	
	
	
	/**
	 * Compares two BalancedTernary numbers if their values (as objects-theoritical their values) are equal
	 * 
	 * @param bt a BalancedTernary object which is compared (if they are equal)with the object which calls the method
	 * 
	 * @return boolean (true if the objects are equal,otherwise false)
	 * 
	 * @since 4/8/2018
	 */
	public boolean equals(BalancedTernary bt) 
	{  return this.btnum.equals(bt.btnum); }
	
	
	/**
	 * Take the String representation of the btnum(BalancedTernary number) in the object and returns it
	 * 
	 * 
	 * @return String (String representation of the Balanced Ternary number in the object)
	 * 
	 * @since 4/8/2018
	 */
	public String toString() 
	{  return this.btnum; }
	
	
	/**
	 * Take the String representation of the btnum of the memory(BalancedTernary number in memory (field)) in the 
	 * object and returns it
	 * 
	 * 
	 * @return String (String representation of the Balanced Ternary number in the memory field of the object)
	 * 
	 * @since 4/8/2018
	 */
	public String memory_as_bt() {
		return this.memory.toString();
	}
	
	
	/**
	 * Stores the value bt(BalancedTernary type of variable) in the field memory.That means assign a Balanced
	 * Ternary number bt to the field memory 
	 * 
	 * @param bt (BalancedTernary Type) a Balanced ternary number  
	 * 
	 * @return  void
	 * 
	 * @since 4/8/2018
	 */
	public void store(BalancedTernary bt) {
		this.memory=bt;
	}
	
	
	/**
	 * Takes a BalancedTernary number(btnum) and finds the complement of it 
	 * 
	 * 
	 * @return void
	 * 
	 * @since 4/8/2018
	 */
	public void negate() {
		String s="";
		
		for(int i=0;i<this.btnum.length();i++) {
				
			if(this.btnum.charAt(i)=='1') s+="N";			//  takes each character and "replace" it with the 
															//	complement of it
			else if(this.btnum.charAt(i)=='N')s+="1";
			
			else s+=0;
		}
		
		this.btnum=s;
	}
	
	
	/**
	 * calculates the value of a BalancedTernary number and returns it
	 *  
	 * @return integer value of a BalancedTernary number(btnum)
	 * 
	 * Use the method-function {@link Math#pow(double, double)} for computing the powers of the number 3
	 *  ({@link BalancedTernary#TERNARYBASE}
	 *  
	 * @since 4/8/2018
	 */
	public int bt_to_int() {
		
		int num=0;
		String expr=this.btnum;
		
		for(int i=0;i<expr.length();i++) {
			
			if(expr.charAt(expr.length()-i-1)=='1') num+=Math.pow(TERNARYBASE,i);       // start calculating from the 
																						// last character of the number
			else if(expr.charAt(expr.length()-i-1)=='N')num-=Math.pow(TERNARYBASE, i);	// which is the Least 
																						// Significant digit
		}
		
		return num;
	}
	
	
	/**
	 * calls the method {@link BalancedTernary#bt_to_int()} to calculates the integer value of a Balancedternary 
	 * number which is stored in memory and returns it
	 * 
	 * @return integer value of a BalancedTernary number(btnum) which is stored in memory
	 * 
	 *  
	 * @since 4/8/2018
	 */
	public int memory_as_int() {
		return this.memory.bt_to_int();
	}
	
	
	/**
	 * calculates the value of a BalancedTernary number and returns it.This method is used to help other method 
	 * {@link BalancedTernary#int_to_bt(int)}to control the convert of an integer number to a BalancedTernary number.
	 * This method uses Recursion.This method is private because it is used inside other method.
	 * 
	 * @param num (an integer number to store in the result of integer division)  
	 * 
	 * Use the method-function {@link Math#pow(double, double)} for computing the powers of the number 3
	 *  ({@link BalancedTernary#TERNARYBASE}
	 *  
	 * @since 4/8/2018
	 */
	private String convert_d_to_bt(int num) {
		
		if(num==0)return"";									// if the result of the division is 0 return null "")
		
		int res=num%TERNARYBASE;						    // we calculate the remaining of the division 	
															//  the number with bas 3
		if(res==2) return this.convert_d_to_bt((num+1)/3)+"N";		//  if the remaining is 2 then because we are
																	//  working with numbers 1,-1=N and 
		if(res==1) return this.convert_d_to_bt(num/3)+"1";			//  0 we make 2--> 3(2+1=3) ,we write N(-1) 
																	//  because we added 1.Then we have a complete 3  			
		 return this.convert_d_to_bt(num/3)+"0";					//  so we have a number+1   we divide it /3 and we  
		 															//  continue .Also if the remaining is 1 --> we  	
	 																//  write 1 else if is 0-->we write 0
	
	}																

	
	/**
	 * Takes an integer number and send it to method({@link BalancedTernary#convert_d_to_bt(int)}) to convert the 
	 * integer number into a BalancedTernary number
	 * 
	 * @param num (is the integer number which the program converts to BalancedTernary)
	 * 
	 * @return a BalancedTernary number corresponding to the integer
	 * 
	 * @since 4/8/2018
	 */
	public BalancedTernary int_to_bt(int num) {
		
		if (num==0) return new BalancedTernary();
		
		if(num<0) {
			BalancedTernary bt=new BalancedTernary(convert_d_to_bt(-num)); 
			bt.negate();
			return bt;
		}
		
		else return new BalancedTernary(convert_d_to_bt(num));
	}
	
	
	/**
	 * This method calculates the sum of two BalancedTernary numbers converting them to integers,making the add 
	 * ,and last converting the number back to Balancedternary.Uses 
	 * {@link BalancedTernary#bt_to_int()} and {@link BalancedTernary#int_to_bt(int)}
	 * 
	 * @param bt (representing the number which we want to add to the BalancedTernary number which calls this method)
	 * @return a BalancedTernary number corresponding to the acual add of the two BalancedTernary numbers
	 * 
	 * @since 4/8/2018
	 */
	public BalancedTernary add(BalancedTernary bt) {
		
	return this.int_to_bt(this.bt_to_int()+bt.bt_to_int());
	

	}
	
	
	/**
	 * This method calculates the subtract of two BalancedTernary numbers converting them to integers,making the  
	 * subtract, and last converting the number back to Balancedternary.Uses 
	 * {@link BalancedTernary#bt_to_int()} and {@link BalancedTernary#int_to_bt(int)}
	 * 
	 * @param bt (representing the number which we want to subtract to the BalancedTernary number which calls this 
	 * method)
	 * @return a BalancedTernary number corresponding to the actual subtract of the two BalancedTernary numbers
	 * 
	 * @since 4/8/2018
	 */
	public BalancedTernary subtract(BalancedTernary bt) {
		
	return this.int_to_bt(this.bt_to_int()-bt.bt_to_int());
	
	}

	
	/**
	* This method calculates the multiplication of two BalancedTernary numbers converting them to integers,making the  
	 * multiply, and last converting the number back to Balancedternary.Uses 
	 * {@link BalancedTernary#bt_to_int()} and {@link BalancedTernary#int_to_bt(int)}
	 * 
	 * @param bt (representing the number which we want to multiply to the BalancedTernary number which calls this 
	 * method)
	 * @return a BalancedTernary number corresponding to the actual multiply of the two BalancedTernary numbers
	 * 
	 * @since 4/8/2018
	 */
	public BalancedTernary multiply(BalancedTernary bt) {
		
	return this.int_to_bt(this.bt_to_int()*bt.bt_to_int());
	
	}
	
	
	/**
	 * This method calculates the division of two BalancedTernary numbers converting them to integers,making the  
	 * division, and last converting the number back to Balancedternary.Moreover we check if the denominator is 0.
	 * if is 0 we create a "NaN"(Not a number object to describe this uncomputable action.Here we use the selection
	 * of creating a contructor of BalancedTernary object for a NaN {@link BalancedTernary#BalancedTernary(String)}.
	 * Uses  {@link BalancedTernary#bt_to_int()} and {@link BalancedTernary#int_to_bt(int)}
	 * 
	 * @param bt (representing the number which we want to divide to the BalancedTernary number which calls this 
	 * method)
	 * @return a BalancedTernary number corresponding to the actual divide of the two BalancedTernary numbers
	 * 
	 * @since 4/8/2018
	 */
	public BalancedTernary divide(BalancedTernary bt) {
		
		if(!bt.equals(new BalancedTernary()))
		return this.int_to_bt(this.bt_to_int()/bt.bt_to_int());
		
		return new BalancedTernary("nan");

	}
	
	
	/**
	 * This method calculates the remaining division of two BalancedTernary numbers converting them to integers,  
	 * making the remaining division, and last converting the number back to Balancedternary.Moreover we check if 
	 * the denominator is 0.if is 0 we create a "NaN"(Not a number object to describe this uncomputable action.Here
	 *  we use the selection of creating a contructor of BalancedTernary object for a NaN .
	 * 
     *  Uses  {@link BalancedTernary#bt_to_int()} and {@link BalancedTernary#int_to_bt(int)}
	 * 
	 * @param bt (representing the number which we want to remaining divide to the BalancedTernary number which calls 
	 * this method)
	 * @return a BalancedTernary number corresponding to the actual remaining division of the two BalancedTernary numbers
	 * 
	 * @since 4/8/2018
	 */
	public BalancedTernary remainder(BalancedTernary bt) {
		
		if(!bt.equals(new BalancedTernary()))
		return this.int_to_bt(this.bt_to_int()%bt.bt_to_int());
		
		return new BalancedTernary( "nan");

	}


	/**
	 * Estimates a BalancedTernary number by getting a String which contains only the number and considering the 
	 * operator of the number(plus('+') or minus('-')) ,it calculate the final BalancedTernary number
	 * Uses some methods of class String such as{@link String#substring(int, int)} for cutting a String into pieces
	 * Use method {@link BalancedTernary#negate()} for finding the negate of a number(opposite number)
	 * 
	 * @param val (String value of the number we want to estimate its value into a BalancedTernary number)
	 * 
     * @return a BalancedTernary number which is the final computational number from the String which we received
	 * @since 4/8/2018
	 */
	public BalancedTernary estimate(String val) {
		//  we assume that if we take a number the number may have minus,plus or nothing in front of it
		
		if(val.charAt(0)=='-') // if the number has a negative operator then the program cut the String,creates a 
		{   				   // BalancedTernary number and then calls the negate  method and then return the number
			BalancedTernary expr =new BalancedTernary( val.substring(1, val.length()) );   
			expr.negate();					
			return expr;
		}
		 
		else if(val.charAt(0)=='+') return new BalancedTernary(val.substring(1,val.length()));
		
		else return new BalancedTernary(val.substring(0,val.length()));
		
							// if the number has a positive operator then the program cut the String,creates a 
		   				    // BalancedTernary number and then returns the number.Else creates the number and return it
	}
	
	
	/**
	 *  Checks if a String contains only a BalancedTernary number and not anything else(Neither a decimal)
	 * 
	 * @param text (a String on which we make the check if is a BalancedTernary number as a String)
	 * 
	 * @return a boolean value(true or false) true if represents a BalancedTernary number,false otherwise
	 * @since 4/8/2018
	 */
	public boolean isBtNumber(String text) {
		
		for(int i=0;i<text.length();i++) 				//  if the number do not contain only characters which 
		{												//  describes it or operators like + or - return false
			char c=text.charAt(i);
			
			if(c!='N'&&c!='1'&&c!='0'&&c!='+'&&c!='-') return false;
		}
		
		return true;
		
	}
	
	
	
	/**
	 * This method takes a big part in distinguishing the special symbols "dec" (mathematical function for 
	 * converting a BalancedTernary number to decimal),"bt" (mathematical function for  converting a decimal number to 
	 * BalancedTernary number), "="(symbol which means to store the number at right in the memory).More specific it 
	 * makes these functions,check for any further mistakes on the expression which the method is given, cut the 
	 * String expression and concatenate as many times as it is required in order not to have special symbols in it
	 * (after completing every function of special symbol) and also formating the similar operators in the expression.
	 * It uses methods such as  {@link String#indexOf(int)},{@link String#substring(int, int)},
	 * {@link String#contains(CharSequence)},{@link String#length()},{@link String#charAt(int)}
	 * {@link Integer#parseInt(String)},{@link Expression#isOperator(char)},{@link BalancedTernary#estimate(String)}
	 * {@link Expression#operatorFormat(String)}
	 * 
	 * 
	 * @param txt (a String which represents the String expression which inside has numbers operators,special symbols
	 * only,not spaces,not any other characters)
	 * 
	 * @return a String which represents the updated expression and also if the expression is incorrect the value of it
	 * 		   is "error"
	 * 	
	 * @since 4/8/2018
	 */
	public String formalise(String txt) {
	
		String sample=txt;    //  assign expression in text to a variable in order to edit it later 
		
		while(sample.indexOf("mem")!=-1)				//  while the expression contains String "mem"
		{
			int n=sample.indexOf("mem");				//  find its location 
			
			sample=sample.substring(0,n)+this.memory_as_bt()+sample.substring(n+3,sample.length());
		}	
		
			//  cut the String and replace sequence of characters "mem" with the literal value(the BalancedTernary
			//  number which is stored in the memory) of the tbnum in memory (the number 3 is associated to the number
			//  of characters that th program have to cut in order to have the expression without the "mem"
		
		
		
		
		boolean find=false;					    //  variable representing if the program has found String "dec"
												//  in the expression or "bt"
		
		while(sample.contains("dec")) {			//  while the expression contains String "dec" the program 
			find=true;							//  execute these functions and remove / them one per loop
			
			int left=sample.indexOf("dec");     // the position of "d" in the expression
			
			for(int i=left+3;i<sample.length();i++)     //  starting from plus 3 because of the string "dec"
			{																
				
				// if the program finds an operator which is not right after of the string "dec" or if the program
				// arrives to the last character of the String(which means that it did not found any operator to 
				// cut the String and organize a number
				
				if((Expression.isOperator(sample.charAt(i))&&i!=left+3)||i==sample.length()-1) 
				{
					
					int lim=i;											// variable lim determines the position that 
					if(!Expression.isOperator(sample.charAt(i)))lim++;	//  the program has to cut from the String
																		//  the right limit (last character-digit) of
																		//  the number(if i==sample.length() )
					
					if(!isBtNumber(sample.substring(left+3,lim))) {  
						sample=sample.substring(0,left)+sample.substring(left+3,sample.length());
						break;
						}											 // plus 3 because "dec" contains three characters
																	 // so we want the first character after 'c' so 3.
					else 
						{
						
						String expr="";
						expr=sample.substring(0,left);
						
						BalancedTernary bt=this.estimate(sample.substring(left+3,lim));
						
						sample=expr+bt.bt_to_int()+sample.substring(lim,sample.length());
						
						break;							//  create another String not having word "dec" with its  
													    //  number but have the functional result of making its number
														//  to a decimal,if is not decimal  
						
				
						}
						
				}
				
			}
			
			
		}
		
		
		
		if(find) 
		{
			sample="dec"+sample;	//  add a specific String in front of the word in order to understand that there
		    find=false;				//  was a convert to decimal number
		}
		
		
		
		while(sample.contains("bt")) 
		{
			find=true;
			
			int left=sample.indexOf("bt");			// find the position of "bt" (basically of b which has for next
													// character the character 't') in the expression
			
			for(int i=left+2;i<sample.length();i++)			// the same work as for finding String "dec"
			{												
				
				if((Expression.isOperator(sample.charAt(i))&&i!=left+2)||i==sample.length()-1) 
				{
					int lim=i;								             // lim shows the right limit for cutting the
					if(!Expression.isOperator(sample.charAt(i)))lim++; 	 // the String,determines the least significant	
																		 // of the number (if we are in the last 
																	     // character from the expression or  	
					if(isBtNumber(sample.substring(left+2,lim))) 		 // on an operator of the expression)
					{
						sample=sample.substring(0,left)+sample.substring(left+2,sample.length());
						break;
					}						// if is a Balanced number then there is no need for converting it
					else 					//  just remove word "bt"
						{
						String expr="";
						
						expr=sample.substring(0,left);	
						
						BalancedTernary bt=new BalancedTernary();
						
						sample=expr+bt.int_to_bt(Integer.parseInt(sample.substring(left+2,lim)))
						
						+sample.substring(lim,sample.length());
						break;			
									// if isn't a bt then we convert the string to an integer and then we 
									// we create a bt number and replace the old(with the special symbol) with the
									// new one
						}								// plus 2 because "bt" contains two characters
					 									// so we want the first character after 't' so 2.
						
				}
				
			}
		}
		
		
		if(find)sample="bt"+sample;    // if the program had a "bt" special expression then  it adds a special
									   // symbol in front of it in order to understand that there was a bt convention	
		
		boolean assign=false;		// a boolean variable for determining if the program finds an assign statement "="
		
		
		
		if(sample.indexOf('=')!=-1)			// not while (the program do not accept two or more symbols of '=')
		{
			assign=true;
			
			int left=sample.indexOf('=');		// left is the position of character '='
			
					
			
			for(int i=left;i<sample.length();i++) 
			{	
				if((Expression.isOperator(sample.charAt(i))&&i!=left+1)||i==sample.length()-1)
				{    
							//  if the program finds an operator which is not directly right of it or if the program
							//  arrives at the last character of the String
					
					if(!isBtNumber(sample.substring(left+1,i+1))) return "error";   // not allowed to assign a decimal
																					// number to memory(can't store it)
					
					else  { 
						   int lim=i;											  // lim is the limit on where should 
						   if(Expression.isOperator(sample.charAt(i)))lim--;	  //  the program cut the number if 
						   this.store(estimate(sample.substring(left+1,lim+1)));  //  the program arrives at the last	
						  }														  //  character or finds an operator	
																				  // at lest 2 positions right of '='	
					break;
				}								//  store the number to memory after estimating its number
			}
			sample=sample.substring(0,left)+sample.substring(left+1,sample.length());
			
			
		}
		
		
		if(assign)sample="mem"+sample;   // add a String expression to understand that that the program have stored
										 // a number successfully and that the program mustn't store the result of
										 // this expression but to let saved the current the number which was stored
										 // previously
		
		sample=Expression.operatorFormat(sample);		// call Method operatorFormat to format any duplicate 
														// operators(plus or minus) such as "--","+-","++" etc.	
		return sample;
	}
	
	
	/**
	 * This method is used in order to cut the loading zeroes of a number(the leading zeroes which are in front of a
	 * BalancedTernary number and their value for the peoples eye is estimated as non.(for computers although are 
	 * important)
	 * 
	 * @return  void
	 * @since 4/8/2018
	 */
	public void cut_leading_zeroes() {
		
		String s=this.btnum;
		
		for(int i=0;i<s.length();i++) {
			
			char c=s.charAt(i);
			
			if(c=='1'||c=='N') {
				s=s.substring(i,s.length());			//  the first not zero digit which finds shows the piece of 
				break;									// the expression that has the loading zeroes
			}
			
			if((i==s.length()-1)&&s.charAt(i)=='0')
			s="0";
		}
		
		this.btnum=s;
			
	}
	
	
	/**
	 *  This method calculates all the arithmetic function in an expression with only BalancedTernary numbers and not
	 *  with decimal or any other bases numbers!It uses {@link BalancedTernary#add(BalancedTernary)},
	 *  {@link BalancedTernary#subtract(BalancedTernary)},{@link BalancedTernary#multiply(BalancedTernary)},
	 *  {@link BalancedTernary#divide(BalancedTernary)},{@link BalancedTernary#remainder(BalancedTernary)},
	 *  {@link BalancedTernary#estimate(String)},{@link BalancedTernary#cut_leading_zeroes()}
	 * 
	 * @param t (a String[] array which has all the number and arithmetic symbols-operators separated in each field of
	 *        the array(the plus and minus as part of signs are kept with its numbers)
	 *        
	 * @return nothing -type void
	 * @since 4/8/2018
	 */
	public  BalancedTernary calc_bt(String[] t)
	{		
		BalancedTernary num=this.estimate(t[0]);	// all the arithmetic functions/actions are made from left to right
													// and each time a BalancedTernary variable num is used in order
		int i=0;									// to make the actions from left to right(priority from left)
													// and store the numbers in object num(btnum)
		while(i<t.length-2) {
		
			
		if(t[i+1].contains("+")) num=num.add(estimate(t[i+2]));
			
		if(t[i+1].contains("-")) num=num.subtract(estimate(t[i+2]));
		
		if(t[i+1].contains("/")) num=num.divide(estimate(t[i+2]));
		
		if(t[i+1].contains("*")) num=num.multiply(estimate(t[i+2]));
		
		if(t[i+1].contains("%")) num=num.remainder(estimate(t[i+2]));
		
		i+=2;
		}
		
		num.cut_leading_zeroes();		// before returning the value the program cuts the leading zeroes
		
		return num;
	
	}
	
	
	/**
	 * This method plays a big role in coordinating the checking ,editing and calculating the result of the expression 
	 * which is given by static method {@link BalancedTernary#REPL()}.It returns the edited expression ,which is 
	 * a number(BalancedTernary or decimal depend on what functions were meant to be made) or a message of error if the 
	 * syntax of the expression is not correct  
	 * 
	 * @param text (a String expression which is given from static method {@link BalancedTernary#REPL()},which user 
	 * 	      gave basically and represents a mathematical expression
	 * 
	 * @return nothing -type void
	 * @since 4/8/2018
	 */
	public String evaluate(String text)
	{
		String expr="";
		expr=Expression.removeSpaces(text);			// call method removeSpaces to remove the spaces from expression
													// which is given.Also call method operatorFormat to simplify the
		expr=Expression.operatorFormat(expr);		// expression based to their negative and positive operators
													// (from class Expression)
		if(!Expression.checkSyntax(expr))return "Error: I don't understand: "+text;
	
																// call method checSyntax(from class Expression) 
																// for checking any Syntax errors
		
		 expr=this.formalise(expr);        // call method formalise to edit special symbol appears and examine some
		 								   //  cases on special symbols(if are correct)
		 
		if(expr.equals("error"))return "Error: I don't understand: "+text;
		
		
		boolean storedmem=false;	   // a boolean variable representing if a number had already stored in memory
		
		boolean usespecialsymbol=false;  // a boolean variable for showing if a special symbol was used(dec or bt)
		
		boolean decexpr=false;          // a boolean varibale to show if an expression was meant by user to be decimal 
								        // expression
		
		
		 if (expr.startsWith("mem")) 	 // number 3 indicates the first place after word "mem" which is useful for us
			{
				expr=expr.substring(3,expr.length());
				storedmem=true;							// program stored a number in memory
			}
		 
			
		 if (expr.startsWith("dec"))  // number 3 indicates the first place after word "dec" which is useful for us
			{
				expr=expr.substring(3,expr.length());
				decexpr=true;							// the expression seems to be decimal
				usespecialsymbol=true;					// expression has special symbols like "dec"
			}
		 
		 if (expr.startsWith("bt")) 	// number 2 indicates the first place after word "dec" which is useful for us
			{
				expr=expr.substring(2,expr.length());
				decexpr=false;  						// the expression seems not to be decimal
				usespecialsymbol=true;					// expression has special symbols like "bt"
			}
		 
		 
		 
		 if(!usespecialsymbol)			// if special symbols haven't used then there is the need of finding what the
		 {	 							// the expression is(decimal or BalancedTernary)
		  for(int i=0;i<expr.length();i++)
		   {	
			  char c=expr.charAt(i);
			  
			 if(c>='2'&&c<='9') 			// if program finds any number between 2 and 9 then it means that it has
			 {								// the willing of computing numbers in decimal else not.Extra point in 
				 decexpr=true;				// helping user as a decimal calculator
				 break;
			 }
			 
		   }
		 }
		 
		 
		 if(!decexpr)    // if the expression must have only BalancedTernary numbers
		 {	
			 for(int i=0;i<expr.length();i++)
			 {
				 char c=expr.charAt(i);		// checking if there are any characters which are not BT
				 
				 if(c>='2'&&c<='9') return "Error: Expression contains decimal and BT numbers";
			 }
			 
			
			 String[] table=Expression.splitExpression(expr);   // call splitExpression from class Expression
			 													// in order to split the String into an array
			 													// with numbers and the operators which will be  
			 for(int i=0;i<table.length;i++)					// used for arithmetic actions
			 {   
				 
				 if(table[i].contains("/")||table[i].contains("%"))
				 {
					 BalancedTernary bt=new BalancedTernary("0");		// if there is a division (remaining or not)
					 													// program checks if the number after this 
					 													// operator is equal to zero ( 0 )
					 if(this.estimate(table[i+1]).bt_to_int()==0)
						 return "Error: The expression is not computable : NaN";
				 }
			 }
			 
			 
			 BalancedTernary num=this.calc_bt(table);		// calculate the BalacedTernary result of the expression
			 												// with the method calc_bt
			 
			 
			 if(!storedmem)							// if program didn't stored any number due to assign symbol 
				 this.store(num);					// operation ('='),then program stores the result in memory
			 
			 return num.toString();
			 
		 }
		 else {
			 		// this part of this method is executed for calculating decimal numbers
			 	
			 	// checks if there are any non-decimal numbers in expression 
			 
			 for(int i=0;i<expr.length();i++)					
			  if(expr.charAt(i)=='N') return "Error: Expression contains decimal and BT numbers";
			 	
		 	 	
			 	 String[] table=Expression.splitExpression(expr); 	// takes an array with all the numbers and 
			 	 												  	// arithmetic symbols of the expression
				 for(int i=0;i<table.length;i++)
				 {
					 if(table[i].contains("/")||table[i].contains("%"))		// check the divisions if are acceptable
					 {
						 if(Integer.parseInt(table[i+1])==0) 
							 return "Error: The expression is not computable : NaN";
							 
					 }
				 }
			 	
				 int num=Expression.calc_dec(table);		//  calculate the value of the expression in decimal 
				 
				 return (num+"");
			 	
		 
		 }
		 
		 
		
		
	}	
	
	
	
	/**
	 * This method is the only method of this class and generally of the package which communicates with the user.
	 * It receives from the user the expression and gives it to evaluate method to evaluate its result.
	 *  It uses the methos{@linkplain BalancedTernary#evaluate(String)}.
	 * 
	 * @return nothing -type void
	 * @since 4/8/2018
	 */
	public static void REPL() 
	{
		
		
		Scanner Stdin=new Scanner(System.in);		//create a scanner object for receiving input in machine-computer
		
		
		
		BalancedTernary memoryuse=new BalancedTernary("mem");
		
		boolean stop=false;			//  bollean variable to tell whenever the user wants to quit
		
		do {
			String input="";
			
			input=Stdin.nextLine();
			
			if(input.contains("quit")) 	// if the input contains the word quit then the program terminates
				stop=true;
			else 
				System.out.println(memoryuse.evaluate(input));  // call method evaluate
			
		}while(!stop);
		
	System.out.println("Done.");   // show that the program have stopped
	
	}
	
	
	
	
	
	
	
}
