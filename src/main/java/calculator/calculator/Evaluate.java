package calculator.calculator;

public class Evaluate
{
   public boolean isOperand(String s)
   {
      @SuppressWarnings("unused")
	double a=0;
      try
      {
         a=Double.parseDouble(s);
      }
         catch (Exception ignore)
         {
            return false;
         }
      return true;
   }
		 
   public boolean isOperator(String token)
   {
      String tokenList="+-*/^";
      if (tokenList.indexOf(token)>=0) 
         return true;
      return false;
   }
		 
   public String applyOperator(String mathNum1, String mathNum2, String operator)
   {
	   // parse string to double
      double num1=Double.parseDouble(mathNum1);
      double num2=Double.parseDouble(mathNum2);
      double result = 0;
   	 
      if (operator.equals("+"))
      {
         result = num1+num2;
      }
      else if (operator.equals("-"))
      {
         result = num1-num2;
      }
      else if (operator.equals("*"))
      {
         result = num1*num2;
      }
      else if (operator.equals("/"))
      {
         result = num1/num2;
      }
      else if (operator.equals("^"))
      {
    	  result = Math.pow(num1, num2);
      }
   	 
      return ""+ result;  // convert result to String
   }
	
		//Postfix Evaluation function
    public double evaluate(String postfix)
   {
     // java.util.Stack<String> stack=new java.util.Stack<String>();
   	 Stack <String> stack = new Stack<String>();
      java.util.StringTokenizer st = new java.util.StringTokenizer(postfix);
      while (st.hasMoreTokens())
      {
         String token=st.nextToken();
         if (isOperand(token))
         {
            stack.push(token);
         }
         if (isOperator(token))
         {
            String mathNum2=stack.pop();
            String mathNum1 = stack.pop();
            String value=applyOperator(mathNum1,mathNum2,token);
            stack.push(value);
         }
      }
   	     
      String result = stack.pop();
      return Double.parseDouble(result);
   }
		 
}