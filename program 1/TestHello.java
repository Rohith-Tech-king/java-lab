package com.scsvmv.javalab;
import com.scsvmv.javalab.hello.Hello;

/*
 *TestHello class
 *Demonstrates passing command-line arguments
 */

public class TestHello
{
   public static void main(String[] args)
 {
  //Using Hello class from parent package
    Hello simpleHello=new Hello();
    simpleHello.wish();

  //using Hello class from child package
    com.scsvmv.javalab.hello.Hello h=new com.scsvmv.javalab.hello.Hello();

  //check for command-line arguments
    if(args.length>0)
    {
       h.wish(args[0]);         //pass CLI argument
       h.wishWithDate(args[0]);
    }
    else
    {
      System.out.println("usage:");
      System.out.println("java com.scsvmv.javalab.TestHello<name>");
      System.out.println("Example:");
      System.out.println("java com.scsvmv.javalab.TestHello Student");
    }
  }
}  
