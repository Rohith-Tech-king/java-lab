import textops.StringOperations;
import textops.StringBufferOperations;

public class Enter2Strings
{
  public static void main(String[] args)
  {
    if(args.length !=2)
    {
      System.out.println("Usage:java Enter2Strings<str1><str2>");
      return;
    }

    String str1=args[0];
    String str2=args[1];
    

    //instantiate and call StringOpeartions
    StringOperations stringOps=new StringOperations(str1,str2);
    stringops.exploreStringMethod();

    //instantiate and call StringBufferOperations
    StringBufferOperations sbOps=new stringBufferoperations(str1);
    sbops.exploreStringBufferMethods(str2);
   }
} 
