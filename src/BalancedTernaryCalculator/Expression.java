package BalancedTernaryCalculator;


/**
 * The role of this class is more supporting than autonomous!Although it can be expanded and used as a general class
 * and as a class-type of objects!At this point it is used for supporting the editing and checking the Strings which 
 * contain BalancedTernary numbers and also making and calculating some functions on decimal numbers!It has methods to
 * check the syntax of a String-expression in order to have only the right characters-symbols-numbers etc...
 * This class is used to help class {@link BalancedTernary#}  
 * 
 * @author Valentinos Pariza(vpariz01)
 * @category Balanced_Ternary_Numbers
 * @version 1.0
 * @since 4/8/2018
 *
 */
public class Expression {
	
	
	/**
	 *  This method calculates all the basic arithmetic functions in a decimal expression.It uses methods such as
	 *  {@link Integer#parseInt(String)}
	 * 
	 * @param t (a String[] array which has all the number and arithmetic symbols-operators separated in each field of
	 *        the array(the plus and minus as part of signs are kept with its numbers)
	 *        
	 * @return nothing -type void
	 * @since 6/8/2018
	 */
	public static  int calc_dec(String[] t)
	{
		int num=Integer.parseInt(t[0]);
		int i=0;
		
		while(i<t.length-2) {		// stop when i>=t,length-2 because we examine to characters in front of the 
									// current.Program convert String representations of the numbers to
									// integer
			
		if(t[i+1].contains("+")) num+=Integer.parseInt(t[i+2]);;
			
		if(t[i+1].contains("-")) num-=Integer.parseInt(t[i+2]);
		
		if(t[i+1].contains("/")) num/=Integer.parseInt(t[i+2]);
		
		if(t[i+1].contains("*")) num*=Integer.parseInt(t[i+2]);
		
		if(t[i+1].contains("%")) num%=Integer.parseInt(t[i+2]);
		
		i+=2;
		}
		
		
		return num;
	
	}
	
	
	/**
	 * Checks the Syntax of an expression using various checks for determining if generally the expression is not
	 * acceptable.It uses methods such as {@link String#indexOf(int)},{@link String#substring(int, int)},
	 * {@link String#contains(CharSequence)},{@link String#length()},{@link String#charAt(int)}
	 * {@link String#equals(Object)},{@link Expression#isOperator(char)},{@link Expression#checkOperators(String)
	 * 
	 * @param text (String representation of the expression) 
	 * @return boolean (true if the expression is correct in operators,otherwise false)
	 * @since 4/8/2018
	 */
	public static boolean checkSyntax(String txt) {
		
		int assign=0;
		int i=0;
		
		if((txt.contains("bt")&&txt.contains("dec"))||txt.charAt(txt.length()-1)=='=')return false;
		if(txt.charAt(0)=='/'||txt.charAt(0)=='*'||txt.charAt(0)=='%')return false;
		
		// symbol = is not accepted to be at the end and beginning and also it is not acceptable to use "bt" and "dec" 
		// functions both in one expression 
		
		
		while(i<txt.length())
		{
			
			boolean check=false;  // check is a boolean variable which will help skip the check if the program finds
								  // a special symbol like "mem","dec","bt" 	
			
			char c=txt.charAt(i);      // character of current examination
			
			
			
			if(c=='d')			//  starting from plus 3 because of the string "dec"
			 {  
				
			     if((txt.substring(i,i+3).equals("dec"))&&(i+3<=txt.length()-1))   // checking if there is
					{															   // the word "dec"	
			    	if((i>0)&&!isOperator(txt.charAt(i-1)))return false;			// and also have a character	
			        char b=txt.charAt(i+3);								   			// next to it and before 'd' if 
																					// there is an operator
						 if(b=='/'||b=='*'||b=='%'||b=='d') return false;	// if it has an operator as shown 
						 													// next to it is error,or have another
						 													// dec expression
							check=true;
							i+=2;			// make check=true because program has found special symbol and  also 
											// increase i by 2(because the word "dec" has three characters
											// but at the end is increasing always by one,so at the end it will be 3
											// and so characters of "dec" are skipped
			    	 }
			     else return false;
			     
			 }
			
			
			
			
			if(c=='b')					//  starting from plus 2 because of the string "bt"
			 {
				
			     if( (txt.substring(i,i+2).equals("bt"))&&(i+2<=txt.length()-1))
					{														// checking if there is the word "bt"
			    	 														// and also have a character next to it and
			    	 														//  before 'b'if there is an operato
						
			    	 if((i>0)&&!isOperator(txt.charAt(i-1)))return false;
			    	 
						char b=txt.charAt(i+2);
						
						if(b=='/'||b=='*'||b=='%'||b=='b') return false;	// if it has an operator as shown 
																			// next to it is error,or have another
																			// "bt" expression
						
						check=true;
						i+=1;					// make check=true because program has found special symbol and  also 
												// increase i by 1(because the word "bt" has two characters
												// but at the end is increasing always by one,so at the end it will be 
												// 2 and so characters of "dec" are skipped
						
					} 
			     else return false;
			     
			    
			     
			 }
		
			
			
			
			if(c=='m')
			 {
				
			    if(( (i<txt.length()-2)) && (txt.substring(i,i+3).equals("mem")))  // check if the word "mem" exists 
			      {																   // and also
						check=true;								//  starting from plus  because of the string "mem"
						i+=2;
												// make check=true because program has found special symbol and  also 
												// increase i by 2(because the word "mem" has three characters
												// but at the end is increasing always by one,at the end it will be 3
												// and so characters of "mem" are skipped
			      }
			    else return false;
			}
			
			
			if(c=='=')
			{
				check=true;
				assign++;				//	it is not allowed to have to times the assign symbol function
				
				if(assign>1||i==txt.length()-1)return false;		// if assign is at the end
				
				if(i+1<=txt.length()-1) {			// if there is any character after '='
					
				char b=txt.charAt(i+1);
				
				if(b=='/'||b=='*'||b=='%') return false;			// not have these symbols after it
				
				if((i>0)&&!isOperator(txt.charAt(i-1)))return false;
				}
				
			}
			
			
			if((c>'9'||c<'0')&&(c!='N')&&!isOperator(c)&&!check) return false;   //check if the expression contains
																				 // all the characters of boolean check	
			i++;																 // all number digits,operator and 
																				 // character 'N'
			
																			// increase i
			
		}
		
	
		if(!checkOperators(txt))return false;		// check if the operators are correct
		
		return true;
			
		
		}
		
	
	
	
	/**
	 * this method is used to check that there are not arithmetic operators one side to other.More specific checks it
	 * checks if it has less than 3 operators  side to side and if it has two ,they must to be '+' or '-'.
	 * It uses methods such as {@link Expression#isOperator(char)}
	 * 
	 * @param text (String representation of the expression) 
	 * @return boolean (true if the expression is correct in operators,otherwise false)
	 * @since 5/8/2018
	 */
	private static boolean checkOperators(String text) {
																// not to have an operator in last position
		
		if(Expression.isOperator(text.charAt(text.length()-1)))return false;
		
		for(int i=0;i<text.length()-2;i++) 
		{
		  char a=text.charAt(i);			// three characters one for current position ,for next and for after next
		  char b=text.charAt(i+1);
		  char c=text.charAt(i+2);

		  if(isOperator(a)&&isOperator(b)&&isOperator(c)) return false;		// not to have three operators side by side
			
		  if(isOperator(a)&&(b=='/'||b=='%'||b=='*')) return false;  
		  															    
		}
		
		return true;
		
	}
	
	
	/**
	 * this method eliminates continues minus('-') and plus('+') operators by the mathematical rule which say that
	 *  -+=- / +-=- / --=+ / ++=+ 
	 * 
	 * @param text (String representation of the expression) 
	 * @return boolean (true if the expression is correct in operators,otherwise false)
	 * @since 6/8/2018
	 */
     public static String operatorFormat(String txt) {
		
		String expr=txt;
		
		int i=0;
		
		while(expr.contains("++")||expr.contains("--")||expr.contains("+-")||expr.contains("-+")) 
		{                                                                       
         
			if(expr.charAt(i)=='+'&&(expr.charAt(i+1)=='-'||expr.charAt(i+1)=='+') ) 
			{    
					expr=expr.substring(0,i)+expr.substring(i+1,expr.length());	
						i=0;							
									// eliminate operators make a simplified String 
			} 						// and start checking from the beginning
			else if(expr.charAt(i)=='-')
			{
				if(expr.charAt(i+1)=='-') 
				  {   
					expr=expr.substring(0,i)+ "+"+expr.substring(i+2,expr.length());	
					i=0;
				  }
				else if(expr.charAt(i+1)=='+')
				 {
					expr=expr.substring(0,i)+"-"+expr.substring(i+2,expr.length());	
					i=0;
				 }
				
				else i++;  // increase the i when the program did not find two sign operators side by side
			}
			else i++;
			
			
			
		}
			
		
		return expr;
			
		
	}
	
	
     /**
 	 * Removes spaces(blank characters) from an expression 
 	 * 
 	 * @param txt (String representation of the expression) 
 	 * @return a String simplified by spaces
 	 * @since 4/8/2018
 	 */
	public static String removeSpaces(String txt) {
		
		for(int i=0;i<txt.length();i++) {		// cut expression in the position on which a space was found ignoring
												// the space at the end
			if(txt.charAt(i)==' ') return txt.substring(0, i)+removeSpaces( txt.substring(i+1,txt.length()) );
		}
		return txt;
		
	}
	
	
	/**
	 * This method checks if a character of an expression ,specifically , is a mathematical basic operator
	 * 
	 * @param c (a character ) 
	 * @return boolean (true if the expression is correct in operators,otherwise false)
	 * @since 3/8/2018
	 */
	public static boolean isOperator(char c) {
		
		if(c=='+'||c=='-'||c=='*'||c=='/'||c=='%') return true;
		
			return false;
	}
	

	/**
	 *This method takes a String expression and split it to pieces,which pieces are numbers and basic mathematical 
	 *operators
	 * 
	 * @param expr (String representation of the expression) 
	 * @return a String[] array in which numbers and basic mathematical operators are assigned 
	 * @since 4/8/2018
	 */
	public static String[] splitExpression(String expr)		
	{
		int lim=-1;						// set it as minus for functional method use
		
		String[] t=new String[expr.length()];
		int k=0;								// variable k shows the addresses on an array which thing are stored on
		
		
			
		for(int i=1;i<expr.length();i++)   // start from one because program checks one character behind
		{
			char c=expr.charAt(i);
			char d=expr.charAt(i-1);
			
			if(isOperator(c)&&!isOperator(d))			// if program finds an operator which do not have an operator 
			{  											// behind means that program have found a number
				t[k]=expr.substring(lim+1,i);
				t[k+1]=expr.substring(i,i+1); 
				lim=i;							//  take the last position of operator in order to know where to cut
				k+=2;							// the next number
				
				
				
				
			}
			if(i==expr.length()-1)t[k]=expr.substring(lim+1,i+1);   // if program arrived at last position
		}
		
		if(expr.length()==1) {			//  if expression is only one number
			t[0]=expr;
			 
		}
		
		String[] s=new String[k+1];    // program creates an array to put all the field of the last array 
									   // to the corresponding fields of the new array,which array is used	
		for(int i=0;i<s.length;i++)    // to shorten at maximum the array	
		{
	       s[i]=t[i];
	       
		}
		
		
		return s;
				
	}


	/**
	 * This is the main method of class Expression and general of all the package which only calls the method 
	 * {@link BalancedTernary#REPL()} for performing the program
	 * @param args (general array for String input by command line)
	 * @since 7/8/2018
	 */
	public static void main(String[] args) 
	{
		BalancedTernary.REPL();
		
	}




}
