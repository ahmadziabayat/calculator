package calculator.calculator;

 public class Convert
{
   public boolean isOperand(String g)
   {
      @SuppressWarnings("unused")
	double d=0;
      try
      {
         d=Double.parseDouble(g);
      }
         catch (Exception ignore)
         {
            return false;
         }
      return true;
   }
	 
   public  boolean isOperator(String g)
   {
      String operatorList="+-*/^";
      return operatorList.indexOf(g)>=0;
   }
	 
   public int previous(String op)
   {
      int previous=0;
      if (op.equals("+"))
      {
         previous=1;
      }
      else if (op.equals("-"))
      {
         previous=1;
      }
      else if (op.equals("*"))
      {
         previous=2;
      }
      else if (op.equals("/"))
      {
         previous=2;
      }
      else if (op.equals("^"))
      	 previous = 3;
      return previous;
   }
	 
		    // Convention code 
   	public String convert(String infix)
   	{     

	  Stack <String> stack = new Stack <String>();
      java.util.StringTokenizer t = new java.util.StringTokenizer(infix);
      String postfix="";
      String space=" ";
      while (t.hasMoreTokens())
      {
         String token = t.nextToken();
         if (isOperand(token))
         {
            postfix = postfix + token + space;
         }
         else if (isOperator(token))
         {
            while (!stack.empty() && previous(stack.peekTOS())>=previous(token))
            {
               postfix += stack.pop() + space;
            }
            stack.push(token);
         }
         else if (token.equals("("))
         {
            stack.push(token);
         }
         else if (token.equals(")"))
         {
            while (!stack.peekTOS().equals("("))
            {
               postfix += stack.pop() + space;
            }
            stack.pop();  //Pop left parentacy 
         }
      }
      while (!stack.empty())
      {
         postfix += stack.pop() + space;
      }
      return postfix;
   }

		   
}

